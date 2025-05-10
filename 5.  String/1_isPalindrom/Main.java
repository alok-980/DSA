public class Main {

    public static boolean isPlaindrom(String str) {
        int start = 0, end = str.length() - 1;

        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start ++;
            end --;
        }

        return true;
    }

    public static void main(String args[]) {
        String str = "racecar";

        if(isPlaindrom(str)) {
            System.out.println("Plaindrom");
        } else {
            System.out.println("is not Plaindrom");
        }
    }
}