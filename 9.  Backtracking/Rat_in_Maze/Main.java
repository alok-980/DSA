public class Main {

    public static void findAllPaths(int matrix[][], int i, int j, int N, boolean visited[][], String psf) {
        if(i < 0 || j < 0 || j >= N || i >= N || matrix[i][j] == 0 || visited[i][j] == true) {
            return;
        }

        if(i == N-1 && j == N-1) {
            System.out.println("We reached destination! = " + psf);
            return;
        }

        visited[i][j] = true;

        findAllPaths(matrix, i - 1, j, N, visited, psf+ "U");
        findAllPaths(matrix, i + 1, j, N, visited, psf+ "D");
        findAllPaths(matrix, i, j - 1, N, visited, psf+ "L");
        findAllPaths(matrix, i, j + 1, N, visited, psf+ "R");

        visited[i][j] = false;
    }

    public static void main(String args[]) {
        int matrix[][] = {
            {1, 1, 1, 1},
            {0, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 0, 1, 1}
        };

        int N = matrix.length;

        boolean visited[][] = new boolean[N][N];

        findAllPaths(matrix, 0, 0, N, visited, "");
    }
}