import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	GradeBook g1;
	GradeBook g2;
	GradeBook g3;
	
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g3 = new GradeBook(0);
		g1.addScore(33);
		g1.addScore(67);
		g2.addScore(67);
		g2.addScore(133);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
		g3 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("33.0 67.0 "));
		assertTrue(g2.toString().equals("67.0 133.0 "));
		assertTrue(g3.toString().equals(""));
		assertEquals(2, g1.getScoreSize(), .0001);
		assertEquals(2, g2.getScoreSize(), .0001);
		assertEquals(0, g3.getScoreSize(), .0001);
	}

	@Test
	void testSum() {
		assertEquals(100, g1.sum(), .0001);
		assertEquals(200, g2.sum(), .0001);
		assertEquals(0, g3.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(33, g1.minimum(), .0001);
		assertEquals(67, g2.minimum(), .0001);
		assertEquals(0, g3.minimum(), .0001);
	}

	@Test
	void testFinalScore() {
		assertEquals(67, g1.finalScore(),.0001);
		assertEquals(133, g2.finalScore(),.0001);
		assertEquals(0, g3.finalScore(),.0001);
	}
	
	@Test
	void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize(),.0001);
		assertEquals(2, g2.getScoreSize(),.0001);
		assertEquals(0, g3.getScoreSize(),.0001);
	}
	
	@Test 
	void testToString() {
		assertTrue(g1.toString().equals("33.0 67.0 "));
		assertTrue(g2.toString().equals("67.0 133.0 "));
		assertTrue(g3.toString().equals(""));
	}
}
