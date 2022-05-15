package mazegame.hint;

import mazegame.board.Cell;
import mazegame.entity.mob.*;

public class VolOiseau extends Hint {

// Constructor
	
	/** creates a point to point distance type Hint
	 * 
	 * @param win the winCell
	 */
	public VolOiseau(Cell win) {
		super(win);
		// TODO Auto-generated constructor stub
		/* recupere la position de la WinCell et la position du joueur/personnage donnant l'indice,
		* calcul la distance à vol d'oiseau avec la formule sqrt( (y1-y2)² + (x1-x2)² )
		* renvoie l'arrondi pour avoir une idée de la distance à vol d'oiseau de la WinCell
		*/
	}
	
	
// Methods
	
	/** uses the hint by giving the point to point distance
	 * @param m the targeted player
	 * 
	 */
	public void use(Player m) {
		Cell c = m.getCell();
		long dist = Math.abs(c.getCoordx()-this.win.getCoordx()) + Math.abs(c.getCoordy()-this.win.getCoordy());
		// nombre de cases separant les cases Win et celle du mob
		
		System.out.printf("Votre quête se trouve à %d cases à vol d'oiseau d'ici\n", dist);
	}
	
	/** @see java.lang.Object#toString()
	 *  
	 */
	public String toString() {
		return "Object that will give a hint about the point to point distance to WinCell";
	}

}
