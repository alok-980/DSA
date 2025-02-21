import java.util.*;

public class Main {
    //search in matrix
    public static int search(int matrix[][], int key) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < matrix.length; i++) {
            for(int  j = 0; j < matrix[0].length; j++) {
                if(key == matrix[i][j]) {
                    System.out.println("Key value matched at index = " + i + ", " + j);
                    return 1;
                }

                //finding max value in matrix
                if(max < matrix[i][j]) {
                    max = matrix[i][j];
                }

                //finding min value in matrix
                if(min > matrix[i][j]) {
                    min = matrix[i][j];
                }
            }
        } 
        System.out.println("Key is not matched at any index");

        System.out.println("Max value = " + max + " & Min value = " + min);
        return -1;
    }

    public static void main(String args[]) {
        int matrix[][] = new int[3][3];

        int n = matrix.length, m = matrix[0].length;

        Scanner sc = new Scanner(System.in);

        //taking input in 2D matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        //output the element of 2D matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //callint the function to search the key
        search(matrix, 9);
    }
}