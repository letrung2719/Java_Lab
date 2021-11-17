package matrixcaculator;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author TrungLT
 */
public class MatrixCaculator {

    private static final Scanner in = new Scanner(System.in);

    //kiem tra gia tri choice cua menu
    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Please input again!");
            }
        }
    }

    //kiem tra gia tri cac phan tu cua ma tran
    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Value of matrix is digit");
            }
        }
    }

    //kiem tra 2 ma tran cung cap
    private static boolean check2Matrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;

        return !(row1 != row2 || col1 != col2);
    }

    //nhap du lieu vao ma tran
    private static int[][] inputMatrix(int n) {
        System.out.print("Enter Row Matrix" + n + ": ");
        int row = checkInputInt();
        System.out.print("Enter Column Matrix" + n + ": ");
        int col = checkInputInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]: ");
                matrix[i][j] = checkInputInt();
            }
        }
        return matrix;
    }

    //hien thi ma tran
    private static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    //phep cong 2 ma tran
    private static void additionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Addition --------");
        matrix1 = inputMatrix(1);
        matrix2 = inputMatrix(2);
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");

        if (check2Matrix(matrix1, matrix2) == false) {
            System.out.println("The 2 matrices are not at the same level!");
            return;
        }

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int[][] matrixResult = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        displayMatrix(matrixResult);
    }

    //phep tru 2 ma tran
    private static void subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Subtraction --------");
        matrix1 = inputMatrix(1);
        matrix2 = inputMatrix(2);
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");

        if (check2Matrix(matrix1, matrix2) == false) {
            System.out.println("The 2 matrices are not at the same level!");
            return;
        }

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int[][] matrixResult = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        displayMatrix(matrixResult);
    }

    //phep nhan 2 ma tran
    private static void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Multiplication --------");
        matrix1 = inputMatrix(1);
        matrix2 = inputMatrix(2);
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (col1 != row2) {
            System.out.println("Can't multiple");
            return;
        }

        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(matrixResult);
    }

    //menu
    private static void display() {
        int[][] matrix1 = null;
        int[][] matrix2 = null;
        while (true) {
            System.out.println("=========MATRIX CALCULATOR=========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    additionMatrix(matrix1, matrix2);
                    break;
                case 2:
                    subtractionMatrix(matrix1, matrix2);
                    break;
                case 3:
                    multiplicationMatrix(matrix1, matrix2);
                    break;
                case 4:
                    return;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        display();
    }
}
