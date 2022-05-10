package com.sun.jia.leecode;

public class SortAlgorithm {

    public static void bubbleSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    public static void selectSort(int array[]){
        if (array == null||array.length ==0){
            return;
        }
        int n = array.length;
        for (int i = 0;i<n;i++){
            int index = i;
            for (int j=i+1;j<array.length;j++){
                if (array[index]>array[j]){
                    index = j;
                }
            }

            if (i!=index){
                swap(array,i,index);
            }
        }
    }


    public static void insertSort(int[] array){
        if (array == null||array.length == 0){
            return;
        }
        for (int i=1;i<array.length;i++){
            int j = i;
            int temp = array[i];
            for (;j>0;j--){
                if (array[j-1]>temp){
                    array[j] = array[j-1];
                }else {
                    break;
                }
            }
            array[j]= temp;

        }
    }


    public static void quickSort(int[] array,int start,int end){
        if (start<end){
            int key = array[start];
            int i = start;
            for (int j = start+1;j<=end;j++){
                if (key>array[j]){
                    swap(array,j,++i);
                }
            }
            array[start] = array[i];
            array[i]= key;
            quickSort(array,start,end-1);
            quickSort(array,i+1,end);
        }
    }


    public static void swap(int array[], int i, int j) {

    }
}
