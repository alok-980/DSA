public class Main {

    public static int firstOccur(int arr[], int i, int key) {
        if(i == arr.length) {
            return -1;
        }

        if(arr[i] == key) {
            return i;
        }

        return firstOccur(arr, i+1, key);
    }

    public static void main(String args[]) {
        int arr[] = {2, 4, 6, 8, 10, 12, 8, 10};

        int key = 8;

        System.out.println(firstOccur(arr, 0, key));
    }
}