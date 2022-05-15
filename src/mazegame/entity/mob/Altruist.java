package mazegame.entity.mob;
import java.util.Set;

import mazegame.Mobile;
import mazegame.board.Cell;
import mazegame.hint.Hint;

public class Altruist extends Mob implements Mobile{
	
	public Altruist(Cell cell,Hint hint){
		super(cell,hint);
		super.name="Altruiste";
	}
	
	/**
	 * speaks with the player 
	 * 
	 * @param player the player who speaks to the Altruist
	 * @return the Altruist's dialogue
	 */
	public String speak(Player player) {
		System.out.println(super.speak(player)+", oh vous semblez chercher votre chemin, voici un indice pour vous aider dans votre quête");
		this.hint.use(player);
		return "\n";
	}
	
	/** moves the Altruist to a random neighbor cell
	 * 
	 */
	public void move() {
		Set<Cell> voisins = this.cell.getNeighborCells().keySet();
		int n=voisins.size();
		Cell[] voisin = voisins.toArray(new Cell[0]);
		int indice=(int) Math.random()*n;                     // retourne un indice dans NeighborCells 
		this.cell.setMob(null);                               // remet la cellule actuelle sans personnage
		this.cell = voisin[indice];							 // "deplace" le mob sur la cellule voisine
		this.cell.setMob(this); 						      // indique à la cellule qu'un mob se trouve dessus désormais
	}
}
