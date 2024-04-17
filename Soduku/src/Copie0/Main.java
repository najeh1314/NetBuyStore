package Copie0;

public class Main {

	public static void main(String[] args) {
		Grid Grille9x9 = new Grid();
		solveSoduku(Grille9x9);
		Grille9x9.affiche();	
	}
	public static boolean  solveSoduku(Grid grille) {
		if(grille.nextEmptyCell().equals(null)) {
			grille.affiche();
			return true;
		}
		else {
			for(int i=1; i<10; i++) {
				if(grille.cellValide(i, grille.nextEmptyCell()[0], grille.nextEmptyCell()[1])) {
					grille.setCell(i, grille.nextEmptyCell()[0], grille.nextEmptyCell()[1]);
					if(solveSoduku(grille))
						return (solveSoduku(grille));
					grille.setCell(0, grille.nextEmptyCell()[0], grille.nextEmptyCell()[1]);
				}
			}
			return false;
		}
	}
}
