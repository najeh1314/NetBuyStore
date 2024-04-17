package CoCG;

	public class SudokuSolver {
	    private static final int SIZE = 9;
	    private int[][] board;

	    public SudokuSolver(int[][] board) {
	        this.board = board;
	    }

	    public boolean solve() {
	        for (int row = 0; row < SIZE; row++) {
	            for (int col = 0; col < SIZE; col++) {
	                if (board[row][col] == 0) {
	                    for (int num = 1; num <= SIZE; num++) {
	                        if (isValid(row, col, num)) {
	                            board[row][col] = num;
	                            if (solve()) {
	                                return true;
	                            } else {
	                                board[row][col] = 0;
	                            }
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    private boolean isValid(int row, int col, int num) {
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

	    public void printBoard() {
	        for (int row = 0; row < SIZE; row++) {
	            for (int col = 0; col < SIZE; col++) {
	                System.out.print(board[row][col] + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        int[][] board = {
	            {5, 3, 0, 0, 7, 0, 0, 0, 0},
	            {6, 0, 0, 1, 9, 5, 0, 0, 0},
	            {0, 9, 8, 0, 0, 0, 0, 6, 0},
	            {8, 0, 0, 0, 6, 0, 0, 0, 3},
	            {4, 0, 0, 8, 0, 3, 0, 0, 1},
	            {7, 0, 0, 0, 2, 0, 0, 0, 6},
	            {0, 6, 0, 0, 0, 0, 2, 8, 0},
	            {0, 0, 0, 4, 1, 9, 0, 0, 5},
	            {0, 0, 0, 0, 8, 0, 0, 7, 9}
	        };

	        SudokuSolver solver = new SudokuSolver(board);
	        if (solver.solve()) {
	            solver.printBoard();
	        } else {
	            System.out.println("No solution exists");
	        }
	    }
	}

