import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 *
 * <!--//# BEGIN TODO: Name, student ID, and date-->
 * <p>
 * <b>Mert Ogul 1935992 09/05/2025</b>
 * </p>
 * <!--//# END TODO-->
 */
public class CandyTest {

    static final Candy SUT = null; // to simplify method calls

    static final long MAX_VALUE = 999999999999999999L;

    /**
     * Checks the result of SUT.divide(k, c).
     */
    private void check(long k, long c, boolean expected) {
        System.out.println("divide(" + k + ", " + c + ")");
        long result = SUT.divide(k, c);
        System.out.println("  result = " + result);
        assertEquals(expected, 0 <= result, "possible (0 <= result)");
        if (0 <= result) {
            assertTrue(result <= MAX_VALUE, "range (result <= MAX_VALUE)");
            assertEquals(result * k, c, "quotient (result * k == c)");
        }
    }

    // Test cases

    /** The given example. */
    @Test
    public void testDivideGivenExample() {
        check(3, 15, true);
    }

    // # BEGIN TODO: Additional test cases
    // Division possible with small numbers.
    @Test
    public void testDividePossibleSmall() {
        check(4, 20, true);
    }

    // Division impossible when candies not multiple of kids.
    @Test
    public void testDivideImpossible() {
        check(4, 21, false);
    }

    // Zero candies should be divisible among any positive number of kids.
    @Test
    public void testDivideZeroCandies() {
        check(5, 0, true);
    }

    // Zero kids makes division impossible.
    @Test
    public void testDivideZeroKids() {
        check(0, 10, false);
    }

    // Division with maximum allowed values.
    @Test
    public void testDivideMaxValueFair() {
        check(MAX_VALUE, MAX_VALUE, true);
    }

    // Max values but not divisible.
    @Test
    public void testDivideMaxValueNotFair() {
        check(MAX_VALUE, MAX_VALUE - 1, false);
    }
    // # END TODO

}
