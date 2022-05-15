package mazegame.hint;

import java.util.Random;

import mazegame.board.Board;
import mazegame.board.Cell;
import mazegame.entity.mob.Player;

public class Zone extends Hint {
	private int rayon =3;
	private Board board;
// Constructor 
	
	/** creates a zone type Hint
	 * 	
	 * @param win the win Cell
	 * @param rayon le rayon en Cell de la Zone
	 * @param board le tableau
	 */
	public Zone(Cell win,int rayon,Board board) {
		super(win);
		this.rayon=rayon;
		this.board=board;
		// TODO Auto-generated constructor stub
		/* créé une liste des cellules dans un certain rayon (3) autour de la WinCell,
		 * choisit aleatoirement une de ces cellules,
		 * annonce que la WinCell se trouve dans une des cellules autour de la cellule choisie
		 */
	}
	
// Methods
	/**
	 * donne une cas au hasard autour de la zone d'arrivee
	 * 
	 * @param m le Joueur ciblee
	 */
	public void use(Player m) {
		// creation du tableau des cellules dans la zone
		Cell[] zone = new Cell[(2*(this.rayon-1))^2];
		int xwin=this.win.getCoordx();
		int ywin=this.win.getCoordy();
		int k =0;
		for (int i=0;i<this.rayon;i++) {
			for (int j=0;j<this.rayon;j++) {
				if(i+j<3 && i+j!=0 && xwin-i>0 && xwin+i<this.board.getWidth() && ywin-i>0 && ywin+i<this.board.getLength() ) {
					zone[k]=this.board.getTheCells()[xwin-i][ywin-j];
					k++;
					if (j!=0) {
						zone[k]=this.board.getTheCells()[xwin-i][ywin+j];
						k++;						
					}
					if (i!=0) {
						zone[k]=this.board.getTheCells()[xwin+i][ywin-j];
						k++;
						if (j!=0) {
							zone[k]=this.board.getTheCells()[xwin+i][ywin+j];
							k++;						
						}
					}
				}
				
			}
		}
		
		// algo random qui va sortir une des cellules
		
		Random rand = new Random();
		int r= rand.nextInt(zone.length);
		Cell choisie = zone[r];
		System.out.printf("vous devriez chercher autour de la case %n , %n\n",choisie.getCoordx(),choisie.getCoordy());
	}
	
	/** 
	 * @see java.lang.Object#toString()
	 *  
	 */
	public String toString() {
		return "Object that will give a hint about a zone around WinCell";
	}

}
