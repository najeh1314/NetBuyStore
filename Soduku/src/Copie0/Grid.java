package Copie0;

import java.util.Random;

public class Grid {
	Random random = new Random();
	static final int  maxNbFilling =70;
	private int[][] Grid;

	//setter of Grid's cells (sel a value val in Cell[i][j])
	public void setCell(int val, int i, int j) {
		if(val<10 && val>0 && i<9 && i>=0 && j>=0 && j<9) {
			Grid[i][j] = val;
		}
	}
	//constructeur grille initialement contient que des zeros
	public Grid() {
		Grid = new int[9][9];
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				Grid[i][j] = 0;
	}
	
	public void initiateRandom(int nbFilling) {
		if(nbFilling<maxNbFilling) {
			for(int n =1; n <= nbFilling; n++) {
				boolean exit =false;
				do {
			        int i = random.nextInt(9);
			        int j = random.nextInt(9);
			        if(Grid[i][j] ==0) {
			        	int val = random.nextInt(9) + 1;
			        	if(cellValide(val, i, j)) {
			        		Grid[i][j] = val;
			        		exit = true;
			        	}
			        }
				}while(!exit);
			}
		}
	}
	
	public void affiche() {
		System.out.print("+============+============+============+\n");
		for(int i = 0; i <9; i++) {
			System.out.print("|");
			for(int j=0; j<9; j++) {
				if(Grid[i][j] == 0)
					System.out.print("   ..   ");
				else
					System.out.printf("   %d   ",Grid[i][j]);
				if((j+1)%3 ==0)
					System.out.print("|");
					
			}
			System.out.print("\n");
			if((i+1)%3==0)
				System.out.print("+============+============+============+\n");
			else
				System.out.print("+--------------------+--------------------+--------------------+\n");
		}
	}

	public boolean cellValide(int val, int row, int col) {
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

	public int[] nextEmptyCell() {
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				if(Grid[i][j] == 0)
					return (new int[]{i,j});
		return null;
	}
	
}