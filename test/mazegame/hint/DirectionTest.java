package mazegame.hint;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mazegame.board.*;
import mazegame.board.algos.SideWinder;
import mazegame.entity.mob.*;

public class DirectionTest {
	private Mob m;
	private Board b;
	private Hint i;
	private Cell c;
	private Cell no;
	private Cell ne;
	private Cell so;
	private Cell se;

	@Before
	public void before(){
		this.b = new SideWinder(11,11);
		this.b.setWin(this.b.getTheCells()[5][5]);
		this.i = new Direction(this.b.getWin());
		this.c = this.b.getTheCells()[2][1];
		this.m = new Sphinx(c,i);
		this.no = this.b.getTheCells()[0][0];
		this.ne = this.b.getTheCells()[0][10];
		this.so = this.b.getTheCells()[10][0];
		this.se = this.b.getTheCells()[10][10];
		
	}

	@Test
	public void northWestTest() {
		/*assertTrue(d.getDirection()=="nord ouest");*/
	}
	@Test
	public void southWestTest() {
	}
	@Test
	public void northEastTest() {
	}
	@Test
	public void southEastTest() {
	}

}
