public class Main {

    public static void printSubString(String str, int si) {

        if(si == str.length()) {
            return;
        }

        StringBuilder sb = new StringBuilder("");

        for(int i=si; i<str.length(); i++) {
            sb.append(str.charAt(i));
            System.out.print(sb + " ");
        }
        System.out.println();

        printSubString(str, si+1);
    }

    public static void main(String args[]) {
        String str = "hello";

        printSubString(str, 0);
    }
}