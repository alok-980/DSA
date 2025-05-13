public  class Main {

    public static void occuredIndices(int arr[], int key, int idx) {
        if(idx == arr.length) {
            return;
        }

        if(key == arr[idx]) {
            System.out.print(idx + " ");
        }

        occuredIndices(arr, key, idx + 1);
    }

    public static void main(String args[]) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};

        int key = 2;

        occuredIndices(arr, key, 0);
    }
}