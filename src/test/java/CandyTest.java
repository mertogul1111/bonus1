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
    /** Division possible with small numbers. */
    @Test
    public void testDividePossibleSmall() {
        check(4, 20, true);
    }

    /** Division impossible when candies not multiple of kids. */
    @Test
    public void testDivideImpossible() {
        check(4, 21, false);
    }

    /** Zero candies among positive kids is always possible. */
    @Test
    public void testZeroCandies() {
        check(5, 0, true);
    }

    /** Zero kids & some candies is impossible. */
    @Test
    public void testZeroKidsSomeCandies() {
        check(0, 10, false);
    }

    /** Zero kids & zero candies is considered possible (everyone gets zero). */
    @Test
    public void testZeroKidsZeroCandies() {
        check(0, 0, true);
    }

    /** Exactly one kid should always get all candies. */
    @Test
    public void testOneKid() {
        check(1, 123456789L, true);
    }

    /** Each kid gets one candy. */
    @Test
    public void testEachGetsOne() {
        check(7, 7, true);
    }

    /**
     * Candies fewer than kids makes fair division impossible (except when candies
     * are 0).
     */
    @Test
    public void testCandiesLessThanKids() {
        check(10, 3, false);
    }

    /** Large divisible numbers near the upper bound. */
    @Test
    public void testLargeDivisible() {
        long k = 99999999999999999L; // < MAX_VALUE
        long q = 8L;
        long c = k * q;
        check(k, c, true);
    }

    /** Large non‑divisible numbers near the upper bound. */
    @Test
    public void testLargeNonDivisible() {
        long k = 99999999999999991L; // prime‑ish
        long c = 99999999999999989L; // not a multiple of k
        check(k, c, false);
    }

    /** Division with maximum allowed equal values. */
    @Test
    public void testMaxValueFair() {
        check(MAX_VALUE, MAX_VALUE, true);
    }

    /** One kid and maximum candies. */
    @Test
    public void testOneKidMaxCandies() {
        check(1, MAX_VALUE, true);
    }

    /** Remainder classes when dividing by 10 should be impossible. */
    @Test
    public void testAllRemaindersMod10() {
        for (int r = 1; r < 10; r++) {
            long k = 10;
            long c = 100 + r; // 10 * 10 + r -> not divisible
            check(k, c, false);
        }
    }

    /** Deterministic pseudo‑random sweep to expose edge combinations. */
    @Test
    public void testDeterministicSweep() {
        long[] kids = { 2, 3, 5, 8, 13, 21, 34, 55 };
        long[] multipliers = { 0, 1, 2, 7, 42 };
        for (long k : kids) {
            for (long m : multipliers) {
                long c = k * m;
                check(k, c, true);
                if (m > 0) {
                    check(k, c + 1, false); // off‑by‑one candies should fail
                }
            }
        }
    }
    // # END TODO

}
