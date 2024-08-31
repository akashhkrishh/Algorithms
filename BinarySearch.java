public class BinarySearch {

    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = start+(end-start)/2;
            if (target == arr[mid])
                return mid;
            else if ( target > arr[mid])
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,4,52,245,222};
        int target = 5;
        int index = binarySearch(arr,target);
        System.out.println(index);

    }
}
