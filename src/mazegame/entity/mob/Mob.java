package mazegame.entity.mob;
import mazegame.hint.Hint;
import mazegame.board.*;


/** 
 * abstract Mob class that gathers all mobs methods
 */
public abstract class Mob{
	protected String name;
	protected Cell cell;
	protected Hint hint;
	
// Constructor
	
	/**
	 *  creates a mob on chosen cell
	 *  @param cell the cell where is the mob
	 *  @param hint the hint detained by the mob
	 */
	public Mob(Cell cell,Hint hint) {
		this.cell= cell;
		this.hint= hint;
	}

// Getters and setters
	
	/** cell getter
	 * 
	 * @return cell
	 */
	public Cell getCell() {
		return cell;
	}
	
	/** cell setter
	 * 
	 * @param cell the cell to set
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
	/**
	 * name Getter
	 * @return the name attribute
	 */
	public String getName() {
		return this.name;
	}
	
// Methods
	

	/**
	 * makes the mob move on the board
	 * 	le personnage se déplace aléatoirement vers les cells voisins à chaque fois que le joueur se déplace 
	 * 
	 */
	public void move() {
		
	}
	
	/**the mob speaks to the player
	 * @param player the player who speaks to the mob
	 * @return the Mob's discussion
	 */
	public String speak(Player player) {
		return "Bonjour aventurier";   
	}
	
	
}
