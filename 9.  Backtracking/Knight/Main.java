public class Main {

    public static void kNightPaths(int matrix[][], int i, int j, int N, int moveNum) {
        if(i < 0 || j < 0 || j >= N || i >= N || matrix[i][j] != 0) {
            return;
        }

        matrix[i][j] = moveNum;

        if(moveNum == N*N - 1) {
            for(int x=0; x<N; x++) {
                for(int y=0; y<N; y++) {
                    System.out.print(matrix[x][y] + " ");
                }
                System.out.println();
            }
            return;
        }

        kNightPaths(matrix, i - 2, j + 1, N, moveNum + 1);
        kNightPaths(matrix, i - 1, j + 2, N, moveNum + 1);
        kNightPaths(matrix, i + 1, j + 2, N, moveNum + 1);
        kNightPaths(matrix, i + 2, j + 1, N, moveNum + 1);
        kNightPaths(matrix, i + 2, j - 1, N, moveNum + 1);
        kNightPaths(matrix, i + 1, j - 2, N, moveNum + 1);
        kNightPaths(matrix, i - 1, j - 2, N, moveNum + 1);
        kNightPaths(matrix, i - 2, j - 1, N, moveNum + 1);

        matrix[i][j] = 0;
    }

    public static void main(String args[]) {
        kNightPaths(new int[8][8], 0, 0, 8, 0);
    }
}