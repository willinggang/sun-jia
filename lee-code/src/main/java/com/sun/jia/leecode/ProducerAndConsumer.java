package com.sun.jia.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerAndConsumer {


    private Integer maxCount = 100;
    private List<Integer> queue = new ArrayList<Integer>();

    public class Producer extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == maxCount) {
                        queue.notify();
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class  Consumer extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.size() ==0){
                        queue.notify();
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.remove(1);
                    queue.notify();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

/*    public static void main(String[] args) {
        ProducerAndConsumer pac = new ProducerAndConsumer();
        Producer producer = pac.new Producer();
        Consumer consumer = pac.new Consumer();
        producer.start();
        consumer.start();
    }*/
}
