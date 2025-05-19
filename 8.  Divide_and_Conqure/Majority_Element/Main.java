public class Main {

    public static int majorityEle(int arr[]) {
        int winner = arr[0], lead = 1;

        for(int i=1; i<arr.length; i++) {
            if(arr[i] == winner) {
                lead++;
            } else if(lead > 0) {
                lead--;
            } else {
                winner = arr[i];
                lead = 1;
            }
        }

        return winner;
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 1, 2, 2, 1, 2};

        System.out.println(majorityEle(arr));
    }
}