package mazegame.board.algos;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mazegame.board.Board;

public class RandomFusionTest {

	private Board b;
	
	@Before
	public void before() {
		this.b = new RandomFusion(5,10);
	}

	
	@Test
	public void constructorTest() {
		assertEquals(b.getWidth(),5);
		assertEquals(b.getLength(),10);
	}
}