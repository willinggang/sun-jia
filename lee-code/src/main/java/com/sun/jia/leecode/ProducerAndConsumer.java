package com.sun.jia.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumer {

    private Integer MAX_COUNT = 100;
    private Queue<Integer> queue = new LinkedList<>();

     class Producer extends Thread{
         @Override
         public void run() {
             super.run();
             produce();
         }

         private void produce(){
             while (true){
                 synchronized (queue){
                     while (queue.size()==MAX_COUNT){
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
                         sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }
     }

     class Consumer extends Thread{
         @Override
         public void run() {
             super.run();
         }

         private void consume(){
             while (true){
                 synchronized (queue){
                     while (queue.size()==0){
                         queue.notify();
                         try {
                             queue.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
                 queue.poll();
                 queue.notify();
                 try {
                     sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }

     }

    public static void main(String[] args) {
        ProducerAndConsumer pac = new ProducerAndConsumer();
        Producer producer = pac.new Producer();
        Consumer consumer = pac.new Consumer();
        producer.start();
        consumer.start();
    }
}
