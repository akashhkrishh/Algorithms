package org.example;

public class BinarySearchReccursion {

    public static int binarySearch(int[] arr, int target,int start, int end){
        if (start > end)
            return -1;
        int mid = start+(end-start)/2;
        if ( arr[mid] == target )
            return mid;
        else if ( arr[mid] < target )
            return binarySearch(arr, target, mid+1, end);
        else
            return binarySearch(arr, target, start, mid-1 );
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,4,52,245,222};
        int target = 5;
        int index = binarySearch(arr,target,0,arr.length-1);
        System.out.println(index);

    }
}
