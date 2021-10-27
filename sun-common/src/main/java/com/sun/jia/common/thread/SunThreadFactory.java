package com.sun.jia.common.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class SunThreadFactory implements ThreadFactory {
    private static Logger log = LoggerFactory.getLogger(SunThreadFactory.class);

    private final AtomicLong threadNumber = new AtomicLong(1);

    private final String namePrefix;

    private final boolean daemon;

    private static final ThreadGroup threadGroup = new ThreadGroup("Teddy");

    public static ThreadGroup getThreadGroup() {
        return threadGroup;
    }

    public static SunThreadFactory create(String namePrefix, boolean daemon) {
        return new SunThreadFactory(namePrefix, daemon);
    }

    public static boolean waitAllShutdown(int timeoutInMillis) {
        ThreadGroup group = getThreadGroup();
        Thread[] activeThreads = new Thread[group.activeCount()];
        group.enumerate(activeThreads);
        Set<Thread> alives = new HashSet<Thread>(Arrays.asList(activeThreads));
        Set<Thread> dies = new HashSet<Thread>();
        log.info("Current ACTIVE thread count is: {}", alives.size());
        long expire = System.currentTimeMillis() + timeoutInMillis;
        while (System.currentTimeMillis() < expire) {
            classify(alives, dies, new ClassifyStandard<Thread>() {
                @Override
                public boolean satisfy(Thread thread) {
                    return !thread.isAlive() || thread.isInterrupted() || thread.isDaemon();
                }
            });
            if (alives.size() > 0) {
                log.info("Alive teddy threads: {}", alives);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                    // ignore
                }
            } else {
                log.info("All teddy threads are shutdown.");
                return true;
            }
        }
        log.warn("Some teddy threads are still alive but expire time has reached, alive threads: {}",
                alives);
        return false;
    }

    private static interface ClassifyStandard<T> {
        boolean satisfy(T thread);
    }


    public static ThreadPoolExecutor createThreadPool(String namePrefix, Integer corePoolSize) {
        return createThreadPool(corePoolSize, null, null, namePrefix);
    }

    public static ThreadPoolExecutor createThreadPool(String namePrefix, Float blockRate) {
        return createThreadPool(null, null, blockRate, namePrefix);
    }

    public static ThreadPoolExecutor createThreadPool(Integer corePoolSize, Integer maximumPoolSize, Float blockRate, String namePrefix) {
        //系统一般阻塞在0.8 -0.9 即可
        float defaultBlockRate = 0.8f;
        if (blockRate == null || blockRate < 0 || blockRate >= 1) {
            blockRate = defaultBlockRate;
        }

//      int corePoolSize = 8 ;
//      int maximumPoolSize = 24;
        //核心线程数 = CPU核数 / （1-阻塞系数）     例如阻塞系数 0.8，CPU核数为4  则核心线程数为20
        if (corePoolSize == null) {
            int defaultPoolSize = (int) (Runtime.getRuntime().availableProcessors() / (1 - blockRate));
            corePoolSize = defaultPoolSize;
        }

        //计算最大线程数 , 最大线程数，基本上是起到得作用是队列满了后，才会用最大线程数来创建线程处理数据
//      2.分析下线程池处理的程序是CPU密集型，还是IO密集型
//      CPU密集型：核心线程数 = CPU核数 + 1
//      IO密集型：核心线程数 = CPU核数 * 2
        //https://www.cnblogs.com/dennyzhangdd/p/6909771.html?utm_source=itdadao&utm_medium=referral
        //阻塞系数得计算   阻塞任务得时间/（阻塞任务时间+计算时间）
        if (maximumPoolSize == null) {
            maximumPoolSize = corePoolSize * 2;
        }
//        new LinkedBlockingQueue<Runnable>()  无界队列
//        new ArrayBlockingQueue<Runnable>(64)   有界队列
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(64),
                SunThreadFactory.create(namePrefix, true),
                new ThreadPoolExecutor.CallerRunsPolicy());

    }

    private static <T> void classify(Set<T> src, Set<T> des, ClassifyStandard<T> standard) {
        Set<T> set = new HashSet<>();
        for (T t : src) {
            if (standard.satisfy(t)) {
                set.add(t);
            }
        }
        src.removeAll(set);
        des.addAll(set);
    }

    private SunThreadFactory(String namePrefix, boolean daemon) {
        this.namePrefix = namePrefix;
        this.daemon = daemon;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(threadGroup, runnable,//
                threadGroup.getName() + "-" + namePrefix + "-" + threadNumber.getAndIncrement());
        thread.setDaemon(daemon);
        if (thread.getPriority() != Thread.NORM_PRIORITY) {
            thread.setPriority(Thread.NORM_PRIORITY);
        }
        return thread;
    }
}
