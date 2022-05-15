package mazegame.board;

import java.util.*;

import mazegame.entity.item.Item;
import mazegame.entity.mob.Mob;
/**
 * Une Cell est une case de jeu sur laquelle peut se trouver des personnages et/ou des items
 */
public class Cell{
	private int index;
	private int coordx;
	private int coordy;
	private Item item;
	private Mob mob;
	private Map<Cell,String> neighborCells;
	
// Getters and setters 
	
	/**
	 * Get the cell index 
	 * @return index
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Set the cell index
	 * @param index the index to be set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Get the cell x coordinate
	 * @return x coordinate
	 */
	public int getCoordx() {
		return coordx;
	}
	
	/**
	 * Get the cell y coordinate
	 * @return y coordinate
	 */
	public int getCoordy() {
		return coordy;
	}
	
	/**
	 * Get the Item on the cell
	 * @return the Item attribute
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Set the given Item on the cell
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Get the mob
	 * @return mob
	 */
	public Mob getMob() {
		return mob;
	}
	
	/**
	 * Set the mob
	 * @param mob the mob to set
	 */
	public void setMob(Mob mob) {
		this.mob = mob;
	}
	
	/**
	 * Get neighbor cells
	 * @return neighbor cells
	 */
	public Map<Cell,String> getNeighborCells() {
		return neighborCells;
	}
	
	/**
	 * Add neighbor cells
	 * @param cell the neighbor cell to add
	 */
	public void addNeighborCells(Cell cell) {
		if (this.coordx-cell.coordx == -1){
			this.neighborCells.put(cell,"Est");
		}
		if (this.coordx-cell.coordx == 1){
			this.neighborCells.put(cell, "Ouest");
		}
		if (this.coordy-cell.coordy == -1) {
			this.neighborCells.put(cell, "Sud");
		}
		if (this.coordy-cell.coordy == 1) {
			this.neighborCells.put(cell, "Nord");
		}
	}
	
	/**
	 * Check if neighbor
	 * @param cell the cell to verify
	 * @return True if the player can access to this cell
	 */
	public boolean isNeighbor(Cell cell) {
		
		if(this.neighborCells.containsKey(cell)) {
			return true;
		}
		else return false;
	}
	
	
	
// Constructor
	
	public Cell(int index, int coordx, int coordy) {
		this.index = index;
		this.coordx = coordx;
		this.coordy = coordy;	
		this.neighborCells = new HashMap<>();
	}
	
	
}
