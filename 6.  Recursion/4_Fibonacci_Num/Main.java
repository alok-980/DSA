public class Main {

    public static int printFib(int n) {

        if(n == 0 || n == 1) {
            return n;
        }

        int Fnm1 = printFib(n - 1);
        int Fnm2 = printFib(n - 2);
        int Fn = printFib(n-1) + printFib(n-2); 
        return Fn;     
    }

    public static void main(String args[]) {
        int n = 6;

        System.out.println(printFib(n));
    }
}