import java.util.*;

public class Main {

    // Function to print the matrix in spiral order
    public static void printSpiral(int matrix[][]) {
        int strRow = 0;                       // starting row index
        int endRow = matrix.length - 1;       // ending row index
        int strCol = 0;                       // starting column index
        int endCol = matrix[0].length - 1;    // ending column index

        // Loop until all elements are traversed
        while(strRow <= endRow && strCol <= endCol) {

            // Top boundary (left to right)
            for(int j = strCol; j <= endCol; j++) {
                System.out.print(matrix[strRow][j] + " ");
            }

            // Right boundary (top to bottom)
            for(int i = strRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // Bottom boundary (right to left)
            for(int j = endCol - 1; j >= strCol; j--) {
                // Avoid double printing if only one row is left
                if(strRow == endRow) break;
                System.out.print(matrix[endRow][j] + " ");
            }
            
            // Left boundary (bottom to top)
            for(int i = endRow - 1; i >= strRow + 1; i--) {
                // Avoid double printing if only one column is left
                if(strCol == endCol) break;
                System.out.print(matrix[i][strCol] + " ");
            }

            // Move boundaries inward
            strCol++;
            strRow++;
            endCol--;
            endRow--;
        }
    }

    public static void main(String args[]) {
        // Sample 4x4 matrix
        int matrix[][] = {
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}
                         };

        printSpiral(matrix);
    }
}
