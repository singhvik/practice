package vikram.strings.MineSweeper;

import java.util.Scanner;

/**
 *
 * https://techdevguide.withgoogle.com/paths/foundational/coding-question-minesweeper/#!
 */
public class MineSweeper {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(6,10,5);
        matrix.printMatrixOriginal();
        System.out.println("-----------------------");
        String str;
        Scanner scanner = new Scanner(System.in);
        int row, col;
        boolean gameOver = false;
        do {
            matrix.printMatrix();
            System.out.println();
            System.out.print("Enter the row: ");
            row = scanner.nextInt();
            System.out.println();
            System.out.print("Enter the col: ");
            col = scanner.nextInt();
            gameOver = matrix.pick(row,col);
            if(gameOver){
                System.out.println("Kaboom!!!!, You picked a mine");
                break;
            }
        }while (row!=100);

    }
}
