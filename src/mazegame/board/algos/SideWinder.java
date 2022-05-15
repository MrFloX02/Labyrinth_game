package mazegame.board.algos;

import mazegame.board.*;
import java.util.*;
/**
 * Un Board généré par SideWinder créé un quadrillage de cellules et va les parcourir de gauche à droite et de haut en bas,
 * à chaque cellule, il choisira aleatoirement de "detruire un mur" au sud ou à l'est,
 * s'il fait le choix à l'est, il considera la cellule comme voisine et repetera le processus sur cette même cellule,
 * s'il fait le choix au sud, il choisira aleatoirement une des cellules voisines "à l'horizontale" (cad sur la même ligne),
 * et detruira son mur au sud pour ajouter la cellule du sud en tant que voisine.
 * Le processus se répète jusqu'à la dernière ligne où chaque mur est sera détruit, par conséquent les algorithmes SideWinder forment des labyrinthes dont la dernière ligne ne possède aucun mur vertical.
 */
public class SideWinder extends Board{

	public SideWinder(int width, int length) {		
		super(width,length);
		
		/*
		# --------------------------------------------------------------------
		#   Sidewinder algorithm
		# --------------------------------------------------------------------
		*/
		
		for (int j=0; j<this.length-1;j++) {
			int x1=0;
			int x2=0;
			while (x1<this.width) {
				Random r1=new Random();
				if (r1.nextBoolean() && x2!=this.width-1){ // Si r1 est vrai et que x2 n'est pas egale a la longueur max -1
					theCells[x2][j].addNeighborCells(theCells[x2+1][j]); //
					theCells[x2+1][j].addNeighborCells(theCells[x2][j]); // On casse du mur Est
					x2++;
				}
				else { // r1 faux pas de bol
					Random rand= new Random();
					int r2= rand.nextInt(x2-x1+1)+x1;
					theCells[r2][j].addNeighborCells(theCells[r2][j+1]); // On casse du mur Sud
					theCells[r2][j+1].addNeighborCells(theCells[r2][j]); // depuis une case precedente aléatoire
					x1=x2+1;
					x2=x1;
				}
			}
		}
		int j=this.length-1;
		for (int i=0; i<this.width-1;i++) { // force la dernière ligne à n'avoir aucun mur
			theCells[i][j].addNeighborCells(theCells[i+1][j]);
			theCells[i+1][j].addNeighborCells(theCells[i][j]);
		}
		
	}
	
}
