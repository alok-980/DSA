import java.util.*;

public class Main {
    
    // Function to search a key in matrix and find min & max values
    public static int search(int matrix[][], int key) {
        int max = Integer.MIN_VALUE; // To store max value in matrix
        int min = Integer.MAX_VALUE; // To store min value in matrix

        // Traverse each element in the 2D matrix
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                
                // Check if current element matches the key
                if(key == matrix[i][j]) {
                    System.out.println("Key value matched at index = " + i + ", " + j);
                    return 1;
                }

                // Update max if current element is greater
                if(max < matrix[i][j]) {
                    max = matrix[i][j];
                }

                // Update min if current element is smaller
                if(min > matrix[i][j]) {
                    min = matrix[i][j];
                }
            }
        }

        // Key not found in matrix
        System.out.println("Key is not matched at any index");

        // Print min and max values from matrix
        System.out.println("Max value = " + max + " & Min value = " + min);
        return -1;
    }

    public static void main(String args[]) {
        int matrix[][] = new int[3][3];

        int n = matrix.length, m = matrix[0].length;
        Scanner sc = new Scanner(System.in);

        // Input for 2D matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output the 2D matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Call the search function with key to search
        search(matrix, 9);
    }
}
