public class Main {

    public static void backtrack(int arr[], int i, int val) {

        if(i == arr.length) {
            printArray(arr);
            return;
        }

        arr[i] = val;
        backtrack(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = new int[5];

        backtrack(arr, 0, 1);

        printArray(arr);
    }
}