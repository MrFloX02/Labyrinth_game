package mazegame.entity.mob;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import mazegame.board.Board;
import mazegame.entity.item.Bourse;
import mazegame.entity.item.Item;
import mazegame.entity.item.Parchement;
import mazegame.board.algos.*;


public class PlayerTest {
	private Player player;
	private Board board;
	private int nbOr;
	private List<Item> items;
	private Bourse bourse;
	
	
	
	@Before
	public void before(){
		this.board = new SideWinder(5,6);
		this.nbOr = 50;
		this.items = new ArrayList<Item>();
		this.bourse = new Bourse(10);
		this.items.add(this.bourse);
		this.player = new Player("jpp",this.nbOr,this.items,this.board);
	}

	@Test
	public void constructorTest() {
		
	}

}
