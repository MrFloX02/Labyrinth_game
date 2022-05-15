package mazegame.board;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private Cell c1;
	private Cell n;
	
	@Before
	public void before() {
		this.c1 = new Cell(0,2,6);
		this.n = new Cell(1,2,5);
	}

	@Test
	public void constructorTest() {
		assertEquals(this.c1.getIndex(),0);
		assertEquals(this.c1.getCoordx(),2);
		assertEquals(this.c1.getCoordy(),6);
	}
	
	@Test
	public void neighbourTest() {
		this.c1.addNeighborCells(this.n);
		assertTrue(this.c1.isNeighbor(this.n));
		
		Cell c2 = new Cell(2,3,6);
		this.c1.addNeighborCells(c2);
		
		ArrayList<Cell> l = new ArrayList<Cell>();
		l.add(this.n);
		l.add(c2);
		assertSame(l,this.c1.getNeighborCells());
	
		
	}

	@Test
	public void indexTest() {
		this.c1.setIndex(3);
		assertEquals(c1.getIndex(),3);
	}
	
}
