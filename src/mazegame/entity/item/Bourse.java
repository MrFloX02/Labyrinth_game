package mazegame.entity.item;

import mazegame.entity.mob.Player;
/**
 * Une Bourse est un Item contenant un certain nombre de golds que le joueur peut amasser
 */
public class Bourse extends Item{
	
	private int goldMenge;
	
	/** Bourse du joueur
	 * @param goldMenge l'or que contient la Bourse
	 */
	public Bourse(int goldMenge) {
		this.goldMenge=goldMenge; //bourse du joueur où son argent est stocké
		this.name = "bourse";
	}
	
	/**
	 * ajoute l'argent au joueur
	 * @param p the player
	 */
	public void use(Player p) {
		p.earnMoney(goldMenge);
		System.out.printf("Vous venez de gagner %d or !\n",this.goldMenge);
	}
}
