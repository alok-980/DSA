import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String args[]) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int count = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<coins.length; i++) {
            if(coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.print("total (min) coins used = " + ans);
    }
}