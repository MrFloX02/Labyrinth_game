package mazegame.hint;

import mazegame.board.Cell;
import mazegame.entity.mob.Player;

public class Position extends Hint{

// Constructor 
	
	/** creates a position type Hint
	 * 
	 * @param win the winCell
	 */
	public Position(Cell win) {
		super(win);
	}

// Methods
	/** uses the Hint by giving the position of WinCell
	 * @param m the targeted player
	 */
	public void use(Player m) {
		System.out.printf("Votre quête se trouve en %n , %n",this.win.getCoordx(),this.win.getCoordy());
	}
	
	/** @see java.lang.Object#toString()
	 *  
	 */
	public String toString() {
		return "Object that will give a hint about the position of WinCell";
	}

}
