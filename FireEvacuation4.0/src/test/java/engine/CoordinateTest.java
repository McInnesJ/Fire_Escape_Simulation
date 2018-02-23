package engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	private Coordinate coordinate;
	
	@Before
	public void setUp() {
		coordinate = new Coordinate(3,5);
	}
	
	@Test
	public void testToString() {
		assertEquals("(3,5)",coordinate.toString());
	}

	@Test
	public void testEquality() {
		Coordinate c1 = new Coordinate(1,2);
		Coordinate c2 = new Coordinate(1, 2);
		assertEquals(c1,c2);
	}
}
