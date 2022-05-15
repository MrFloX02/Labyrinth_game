package mazegame.entity.item;

import mazegame.entity.mob.Player;

public abstract class Item{
	protected String name;
	
	public String getName() {
		return this.name; // nom de l'item du joueur
	}
	
	/**
	 * renvoie les differents usages des Items
	 * @param p le joueur ciblee
	 */
	public abstract void use(Player p);
}
