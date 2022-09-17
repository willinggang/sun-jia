package com.sun.jia.leecode.sort;

import static com.sun.jia.leecode.ReCopy.isBadVersion;

public class LeeCodeSort {

    /*二分查找*/
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 第一个错误版本
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }


    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int write = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[write] = nums[left] * nums[left];
                left++;
                write--;
            } else {
                result[write] = nums[right] * nums[right];
                write--;
                right--;
            }
        }
        return result;
    }


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] tNums = new int[n];
        for (int i = 0; i < n; i++) {
            int ni = (i + k) % n;
            tNums[ni] = nums[i];
        }
        System.arraycopy(tNums, 0, nums, 0, n);
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l <= r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            }
            if (numbers[l] + numbers[r] > target) {
                r--;
            }
            if (numbers[l] + numbers[r] < target) {
                l++;
            }
        }

        return new int[]{-1, -1};
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - i - 1] = temp;
        }
    }

    public void swap(char[] s, int l, int r) {

    }

    public String reverseWords(String s) {
        StringBuffer buffer = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                buffer.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                buffer.append(" ");
            }
        }
        return buffer.toString();
    }

    public String reverseWords2(String content) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int length = content.length();
        while (i < length) {
            int start = i;
            while (i < length && content.charAt(i) != ' '){
                i++;
            }
            for (int p = start;p<i;p++){
                sb.append(content.charAt(start+i-p-1));
            }
            while (i<length&&content.charAt(i) == ' '){
                sb.append(" ");
                i++;
            }
        }
        return sb.toString();
    }


    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
        }
        if (second == null) {
            return first.next;
        } else {
            return first;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;


    }

}
