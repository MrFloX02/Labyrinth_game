package mazegame.hint;

import mazegame.board.*;
import mazegame.entity.mob.*;

public class Direction extends Hint{

// Constructor 
	
	/** creates a direction type Hint
	 * 
	 * @param win the winCell
	 */
	public Direction(Cell win) {
		super(win);
	}
	
// Methods 
	
	/** uses the Hint by giving the direction towards WinCell
	 * @param m the targeted player
	 */
	public void use(Player m) {
		String rep;
		int dns = m.getCell().getCoordy() - this.win.getCoordy(); // distance nord-sud
		int dew = m.getCell().getCoordx() - this.win.getCoordx(); // distance est-ouest
		
		if (dns>=dew) {  // si la distance nord-sud est plus importante que l'est-ouest, on va diriger le joueur vers le nord ou le sud"
			if (dns<0) { // si cette distance est "negative" la quete se trouve vers le sud"
				rep = "le sud";
			}else {rep = "le nord";} // sinon elle est au nord
		}
		else { // idem sur l'axe est-ouest 
			if (dew<0) {
				rep = "l'est";
			}else {rep = "l'ouest";}
			
		}
		
		System.out.printf("Votre quête se trouve vers %s\n",rep);
	}
	
	/** @see java.lang.Object#toString()
	 *  
	 */
	public String toString() {
		return "Object that will give a hint about the direction towards WinCell";
	}

}
