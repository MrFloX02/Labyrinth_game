package mazegame.entity.mob;
import mazegame.*;
import mazegame.board.*;
import mazegame.hint.Hint;

import java.util.*;

public class Fou extends Mob implements Mobile{
	private String[] badHints = new String[] {"Nord","Sud","Est","Ouest"};
	
// Constructor
	
	/**
	 * creates a fool on chosen cell with the name "Fou"
	 * @param cell the cell where is the mob
	 * @param hint the hint detained by the mob
	 */
	public Fou(Cell cell,Hint hint) {
		super(cell,hint);
		super.name= "Fou";
	}

// Methods
	
	/**
	 * speaks with the player 
	 * 
	 * @param player the player who speaks to the Fool
	 * @return the fool's dialogue
	 */
	public String speak(Player player) {
		System.out.println(super.speak(player)+", Oh vous semblez chercher votre chemin, laissez moi vous guider vers votre quête");
		int nb = (int)Math.floor((Math.random() * 3) + 0);
		String dir = this.badHints[nb];
		System.out.println("Votre destiné se trouve : "+dir);
		return "\n";
	}
	
	/**
	 * move the fool
	 * 
	 */
	public void move() {
		Set<Cell> voisins = this.cell.getNeighborCells().keySet();
		int n=voisins.size();
		Cell[] voisin = voisins.toArray(new Cell[0]);
		int indice=(int) Math.random()*n;                     // retourne un indice dans NeighborCells 
		this.cell.setMob(null);                               // remet la cellule actuelle sans personnage
		this.cell = voisin[indice];							 // "deplace" le mob sur la cellule voisine
		this.cell.setMob(this); 						      // indique à la cellule qu'un mob se trouve dessus désormais						      // indique à la cellule qu'un mob se trouve dessus désormais
	}
}
