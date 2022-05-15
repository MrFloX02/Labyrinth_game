package mazegame;
import mazegame.board.*;
import mazegame.board.algos.*;
import mazegame.entity.item.*;
import mazegame.entity.mob.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeMain {

	public static void main(String[] args) {
		Board mainBoard = new SideWinder(2,2);
		try {
			if(args[0].equals("1")) {
				mainBoard = new SideWinder(10,10);//Cree un labyrinthe  de taille 7 par 4 avec l'algorithme SideWinder
			}
			else if(args[0].equals("2")) {
				mainBoard = new RandomFusion(10,10);//Cree un labyrinthe  de taille 7 par 4 avec l'algorithme de fusion aleatoire
			}else {
				System.out.println("PLEASE INSERT A NUMBER BETWEEN 1 & 2 (example : make 1 or make 2)\n 1- Side-winder Algorithm\n 2- Random Fusion Algorithm");
				System.exit(0);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("PLEASE INSERT A NUMBER BETWEEN 1 & 2 (example : make 1 or make 2)\n 1- Side-winder Algorithm\n 2- Random Fusion Algorithm");
			System.exit(0);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Tapez votre nom :");
		String name = sc.nextLine();
		List<Item> items= new ArrayList<Item>();
		Player ps1= new Player(name,5,items,mainBoard);//Cree un nouveau player avec ses param�tres(nom ,nombre d'or , et ses items
		
		Game jeu = new Game(mainBoard,ps1);
		jeu.play();
		sc.close();
		
		
		//Mobs
		/*Sphinx sph = new Sphinx(mainBoard.getTheCells()[3][3],dir);//Cree un Sphinx sur la cellule [3,3]
		
		{
			sph.putriddle("Je marche à 4 pattes le matin, à 2 pattes le midi, et à 3 pattes le soir. Qui suis-je ?","l'homme");
			sph.putanswer("l'homme",0,0);
			sph.putanswer("homme",0,1); 
			sph.putanswer("HOMME",0,2); 
			sph.putanswer("L'homme",0,3); 
			sph.putanswer("l'Homme",0,4); 
			sph.putanswer("L'HOMME",0,5); 
			sph.putanswer("Homme",0,6); 
			
			sph.putriddle("Je démarre la nuit et fini le matin mais n'apparait que 2 fois dans l'année. Qui suis-je ?","n");
			sph.putanswer("n",1,0);
			sph.putanswer("N",1,1);
			sph.putanswer("lettre n",1,2);
			sph.putanswer("lettre N",1,3);
			sph.putanswer("la lettre n",1,4);
			sph.putanswer("la lettre N",1,5);
			sph.putanswer("La lettre n",1,6);
			sph.putanswer("La lettre N",1,7);
			sph.putanswer("LA LETTRE N",1,8);
			sph.putanswer("LETTRE N",1,9);
			
			sph.putriddle("Lorsque l'on m'appelle je n'existe plus. Qui suis-je ?", "silence");
			sph.putanswer("silence",2,0);
			sph.putanswer("le silence",2,1);
			sph.putanswer("Le silence",2,2);
			sph.putanswer("SILENCE",2,3);
			sph.putanswer("LE SILENCE",2,4);
			sph.putanswer("Silence",2,5);
			sph.putRandomanswer("Le Silence",2,6);
			
			sph.putriddle("Qu'est-ce qui est meilleur que Dieu, pire que le diable, les pauvres en ont, les riches en ont besoin, si on en mange on meurt ?","rien");
			sph.putanswer("rien",3,0);
			sph.putanswer("Rien",3,1);
			sph.putanswer("RIEN",3,2);
			
			sph.putriddle("Où peut-on trouver le dimanche avant le samedi ?", "dictionnaire");
			sph.putanswer("dictionnaire",4,0);
			sph.putanswer("le dictionnaire",4,1);
			sph.putanswer("Le dictionnaire",4,2);
			sph.putanswer("Dictionnaire",4,3);
			sph.putanswer("DICTIONNAIRE",4,4);
			sph.putanswer("Le Dictionnaire",4,5);
			sph.putanswer("LE DICTIONNAIRE",4,6);
			
			sph.putriddle("J'ai quelque chose dans ma poche mais ma poche est vide. Qu'est-ce que c'est ?", "un trou");
			sph.putanswer("un trou",5,0);
			sph.putanswer("Un trou",5,1);
			sph.putanswer("Un Trou",5,2);
			sph.putanswer("un Trou",5,3);
			sph.putanswer("trou",5,4);
			sph.putanswer("Trou",5,5);
			
			sph.putriddle("Qu'est-ce qui est plein de trous mais qui arrive quand meme a contenir de l'eau ?", "une eponge");
			sph.putanswer("une eponge",6,0);
			sph.putanswer("Une Eponge",6,1);
			sph.putanswer("Une eponge",6,2);
			sph.putanswer("une eponge",6,3);
			sph.putanswer("Eponge",6,4);
			sph.putanswer("eponge",6,5);
			sph.putanswer("eponge",6,6);
			
			sph.putriddle("je tombe sans me faire mal, qui suis-je?", "la nuit");
			sph.putanswer("la nuit",7,0);
			sph.putanswer("La nuit",7,1);
			sph.putanswer("La Nuit",7,2);
			sph.putanswer("la Nuit",7,3);
			sph.putanswer("nuit",7,4);
			sph.putanswer("Nuit",7,5);
			
			}
		
		Altruist alt = new Altruist(mainBoard.getTheCells()[5][3]);//Cree un Altruist sur la cellule [5,3]
		Fou f= new Fou(mainBoard.getTheCells()[2][0]);//Cree un Fou sur la cellule [2,0]
		Marchand mrch= new Marchand(mainBoard.getTheCells()[6][1]);//Cree un Marchant sur la cellule [6,1]


		//Item
		//Bourse brs= new Bourse(100);// Cree une bourse contenant 100 d'or
		
		
		System.out.println("----------Creation du Tableau----------");
		ps1.setCell(mainBoard.getTheCells()[0][0]);//Place le joueur dans le labirynthe
		mainBoard.setPlayer(ps1);
		mainBoard.displayBoard();//Affiche dans le terminal le labirynthe avec le joueur dessus
		System.out.println(ps1.toString());//Le joueur parle
		ps1.move("NORD");
		ps1.move("SUD");
		ps1.move("EST");
		ps1.move("SUD");
		ps1.move("OUEST");
		mainBoard.displayBoard();
		System.out.println(ps1.toString());
		System.out.println(f.speak());//Le fou parle */
		
		
		/*SideWinder square = new SideWinder(5,5);//Cree un labyrinthe carre de taille 5 par 5 avec l'algorithme SideWinder
		RandomFusion square2 = new RandomFusion(5,5);//Cree un labyrinthe carre de taille 5 par 5 avec l'algorithme RandomFusion
	    RandomFusion rectangle2 = new RandomFusion(9,6);//Cree un labyrinthe rectangle de taille 9 par 6 avec l'algorithme SideWinder
		SideWinder rectangle = new SideWinder(9,6); //Cree un labyrinthe rectangle de taille 9 par 6 avec l'algorithme RandomFusion
		
		//ajout du joueur
		List<Item> items= new ArrayList<Item>();
		Player ps1= new Player("Sophian",100,items);
		Player pr1= new Player("Rachid",200,items);
		Player pr2= new Player("Rayan",50,items);
		ps1.setCell(square.getTheCells()[1][2]);
		square.setPlayer(ps1);
		pr1.setCell(rectangle.getTheCells()[0][0]);
		rectangle.setPlayer(pr1);
		pr2.setCell(rectangle2.getTheCells()[8][5]);
		rectangle2.setPlayer(pr2);
		
		Game jeu1= new Game(square,ps1);
		Game jeu2= new Game(square2,ps1);
		Game jeu3= new Game(rectangle,pr1);
		Game jeu4= new Game(rectangle2,pr2);
		
		jeu1.play();
		jeu2.play();
		jeu3.play();
		jeu4.play();
		
		/*square.displayBoard(); //Affiche un labyrinthe carre de taille 5 par 5 avec l'algorithme SideWinder
		square2.displayBoard();//Affiche un labyrinthe carre de taille 5 par 5 avec l'algorithme RandomFusion
		rectangle.displayBoard();//Affiche un labyrinthe rectangle de taille 9 par 6 avec l'algorithme SideWinder
		rectangle2.displayBoard();//Affiche un labyrinthe rectangle de taille 9 par 6 avec l'algorithme RandomFusion*/
	}

}
