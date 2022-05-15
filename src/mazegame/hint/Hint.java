package mazegame.hint;

import mazegame.board.Cell;
import mazegame.entity.mob.*;


public abstract class Hint {
	protected Cell win;

// Constructor 

	/**Creates a Hint related to chosen mob
	 * 
	 * @param win the winCell
	 */
	public Hint(Cell win) {
		this.win = win;
	}

// Getters and Setters
	
	/** win getter
	 * 
	 * @return winCell
	 */
	public Cell getWin() {
		return win;
	}
	/** win setter
	 * 
	 * @param win the winCell
	 */
	public void setWin(Cell win) {
		this.win = win;
	}
	
	/**
	 * fait usage de l'indice
	 * @param m le mob visee
	 */
	public abstract void use(Player m);
	
	/** @see java.lang.Object#toString()
	 *  
	 */
	public String toString() {
		return "Object that will give a hint to the player";
	}
	
}
