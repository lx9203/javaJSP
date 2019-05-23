package JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import JUnit.*;

public class CalculatorTest {
	private Calculator calc = null;
	
	@Before
	public void beforeTest() {
		calc = new Calculator();
		System.out.println("beforeTest()");
	}
	
	@Test
	public void addTest() {
		calc = new Calculator();
		int result = calc.add(10, 20);
		assertEquals(30, result);
		System.out.println("addTest()");
	}
	
	@Test
	public void subTest() {
		calc = new Calculator();
		int result = calc.sub(10, 20);
		assertEquals(-10, result);
		System.out.println("subTest()");
	}
	
	@Test
	public void mulTest() {
		calc = new Calculator();
		int result = calc.mul(2, 10);
		assertEquals(20, result);
		System.out.println("mulTest()");
	}
	
	@Test
	public void divTest() {
		assertEquals(0.5, calc.div(10.0, 20.0), 0.00001);
		System.out.println("divTest()");
	}
	
	@After
	public void afterTest() {
		System.out.println("afterTest()");
	}
}
