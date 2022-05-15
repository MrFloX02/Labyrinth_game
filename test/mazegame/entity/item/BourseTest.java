package mazegame.entity.item;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BourseTest {
private Bourse  gold;
	
	@Before
	public void before(){
		this.gold= new Bourse(100);
	}
	
	@Test
	public void negatif() {
		Bourse b = new Bourse(0);
	}
	
	
	@Test
	public void max() {
		Bourse b = new Bourse(10000);
	}
}
