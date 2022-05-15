package mazegame.entity.mob;
import mazegame.entity.item.*;
import mazegame.hint.Hint;
import mazegame.*;
import mazegame.board.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Marchand extends Mob implements Mobile{
	private HashMap<Item,Integer> shop;
	
// Constructor	
	
	/**
	 * creates a Merchant on chosen cell with name "Marchand"
	 * @param cell the cell where is the mob
	 * @param hint the hint detained by the mob
	 */
	public Marchand (Cell cell,Hint hint) {
		super(cell,hint);
		super.name= "Marchand";
		this.shop = new HashMap<Item,Integer>();
		this.shop.put(new Parchement(hint),50);
	}
	
// Getters and Setters	
	
	/**
	 * returns the shop 
	 * @return the shop
	 */
	public Map<Item,Integer> getShop(){
		return this.shop;
	}
	
// Methods
	
	/**
	 * retrieves an item from shop when a player buys it
	 * @param p the player who buy his merch
	 * @param names the merch
	 * @param i the Item index
	 */
	public void buy(Player p ,Map<Integer,Item> names, int i) {
		Item item = names.get(i);
		p.payMoney(this.shop.get(item));
		this.shop.remove(item);
		System.out.println("C'est un plaisir de faire affaire avec vous !");
	}
	
	/**
	 * speaks with the player 
	 * 
	 * @param player the player who speaks to the Merchant
	 * @return the Merchant's dialogue
	 */
	public String speak(Player player) {
		if (!this.shop.isEmpty()) {
			int i=0;
			System.out.println(super.speak(player)+", approchez approchez, jetez un oeil à mon humble échope !\n\n");
			for (Item item : this.shop.keySet()) {
				this.shop.put(item,i);
				System.out.println("["+i+"] "+item.getName() + " : " + this.shop.get(item) + " golds\n");
				i++;
			}
			
			
			String rep = null;
			while(this.shop.keySet() != null || rep!="leave") {
				Scanner sc = new Scanner(System.in);
				rep = sc.next();
				if (this.shop.keySet().contains(Integer.parseInt(rep))) {
					//buy(player,this.shop,Integer.parseInt(rep));
				}
				sc.close();
				
			}
			
		}
		else {
			System.out.println("Désolé je n'ai plus rien à vous vendre \n");
		}
		
		
		return "\n";
	}
	
	/**
	 * move the merchant
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
