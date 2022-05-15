package mazegame;

import java.util.Random;
import java.util.Scanner;

import mazegame.board.Board;
import mazegame.board.Cell;
import mazegame.entity.item.*;
import mazegame.entity.mob.*;
import mazegame.hint.Direction;
import mazegame.hint.Position;
import mazegame.hint.VolOiseau;
import mazegame.hint.Zone;

/**
* Créé le jeu avec la boucle de jeu principale
*/
public class Game{
	private Board board;
	
	private Mob mobs;
	private Player player;
	private Altruist altruist;
	private Fou fou;
	private Marchand marchent;
	private Sphinx sphinx;
	
	private Direction dir;
	private Position pos;
	private VolOiseau vol;
	private Zone zone;
	
	private Parchement parchemin;
	private Bourse bourse;
	
	private static final String STOP = "\u001B[0m"; 
	private static final String VERT = "\u001B[32m";
//	private static final String ROSE = "\u001B[35m";
	private static final String ROUGE = "\u001B[31m";
	
	private final int piece = 2;
	private int tour = 1;
	
	/**
	 * cree le jeu a partir d'un tableau et d'un joueur
	 * @param board le tableau ou se deroule le jeu
	 * @param player le joueur 
	 */
	public Game(Board board,Player player){
		this.board=board;
		this.player=player;
		board.setPlayer(player);
	}
	
	/**tant que le joueur n'est pas à la case d'arrivée
	 * board est affiché
	 * le joueur se situe à la case depart
	 * le joueur doit choisir entre
	 * 	se déplacer (joueur.move())
	 * 	parler aux personnages qui sont dans la même case que le joueur (si il y en a)
	 * 	utiliser un item que possède le joueur
	 * si le joueur se deplace, on reaffiche le tableau avec la case où s'est déplacé le joueur et on recommence
	 * 
	 */
	public void play() {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		boolean resetMap = true;
		this.board.setStart(this.board.getTheCells()[0][0]);
		this.player.setCell(this.board.getStart());
		this.board.setWin(this.board.getTheCells()[rand.nextInt(this.board.getWidth()-1)][rand.nextInt(this.board.getLength()-1)]);
		
		//Hints
		this.dir = new Direction(this.board.getWin());
		this.pos = new Position(this.board.getWin());  //fonctionne pas
		this.vol = new VolOiseau(this.board.getWin());
		this.zone = new Zone(this.board.getWin(),3,this.board);	//fonctionne pas
		
		//Mobs
		/*this.altruist = new Altruist(this.board.getTheCells()[0][1],this.dir);
		this.fou = new Fou(this.board.getTheCells()[2][2],this.dir);
		this.sphinx = new Sphinx(this.board.getTheCells()[1][1],this.vol);
		this.marchent = new Marchand(this.board.getTheCells()[1][3],this.dir);*/
		//implementation de 50% de mobs
		for(Cell[] cellLine : this.board.getTheCells()) {
			for(Cell elt : cellLine) {
				if(rand.nextInt(100)<50) {
					switch(rand.nextInt(4)) {
					case 0:
						this.mobs = new Altruist(elt,this.dir);
						break;
					case 1:
						this.mobs = new Fou(elt,this.dir);
						break;
					case 2:
						this.mobs = new Sphinx(elt,this.vol);
						break;
					case 3:
						this.mobs = new Marchand(elt,this.dir);
						break;
					}
					elt.setMob(this.mobs);
				}
			}
			
		}
		
		this.parchemin = new Parchement(this.vol);
		this.bourse = new Bourse(10);
		this.player.addItems(bourse);
		this.player.addItems(parchemin);
		
		while(this.player.getCell()!=this.board.getWin()) {
			
			if(resetMap == true) {
				this.board.displayBoard();
				System.out.println(this.player.toString());
				
			}
			
			if(this.tour > 1  && (rand.nextInt(4) + 1) == 4) { // 1 chance sur 4 de donner de l'or au dela du 1er tour 
				this.player.earnMoney(this.piece);
				System.out.println(this.player.getName()+" a trouvé "+this.piece+" d'or dans un mur !\n");
				
			}
			
			System.out.println("Que faire ? (tapez 'help' pour la liste d'actions)");
			String action = sc.next();
			System.out.println("----------------------------------------------------");
			
			switch(action.toLowerCase()) {
			case "h":
			case "help":
				System.out.println("help (or h)<- pour obtenir un message d'aide");
				System.out.println("leave <- pour quitter le jeu");
				System.out.println("speak <- pour interagir avec un personnage");
				System.out.println("use <- pour utiliser un objet");
				System.out.println("move (or m) <- pour deplacer le joueur");
				System.out.println("look <- pour regarder autour du joueur");
				System.out.println("----------------------------------------------------\n");
				resetMap = false;
		        break;
			case "leave":
				System.out.println(ROUGE+"Nombre de tour : "+this.tour);
				System.out.println("Abandon :("+STOP);
				System.exit(0); 
		        break;
			case "speak": // a finir
				if(this.player.getCell().getMob()!=null) {
					this.player.getCell().getMob().speak(this.player);
				}
				else System.out.println("Personne dans le coin...\n");
				System.out.println("----------------------------------------------------\n");
				resetMap = false;
		        break;
			case "use": 
				System.out.println("Selectionnez l'objet a utiliser (entrez uniquement les nombres):");
				System.out.println("0- None");
				for(int i=0;i<this.player.getItems().size();i++) {
					System.out.println(i+1+"- "+this.player.getItems().get(i).getName());
				}
				String nbItem = sc.next().replaceAll("[^0-9]","0");
				if (nbItem.length()>4) {
					nbItem = "0";
				}
				int choosenItem = Integer.parseInt(nbItem);
				if(choosenItem != 0) {
					try {
						System.out.println("");
						this.player.getItems().remove(choosenItem-1).use(player);
						System.out.println("");
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println(STOP);
						System.out.println("INCORRECT");
					}
				}
				
				System.out.println("----------------------------------------------------\n");
				resetMap = false;
		        break;
			case "m":
		    case "move":
		    	System.out.println("ou voulez vous aller ?");
				String direction = sc.next();
				this.player.move(direction.toUpperCase());
				this.tour++;
				resetMap = true;
		        break;
		    case "look":
		    	this.player.stayAndLookAround();
		    	resetMap = true;
		        break;
		    default:
		        System.out.println("Action inconnue");
			}
			
		}
		sc.close();
		System.out.println(VERT);
		System.out.println("*********************************************************************\n");
		System.out.println("(/ ° w°)/ *',` FELICITATION VOUS AVEZ FINI LE JEU !!! *`,*\\(°w ° \\)\n");
		System.out.println("*********************************************************************");
		System.out.println(VERT+"Nombre de tour : "+this.tour);
		System.out.println(STOP);
	}
}
