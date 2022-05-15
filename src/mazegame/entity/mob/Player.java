package mazegame.entity.mob;

import mazegame.entity.item.*;
import mazegame.board.*;
import java.util.*;
import java.util.Map.Entry;


public class Player {
	private String name;
	private int nbOr;
	private List<Item> items;
	private Cell cell;
	private Cell[][] theCells;
	private Board board;
	
// Getters and setters	
	
	
	/**
	 * Get the name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the cell
	 * @return Cell
	 */
	public Cell getCell() {
		return this.cell;
	}
	
	/**
	 * Set the cell
	 * @param cell the cell where the player will belong
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}

	/**
	 * Add items
	 * @param item the item added
	 */
	public void addItems(Item item) {
		this.items.add(item);
	}
	
	/**
	 * Item getter
	 * @return items
	 */
	public List<Item> getItems(){
		return this.items;
	}
	

// Constructor	
	
	public Player(String name, int or, List<Item> items,Board board) {
		this.name = name;
		this.nbOr = or;
		this.items = items;
		this.board = board;
		this.theCells = this.board.getTheCells();
	}
	
// Methods
	
	/**
	 * 	les cases voisins sont affichés
	 * 	le joueur choisit la case
	 * 	le joueur se déplace
	 * 
	 *  @param direction ne doit contenir que "NORD", "SUD", "EST", "OUEST".
	 */
	public void move(String direction) {
		Map<Cell,String> voisins = this.cell.getNeighborCells();
		Cell nord, sud, est, ouest;
		Set<Cell> vCell = voisins.keySet();
		
		try {
			if(direction.equals("NORD")||direction.equals("HAUT")||direction.equals("NORTH")||direction.equals("UP")||direction.equals("Z")) {
				nord = this.theCells[this.cell.getCoordx()][this.cell.getCoordy()-1];
				if(vCell.contains(nord)) {
					this.setCell(nord);	
				}
			}
			
			else if(direction.equals("SUD")||direction.equals("BAS")||direction.equals("SOUTH")||direction.equals("DOWN")||direction.equals("S")) {
				sud = this.theCells[this.cell.getCoordx()][this.cell.getCoordy()+1];
				if(vCell.contains(sud)) {
					this.setCell(sud);
				}
			}
			
			else if(direction.equals("EST")||direction.equals("DROITE")||direction.equals("EAST")||direction.equals("RIGHT")||direction.equals("D")) {
				est = this.theCells[this.cell.getCoordx()+1][this.cell.getCoordy()];
				if(vCell.contains(est)) {	
					this.setCell(est);	
				}
			}
			
			else if(direction.equals("OUEST")||direction.equals("GAUCHE")||direction.equals("WEST")||direction.equals("LEFT")||direction.equals("Q")) {
				ouest = this.theCells[this.cell.getCoordx()-1][this.cell.getCoordy()];
				if(vCell.contains(ouest)) {	
					this.setCell(ouest);	
				}
			}
			else System.out.println("Bloqué");
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Bloqué");
		}
		
	}
	
	/**
	 * le joueur reste sur sa case et se renseigne sur les autres cases
	 * 
	 */
	public void stayAndLookAround() {
		Map<Cell, String> map = this.cell.getNeighborCells();
		Collection<String> d = this.cell.getNeighborCells().values();
		
		System.out.println(this.name+" reste sur place");
		System.out.println("Les directions possibles sont :");
		System.out.println(d);
		
		for (Entry<Cell, String> entry : map.entrySet()) {
			if (entry.getKey().getMob() != null || entry.getKey().getItem() != null) {
				if (entry.getValue() == "Nord" || entry.getValue() == "Sud") {
					System.out.printf("\nAu %s se trouve :",entry.getValue());					
				}else { System.out.printf("\nA l'%s se trouve :",entry.getValue());}
				
				if (entry.getKey().getMob() != null) {
					System.out.printf(entry.getKey().getMob().name, ", ");					
				}
				if (entry.getKey().getItem() != null) {
					System.out.printf(entry.getKey().getItem().getName(), ", ");
				}
			}
		}
		System.out.println("");
		
	}
	
	/**
	 * le joueur parle aux personnages, cela dépend des personnages
	 *  
	 * @param player le perso où le joueur interagis
	 */
	public void speak(Player player) {
		Mob mob = this.cell.getMob();
		if (mob == null) {
			System.out.println("Vous parlez seul, mais les nuages ne peuvent pas vous répondre...");
		}else {
			System.out.println(mob.speak(this));
		}
	}

	/**
	 * Pick the Item
	 */
	public void pickItem() {
		this.items.add(this.cell.getItem());
		this.cell.setItem(null);
	}
	
	/**
	 * Use a Item
	 * @param item the item to be used
	 */
	public void useItem(Item item) {
		item.use(this);
	}
	
	
	/**
	 * Pay an amount of money
	 * @param money the money lost by the player
	 */
	public void payMoney(int money) {
		this.nbOr = nbOr-money;
	}
	

	/**
	 * Earn a amount of money
	 * @param money the money earned
	 */
	public void earnMoney(int money) {
		this.nbOr = nbOr + money;
	}
	
	/**
	 * Lose Money each turn
	 */
	public void loseMoneyByTurn() {
		
		if(this.nbOr > 0) {
			this.nbOr = nbOr-1;
		}
	}
	
	/**
	 * Earn Money each turn
	 */
	public void EarnMoneyByTurn() {
		this.nbOr = nbOr+1;
	}
	
	/**
	 * Lose all money
	 */
	public void loseMoney() {
		this.nbOr = 0;
	}
	
	private String objectListString() {
		String str = "";
		Item[] item = this.items.toArray(new Item[0]);
		for(Item elt : item) {
			str += "[ "+(this.items.indexOf(elt)+1)+" - "+elt.getName()+" ] ";
		}
		return str;
	}
	
	/**
	 * @see java.lang.Object#toString
	 */
	public String toString() {
		return this.name+" est dans la case ("+this.cell.getCoordx()+","+this.cell.getCoordy()+")\n"
	+"les objets que vous possedez : "+this.objectListString()+"\n"
	+this.name+" a "+this.nbOr+" or\n";
	}
	
	
}
