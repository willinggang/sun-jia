package com.sun.jia.leecode;

import java.util.concurrent.ConcurrentHashMap;

public class ReCopy {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = (right-left)/2+left;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left = mid +1;
            }else if (nums[mid]>target){
                right = mid -1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个坏的版本号
     * @param n
     * @return
     */
    public static int findFirstBadVersion(int n){
        int left = 1;
        int right = n;
        while (left<right){
            int mid = left+(right-left)/2;
            if (isBadVersion(mid)){
                right = mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }

    public static int findInsertPos(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right = mid -1;
            }
        }
        return left;
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right =nums.length-1;
        int write = right;
        int[] retNums = new int[nums.length-1];
        while (left<right){
            if (nums[left]*nums[left]<nums[right]*nums[right]){
                retNums[write] = nums[right]*nums[right];
                write--;
                right--;
            }else {
                retNums[write] = nums[left]*nums[left];
                write--;
                left++;
            }
        }
        return retNums;
    }


    // 1 2 4 0 3 0
    // 1 2 4 3 0 0
    //1 0 0 3 4 5 6 7 0 8 9 10
    //1 3 0 0 4 5 6 7 0 8 9 10
    //

    public static boolean isBadVersion(int n){
        return n>5;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left=0;
        int right=0;
        while (right<n){
            if (nums[right]!=0){
                //交换值
                left++;
            }
            right++;
        }
    }

    public String reverseWords(String s) {
        StringBuffer buffer = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i<length){
            int start = i;
            while (i<length&&s.charAt(i)!=' '){
                i++;
            }

            int p = i;
            while(p>=start){
                buffer.append(s.charAt(p));
                p--;
            }
            while (i<length&&s.charAt(i)==' '){
                i++;
                buffer.append(" ");
            }
        }
        return buffer.toString();
    }


/*

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
* */

}
