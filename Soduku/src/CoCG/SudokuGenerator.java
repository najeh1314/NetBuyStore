package CoCG;
import java.util.*;

public class SudokuGenerator {
    private static final int SIZE = 9;
    private static final Random RANDOM = new Random();

    public static int[][] generateSudoku() {
        int[][] board = new int[SIZE][SIZE];
        solveSudoku(board);
        return board;
    }

    private static boolean solveSudoku(int[][] board) {
        List<Integer> cells = new ArrayList<>();
        for (int i = 0; i < SIZE * SIZE; i++) {
            cells.add(i);
        }
        Collections.shuffle(cells);

        return solveSudokuHelper(board, cells);
    }

    private static boolean solveSudokuHelper(int[][] board, List<Integer> cells) {
        if (cells.isEmpty()) {
            return true;
        }

        int cell = cells.remove(cells.size() - 1);
        int row = cell / SIZE;
        int col = cell % SIZE;

        List<Integer> numbers = new ArrayList<>();
        for (int num = 1; num <= SIZE; num++) {
            numbers.add(num);
        }
        Collections.shuffle(numbers);

        for (int num : numbers) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudokuHelper(board, cells)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        cells.add(cell);
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sudoku = generateSudoku();
        printBoard(sudoku);
    }
}

