import java.util.ArrayList;

public class Main {

    public static boolean findPairSum(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size() - 1;

        while(lp != rp) {
            if((list.get(lp) + list.get(rp)) == target) {
                System.out.println(lp + " " + rp);
                return true;
            } else if((list.get(lp) + list.get(rp)) < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=6; i++) {
            list.add(i);
        }

        int target = 8;

        System.out.println(findPairSum(list, target));
    }
}