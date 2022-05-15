package mazegame.board.algos;

import mazegame.board.*;
import java.util.*;
/**
 * Un Board généré par RandomFusion va creer un quadrillage de cellules, chacune ayant un indice unique
 * L'algorithme va choisir aleatoirement une cellule ainsi qu'une direction dans laquelle il va "detruire un mur"
 * partageant ainsi son indice avec la cellule adjacente afin que celles-ci soient considérées voisines et par extension accessibles l'une par l'autre.
 * On réitère le processus jusqu'à ce qu'il n'y ait qu'un seul indice commun entre chaque cellule, elles seront donc toutes accessibles.
 */
public class RandomFusion extends Board{

	public RandomFusion(int width, int length) {		
		super(width,length);
		
		Random side = new Random();
		int initSum = this.length*this.width;
		int indexMax = 0;
		int indexMin = 0;
		
		
		/*
		# --------------------------------------------------------------------
		#   Randomized fusion algorithm
		# --------------------------------------------------------------------
		*/
		
		
		while(initSum > 0) {
		
		for (int y=0; y<this.length-1;y++) {
			
			for (int x=0; x<this.width-1;x++) { 
				
				initSum -= theCells[x][y].getIndex();
				
				boolean die = side.nextBoolean();
					
				if(die && !theCells[x][y].isNeighbor(theCells[x+1][y])) { // Si Vrai on casse à droite 
					theCells[x][y].addNeighborCells(theCells[x+1][y]); //
					theCells[x+1][y].addNeighborCells(theCells[x][y]); // On casse du mur de droite	
					indexMax = Math.max(theCells[x][y].getIndex(),theCells[x+1][y].getIndex());
					indexMin = Math.min(theCells[x][y].getIndex(),theCells[x+1][y].getIndex());
						
						
					if(this.theCells[x][y].getIndex() == indexMax){	
						this.theCells[x][y].setIndex(indexMin); 
					}
				
						
				}
				
				else if(!die && !theCells[x][y].isNeighbor(theCells[x][y+1])) { // Sinon on casse en bas 
						theCells[x][y].addNeighborCells(theCells[x][y+1]); // On casse du mur du bas
						theCells[x][y+1].addNeighborCells(theCells[x][y]);	
						indexMax = Math.max(theCells[x][y].getIndex(),theCells[x][y+1].getIndex());
						indexMin = Math.min(theCells[x][y].getIndex(),theCells[x][y+1].getIndex());
						
					
						
				if(this.theCells[x][y].getIndex() == indexMax){
					this.theCells[x][y].setIndex(indexMin);
				}
				}
			}
			}
		}

		int j=this.length-1;
		for (int i=0; i<this.width-1;i++) { // force la dernière ligne x à n'avoir aucun mur
			theCells[i][j].addNeighborCells(theCells[i+1][j]);
			theCells[i+1][j].addNeighborCells(theCells[i][j]);
		}
		int k=this.width-1;
		for (int i=0; i<this.length-1;i++) { // force la dernière ligne y à n'avoir aucun mur
			theCells[k][i].addNeighborCells(theCells[k][i+1]);
			theCells[k][i+1].addNeighborCells(theCells[i][j]);
		}
		
	}
	
}
