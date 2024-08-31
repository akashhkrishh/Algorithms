public class BubbleSort {
    static void printArray(int[] arr){
        for (int data:arr){
            System.out.print(data+" ");
        }
        System.out.println();

    }
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < (len-i-1); j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{21,344,2,322,1,13};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
