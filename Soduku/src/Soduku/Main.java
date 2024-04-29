package Soduku;
public class Main {
	public static void main(String[] args) {
		Main instance = new Main();
		int[][] grid9x9 = instance.create();
		//*************************************************
		instance.setCell(grid9x9, 5, 0, 0);
		instance.setCell(grid9x9, 3, 0, 1);
		instance.setCell(grid9x9, 4, 0, 4);
		instance.setCell(grid9x9, 6, 1, 0);
		instance.setCell(grid9x9, 7, 1, 3);
		instance.setCell(grid9x9, 9, 1, 4);
		instance.setCell(grid9x9, 1, 2, 1);
		instance.setCell(grid9x9, 9, 2, 2);
		instance.setCell(grid9x9, 8, 2, 7);
		instance.setCell(grid9x9, 8, 3, 0);
		instance.setCell(grid9x9, 5, 3, 4);
		instance.setCell(grid9x9, 2, 3, 8);
		instance.setCell(grid9x9, 7, 4, 1);
		instance.setCell(grid9x9, 9, 4, 5);
		instance.setCell(grid9x9, 4, 4, 8);
		instance.setCell(grid9x9, 2, 5, 0);
		instance.setCell(grid9x9, 6, 5, 4);
		instance.setCell(grid9x9, 1, 5, 8);
		instance.setCell(grid9x9, 8, 6, 1);
		instance.setCell(grid9x9, 7, 6, 6);
		instance.setCell(grid9x9, 9, 6, 7);
		instance.setCell(grid9x9, 6, 7, 2);
		instance.setCell(grid9x9, 3, 7, 3);
		instance.setCell(grid9x9, 5, 8, 4);
		instance.setCell(grid9x9, 1, 8, 7);
		//**********************************************************
		instance.affiche(grid9x9);
		instance.solveSoduku(grid9x9);
		instance.affiche(grid9x9);
	}
	
	public boolean  solveSoduku(int[][] grille) {
		if((nextEmptyCell(grille)[0] == -1) && (nextEmptyCell(grille)[1] == -1)){
			affiche(grille);
			return true;
		}
		else {
			int row  = nextEmptyCell(grille)[0];
			int col = nextEmptyCell(grille)[1];
			for(int i=1; i<10; i++) {
				if(cellValide(grille, i, row, col)) {
					grille[row][col] = i;
					if(solveSoduku(grille))
						return true;
					grille[row][ col] = 0;
				}
			}
			return false;
		}

}
	public  void add(int[][] solutionEl, int[][][] solutionTab) {
        // Copiez les anciennes matrices dans le nouveau tableau
        for (int i = 0; i < solutionTab.length; i++) {
            System.arraycopy(solutionTab[i], 0, solutionTab[i], 0, solutionTab[i].length);
        }
        // Ajoutez la nouvelle matrice à la fin du tableau
        solutionTab[solutionTab.length] = solutionEl;   
	}
	
	public  int[][] create() {		
		int[][] Grid;
		Grid = new int[9][9];
		return Grid;
	}

	public  void setCell(int[][] Grid, int val, int i, int j) {
		if(val<10 && val>0 && i<9 && i>=0 && j>=0 && j<9) {
			Grid[i][j] = val;
		}
	}

	public  int[] nextEmptyCell(int[][] Grid) {
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				if(Grid[i][j] == 0)
					return (new int[]{i,j});
		return new int[]{-1, -1};
	}
	
	public  void affiche(int[][] grille) {
		System.out.print("\n");
		System.out.print("+---------+---------+---------+\n");
		for(int i = 0; i <9; i++) {
			System.out.print("|");
			for(int j=0; j<9; j++) {
				if(grille[i][j] == 0)
					System.out.print(" .. ");
				else
					System.out.printf(" %d ",grille[i][j]);
				if((j+1)%3 ==0)
					System.out.print("|");		
			}
			System.out.print("\n");
			if((i+1)%3==0) {
				System.out.print("+---------+---------+---------+\n");}}
		System.out.print("\t***\t***\t***");
		
	}
	
	public  boolean cellValide(int[][] Grid, int val, int row, int col) {
		if(row<9 && row>=0 && col<9 && col>=0 && val<10 && val>0) {
			//verification with row's element of the grid:
			for(int i = 0; i <9; i++)
				if(Grid[i][col] == val)
					return false;
			//verification with colomn's element of the grid:	
			for(int i = 0; i <9; i++)
				if(Grid[row][i] == val)
					return false;
			//verification with the 3-box element of the grid:
			for(int i = 0; i <3; i++)
				for(int j=0; j<3; j++)
					if(Grid[3*(row/3)+i][3*(col/3)+j] == val)
						return false;
			return true;
		}
		return false;
	}
	

}