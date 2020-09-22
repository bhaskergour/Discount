import static org.junit.Assert.*;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.junit.Test;

import com.discount.main.CalculateDiscount;

public class CalculateDiscountTest {

	@Test
	public void DiscountCalculationOnDiffrentAmount() throws DroolsParserException, IOException {
		CalculateDiscount cd = new CalculateDiscount();
		assertEquals("Final amount is not correct.", 5000, cd.DiscountCalculation(5000,"Regular"), 0);
		assertEquals("Final amount is not correct.", 9500, cd.DiscountCalculation(10000,"Regular"), 0);
		assertEquals("Final amount is not correct.", 13500, cd.DiscountCalculation(15000,"Regular"), 0);
		assertEquals("Final amount is not correct.", 3600, cd.DiscountCalculation(4000,"Premium"), 0);
		assertEquals("Final amount is not correct.", 7000, cd.DiscountCalculation(8000,"Premium"), 0);
		assertEquals("Final amount is not correct.", 10200, cd.DiscountCalculation(12000,"Premium"), 0);
		assertEquals("Final amount is not correct.", 15800, cd.DiscountCalculation(20000,"Premium"), 0);
	}

}
