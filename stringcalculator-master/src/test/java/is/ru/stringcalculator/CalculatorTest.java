package is.ru.stringcalculator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNumbersAndArguments(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testDelimiter2(){
    	assertEquals(3, Calculator.add("//e\n1e2"));
    }

	@Test
	public void testNegative(){
		try
		{
    		Calculator.add("-1,2");
    		fail("Should have thrown Negative yo");
		}
		catch(Exception e)
		{
			assertThat(e.getMessage(), containsString("Negatives not allowed: -1"));
		}
	}

	@Test
	public void testNegative2(){
		try
		{
    		Calculator.add("2,-4,3,-5");
    		fail("Should have thrown Negative yo");
		}
		catch(Exception e)
		{
			assertThat(e.getMessage(), containsString("Negatives not allowed: -4-5"));
		}
	}

	@Test
	public void testTooLarge(){
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testAnyLengthDelimiter(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
}
