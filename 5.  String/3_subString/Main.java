import java.util.*;

public class Main {

    public static String substring(String str, int si, int ei) {
        String str2 = "";

        for(int i=si; i<ei; i++) {
            str2 += str.charAt(i);
        }

        return str2;
    }

    public static void main(String args[]) {
        String str = "HelloWorld";

        // inbuild method for substring
        System.out.println(str.substring(0, 5));

        System.out.println(substring(str, 1, 5));
    }
}