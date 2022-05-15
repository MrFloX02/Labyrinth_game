package mazegame.entity.item;

import mazegame.entity.mob.Player;
import mazegame.hint.Hint;

public class Parchement extends Item{
	private Hint indice;
	
	/**
	 * Parchment constructor
	 * @param i the hint given to the parchment
	 */
	public Parchement(Hint i) {
		this.name = "parchemin";
		this.indice = i; 	// retourne l'indice du parchemain avec son type d'indice
	}
	/**
	 * hint getter
	 * @return the Hint of the parchment
	 */
	public Hint getIndice() {
		return this.indice;
	}
	
	/**the player will read the poem giving the hint for the game
	 * @param p player who use the parchment
	 */
	public void use(Player p){
		System.out.println("~~les roses sont rouges~~");
		System.out.println("~~les bleues sont violets~~");
		indice.use(p);
	}
}
