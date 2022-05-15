package mazegame.hint;
import mazegame.entity.mob.*;
import mazegame.board.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class HintTest {
	private Hint h;
	private Cell c;
	
	@Before
	public void before(){
		this.c = new Cell(1,2,3);
		this.h = new Direction(c);
		
	}

	@Test
	public void constructorTest(){
		assertTrue(h.getWin()==c);
	}

}
