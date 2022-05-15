package mazegame.board;

import java.util.*;
import mazegame.entity.mob.Player;
/**
 * Un Board est un plateau de jeu contenant les cellules du labyrinthe et autour duquel le jeu va s'articuler
 */
public abstract class Board{
	protected int width;
	protected int length;
	protected Cell[][] theCells;
	protected Cell cell;
	protected Cell start;
	protected Cell win;
	protected Player player;
	private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[94m";
	
// Getters and setters	
	
	/**
	 * Get the maze width
	 * @return the width of the cell
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Get the maze length
	 * @return the length of the cell
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Get maze cells
	 * @return the array representing the cells of the board
	 */
	public Cell[][] getTheCells() {
		return theCells;
	}
	
	/**
	 * Get cell Start
	 * @return cell start
	 */
	public Cell getStart() {
		return start;
	}
	
	/**
	 * Set cell start
	 * @param start the start cell to be set
	 */
	public void setStart(Cell start) {
		this.start = start;
	}
	
	/**
	 * Get win cell
	 * @return win cell
	 */
	public Cell getWin() {
		return win;
	}
	
	/**
	 * Set win cell
	 * @param win the winCell
	 */
	public void setWin(Cell win) {
		this.win = win;
	}
	
	/**
	 * Get player
	 * @return PLayer the player attribute
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * Set player
	 * @param player the player to be set
	 */
	public void setPlayer(Player player){
		this.player=player;
	}

	
	
	
	
	
// Constructor
	
	/**
	 * - Initialisation de la longueur et de la largeur du plateau
	 * - Algorithme 1 : sidewinder
	 * 
	 * Le labyrinthe est généré une ligne à la fois : pour chaque cellule de cette ligne,
	 * on décide aléatoirement s'il faut détruire le mur Est ou pas.
     * - Si oui, alors on détruit le mur Est.
	 * - Sinon, on considère le passage horizontal qui vient d'être terminé, formé par la cellule actuelle et toutes les cellules à gauche qui ont creusé des passages menant à celle-ci. On choisit alors aléatoirement une cellule le long de ce passage et on détruit son mur Sud.
	 * 
	 * @param width the width of the board
	 * @param length the length of the board
	 */
	public Board(int width, int length) {		
		this.width = width;
		this.length = length;
		int index = 0;
		this.theCells = new Cell[width][length];
		
		/*
		# --------------------------------------------------------------------
		#   Data structures to assist the algorithm
		# --------------------------------------------------------------------
		*/
		
		for(int i=0; i < this.width ;i++) { 
			
			for(int j=0; j < this.length ;j++) {
				this.theCells[i][j] = new Cell(index,i,j);
				index++;
			
			}
		}
	}
	
	/**
	 * Print the maze
	 */
	public void displayBoard() {
		String ligne=BLUE;
		for(int line=0;line<this.width;line++) {
			ligne+="+------";
		}ligne+="+"+RESET;
		System.out.println(ligne);
		for(int y=0;y<this.length;y++) {
			String cell="|";
			String ligneS="+";
			for(int x=0;x<this.width;x++) {
				Cell c = this.theCells[x][y];
				Map<Cell,String> neighbours = c.getNeighborCells();
				if (this.player!=null && this.player.getCell().equals(c)) {
					if(x<this.width-1 && (y== this.length || neighbours.containsKey(this.theCells[x+1][y]))) { // tentative de forcer aucun mur sur la derniere ligne 
						cell+="  "+YELLOW+"00"+BLUE+"   ";
					}else {
						cell+="  "+YELLOW+"00"+BLUE+"  |";
					}
				}
				
				//décommentez pour verifier les apparitions des mobs !
				/*
				else if (c.getMob()!=null){
					if(c.getMob().getName().equals("Marchand")) {
						if(x<this.width-1 && (y== this.length || neighbours.containsKey(this.theCells[x+1][y]))) { // tentative de forcer aucun mur sur la derniere ligne 
							cell+="  MM   ";
						}else {
							cell+="  MM  |";
						}
					}else {
						if(x<this.width-1 && (y== this.length || neighbours.containsKey(this.theCells[x+1][y]))) { // tentative de forcer aucun mur sur la derniere ligne 
							cell+="  XX   ";
						}else {
							cell+="  XX  |";
						}
					}
				}
				*/
				//c'est là ou se finit l'affichage des mobs
				
				else {
					if(x<this.width-1 && (y== this.length || neighbours.containsKey(this.theCells[x+1][y]))) { // tentative de forcer aucun mur sur la derniere ligne 
						cell+="       ";
					}else {
						cell+="      |";
					}
				}
				if(y<this.length-1 && neighbours.containsKey(this.theCells[x][y+1])) {
					ligneS+="      +";
				}else {
					ligneS+="------+";
				}
			}
			System.out.println(BLUE+cell+RESET);
			System.out.println(BLUE+cell+RESET);
			System.out.println(BLUE+ligneS+RESET);
		}
	}
	
}

/* Compilation :
 * 
 * javac -sourcepath src -d classes src/mazegame/*.java
 * java -classpath classes mazegame.MazeMain
 * 
 */




