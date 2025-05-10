public class Main {

    public static boolean isSorted(int arr[], int i) {

        if(i == arr.length - 1) {
            return true;
        }

        if(arr[i] > arr[i + 1]) {
            return false;
        }    

        return isSorted(arr, i + 1);
    }

    public static void main(String args[]) {
        int arr[] = {2, 4, 6, 8, 10};

        if(isSorted(arr, 0)) { 
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }
}