package mazegame.entity.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mazegame.board.Cell;
import mazegame.hint.*;


public class ParchementTest{
	private Parchement p;
	private Hint i;
	private Cell c;
	
	@Before
	public void before(){
		this.c= new Cell(0,0,0);
		this.i = new VolOiseau(c);
		this.p= new Parchement(i);
	}
	@Test
	public void Parchement() {
		Parchement d = new Parchement(null);
		assertEquals(p.getIndice(),i);
	}
	
}
