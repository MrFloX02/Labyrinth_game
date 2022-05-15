package mazegame.board;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import mazegame.board.algos.SideWinder;

public class BoardTest {

	private Board b;
	private Cell c1;
	private Cell c2;
	
	@Before
	public void before() {
		this.b = new SideWinder(5,10);
		this.c1 = new Cell(0,0,0);
		this.c2 = new Cell(49,4,9);
	}

	@Test
	public void getStartTest() {
		b.setStart(c1);
		assertEquals(b.getStart(),c1);
	}
	
	@Test
	public void getWinTest() {
		b.setWin(c2);
		assertEquals(b.getWin(),c2);
	}

}
