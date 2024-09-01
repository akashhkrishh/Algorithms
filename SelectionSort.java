package org.example;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] a){

        int len = a.length;
        int minIndex=0;
        for (int i = 0; i < len ; i++) {
            minIndex =i;
            for (int j = i+1; j < len; j++) {
                if(a[minIndex] > a[j]){
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;

        }

    }

    public static void main(String[] args) {

        int[] a = new int[]{21,3,1,2};
        sort(a);
        System.out.println(Arrays.toString(a));

    }
}
