/* Ryan Gadalkin : HW6
   Reference/Citation - https://developers.google.com/optimization/cp/queens
                      - http://www.java.achchuthan.org/2012/02/n-queens-problem-in-java.html
**/

import java.util.Scanner;

class Chessboard {
    private boolean[][] squarePosition;
    private int maxQueens;
    private int solutions;

    Chessboard(int maxQueens) { // Create fresh size-specified board and stats
        this.squarePosition = new boolean[maxQueens][maxQueens];
        this.maxQueens = maxQueens;
        this.solutions = 0;

        for (int i = 0; i < maxQueens; i++) { // Remove all pieces from board if any left over.
            for (int j = 0; j < maxQueens; j++)
                squarePosition[i][j] = false;
        }
    }

    int getTotalSolutions() {
        return this.solutions;
    }

    private void setTotalSolutions(int amount) {
        this.solutions = amount;
    }

    private void setQueenPosition(int row, int column, boolean state) {
        this.squarePosition[row][column] = state;
    }

    private boolean checkAngles(int row, int column) {
        int i, j;

        // Check X-Axis (Row = Horizontal)
        for (i = 0; i < maxQueens; i++) // Check all possible rows
            if (squarePosition[row][i]) return false;

        // Check Y-Axis (Column = Vertical)
        for (j = 0; j < maxQueens; j++) // Check all possible columns
            if (squarePosition[j][column]) return false;

        // Check diagonally left
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
            if (squarePosition[i][j]) return false;

        // Check diagonally right
        for (i = row, j = column; i < maxQueens && j >=0; i++, j--)
            if (squarePosition[i][j]) return false;

        return true;
    }

    boolean doQueenSimulator(int column) {
        if (column >= maxQueens)
            return true;

        for (int row = 0; row < maxQueens; row++) { // Obtain all possible combinations before finishing if possible
            if (checkAngles(row, column)) { // Check all angles based on square positions
                setQueenPosition(row, column, true); // Place queen piece on board (clear for adding)

                if (doQueenSimulator(column + 1)) {
                    setTotalSolutions(getTotalSolutions() + 1);
                    displayChessboard();
                }
            }
            setQueenPosition(row, column, false); // Movement obstructed
        }
        return false;
    }

    private void displayChessboard() {
        System.out.printf("Solution #%d\n", getTotalSolutions());
        for (int i = 0; i < maxQueens; i++) {
            for (int j = 0; j < maxQueens; j++) {
                System.out.printf("%4c", squarePosition[i][j] ? 'Q' : '-');
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class Homework6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("How large would you like the chessboard to be for N-Queens Checker : ");

        int size = Integer.parseInt(input.next());
        System.out.println();

        Chessboard cb = new Chessboard(size);
        cb.doQueenSimulator(0);
        System.out.printf("Total Solutions for a %d x %d board = %d\n", size, size, cb.getTotalSolutions());
    }
}