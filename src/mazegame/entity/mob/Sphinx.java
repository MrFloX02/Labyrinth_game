package mazegame.entity.mob;
import mazegame.board.*;
import mazegame.hint.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Sphinx extends Mob{
	private Map<String,String> riddles;
	private String[][] answers = new String[20][10];
	
// Constructor
	
	/**
	 * creates a Sphinx on chosen cell with name "Sphinx"
	 * @param cell the cell where is the mob
	 * @param hint the hint detained by the mob
	 */
	public Sphinx(Cell cell,Hint hint) {
		super(cell,hint);
		super.name= "Sphinx";
		this.riddles = new HashMap<String,String>();
	}	
	
// Methods
	
	public void putriddle(String riddle, String answer) {
		this.riddles.put(riddle, answer);
	}
	
	public void putanswer(String answer,int a,int b) {
		this.answers[a][b]= answer;
	}
	
	/** harmonise les éventuelles réponses à une énigme afin de ne garder qu'une orthographe
	 * 
	 * @param word the word to be corrected
	 * @return la réponse harmonisée ou "KO" si la réponse n'est pas dans celles disponibles
	 */
	private String correction(String word) {
		for (int i=0 ; i<5; i++) {
			for (int j=0 ; j<10 ; j++) {			// parcours le tableau answers
				if (word == this.answers[i][j]) {   // regarde si le mot se trouve dans les possibilités
					return this.answers[i][0];      // retourne la réponse harmonisée
				}
				
			}
		}
		return "KO";
	}
	
	
	/**
	 * selectionne une enigme random et attends une réponse, donne ensuite un indice direction en cas de bonne réponse
	 * @param player the riddle target
	 */
	public void riddle(Player player) {
		
		this.putriddle("Je marche à 4 pattes le matin, à 2 pattes le midi, et à 3 pattes le soir. Qui suis-je ?","l'homme");
		/*
		this.putanswer("l'homme",0,0);
		this.putanswer("homme",0,1); 
		this.putanswer("HOMME",0,2); 
		this.putanswer("L'homme",0,3); 
		this.putanswer("l'Homme",0,4); 
		this.putanswer("L'HOMME",0,5); 
		this.putanswer("Homme",0,6); 
		*/
		this.putriddle("Je démarre la nuit et fini le matin mais n'apparait que 2 fois dans l'année. Qui suis-je ?","n");
		/*
		this.putanswer("n",1,0);
		this.putanswer("N",1,1);
		this.putanswer("lettre n",1,2);
		this.putanswer("lettre N",1,3);
		this.putanswer("la lettre n",1,4);
		this.putanswer("la lettre N",1,5);
		this.putanswer("La lettre n",1,6);
		this.putanswer("La lettre N",1,7);
		this.putanswer("LA LETTRE N",1,8);
		this.putanswer("LETTRE N",1,9);
		*/
		this.putriddle("Lorsque l'on m'appelle je n'existe plus. Qui suis-je ?", "silence");
		/*
		this.putanswer("silence",2,0);
		this.putanswer("le silence",2,1);
		this.putanswer("Le silence",2,2);
		this.putanswer("SILENCE",2,3);
		this.putanswer("LE SILENCE",2,4);
		this.putanswer("Silence",2,5);
		*/
		this.putriddle("Qu'est-ce qui est meilleur que Dieu, pire que le diable, les pauvres en ont, les riches en ont besoin, si on en mange on meurt ?","rien");
		/*
		this.putanswer("rien",3,0);
		this.putanswer("Rien",3,1);
		this.putanswer("RIEN",3,2);
		*/
		this.putriddle("Où peut-on trouver le dimanche avant le samedi ?", "dictionnaire");
		/*
		this.putanswer("dictionnaire",4,0);
		this.putanswer("le dictionnaire",4,1);
		this.putanswer("Le dictionnaire",4,2);
		this.putanswer("Dictionnaire",4,3);
		this.putanswer("DICTIONNAIRE",4,4);
		this.putanswer("Le Dictionnaire",4,5);
		this.putanswer("LE DICTIONNAIRE",4,6);
		*/
		this.putriddle("J'ai quelque chose dans ma poche mais ma poche est vide. Qu'est-ce que c'est ?", "un trou");
		/*
		this.putanswer("un trou",5,0);
		this.putanswer("Un trou",5,1);
		this.putanswer("Un Trou",5,2);
		this.putanswer("un Trou",5,3);
		this.putanswer("trou",5,4);
		this.putanswer("Trou",5,5);
		*/
		this.putriddle("Qu'est-ce qui est plein de trous mais qui arrive quand meme a contenir de l'eau ?", "une eponge");
		/*
		this.putanswer("une eponge",6,0);
		this.putanswer("Une Eponge",6,1);
		this.putanswer("Une eponge",6,2);
		this.putanswer("une eponge",6,3);
		this.putanswer("Eponge",6,4);
		this.putanswer("eponge",6,5);
		this.putanswer("eponge",6,6);
		*/
		this.putriddle("je tombe sans me faire mal, qui suis-je?", "la nuit");
		/*
		this.putanswer("la nuit",7,0);
		this.putanswer("La nuit",7,1);
		this.putanswer("La Nuit",7,2);
		this.putanswer("la Nuit",7,3);
		this.putanswer("nuit",7,4);
		this.putanswer("Nuit",7,5);
		*/
		Object[] keys = this.riddles.keySet().toArray();
		Object[] values = this.riddles.values().toArray();
		
		Random ran = new Random(); //random sur l'énigme donnée
		int r = ran.nextInt(keys.length);
		System.out.println(keys[r]); //print l'enigme random
		Scanner scan = new Scanner(System.in);
		String rep = scan.next();
		//rep = correction(rep); // harmonisation de la réponse
		
		if (rep.equals(values[r])) {
			System.out.println("Vous faites preuve d'une grande sagesse, vous avez mérité un indice :");
			this.hint.use(player); // utilise indice direction
		}
		else {
			System.out.println("Non... Ce n'est pas la réponse attendue, soyez puni et passez votre chemin !");
			System.out.println(player.getName()+" a perdu 10 d'or");
			player.payMoney(10); //retirer des golds au personnage
		}
		System.out.println("\n");
		
	}
	
	/**
	 * speaks with the player
	 * 
	 * le joueur chosis de parler au sphinx
	 * une selection aleatoire d'�nigmes se met en place
	 * le joueur r�pond
	 * 	si la reponse est correcte:
	 * 		le sphinx donne une indice de type zone
	 * 	sinon
	 * 		le sphinx lui vole une certaine quantite d'or
	 * 
	 * @param player the player who speak to the sphinx
	 * @return the sphinx's dialogue
	 */
	public String speak(Player player) {
		System.out.println(super.speak(player)+", je suis le Sphinx, j'ai une enigme pour toi, réussi et je t'aiderai a trouver ton chemin \n");
		this.riddle((player));
		return "\n";
	}
}
