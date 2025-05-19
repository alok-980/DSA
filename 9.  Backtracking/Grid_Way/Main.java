public class Main {

    public static int gridWay(int i, int j, int n, int m) {
        if(i == n-1 && j == m-1) {
            return 1;
        } else if(i == n || j == m) {
            return 0;
        }

        int w1 = gridWay(i+1, j, n, m);
        int w2 = gridWay(i, j+1, n, m);

        return w1 + w2;
    }
    public static void main(String args[]) {
        int n=3, m=3;

        System.out.println(gridWay(0, 0, n, m));
    }
}