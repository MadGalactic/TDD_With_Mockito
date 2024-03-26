import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {

    @Test
    public void whenIncomeLessThan5LacsThenDeduct10PercentTax() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double payableTax = taxCalculator.calculate(400000.00);
        assertTrue (40000 == payableTax);

        payableTax = taxCalculator.calculate(0);
        assertTrue(0 == payableTax);

        payableTax = taxCalculator.calculate(500000.00);
        assertTrue(50000 == payableTax);
    }

    @Test
    public void whenIncomeBetween5LacsAnd10LacsThenDeductsFiftyThousandPlus20PercentAbove4Lacs() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double payableTax = taxCalculator.calculate(800000.00);
        double expectedTaxForFirstFiveHundredThousand = 50000;
        double expectedTaxForReminder = 60000;
        double expectedTotalTax =
                expectedTaxForFirstFiveHundredThousand +
                        expectedTaxForReminder;
        assertTrue(expectedTotalTax == payableTax);
    }

}
