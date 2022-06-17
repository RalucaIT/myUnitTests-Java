package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p04.ComputationUtils.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
class ComputationUtilsTest {
    @DisplayName("0 + 0 = 0")
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));
        // assertEquals(1, sum(0, 0));
        // AssertJ Assertion
        // assertThat(sum(0, 0)).isZero();
    }
    @DisplayName("3 + 0 = 3")
    @Test
    void zeroShouldNotChangePositive() {
        assertEquals(3, sum(0,3));
    }
    @DisplayName("-3 + 0 = -3")
    @Test
    void zeroShouldNotChangeNegative() {
        assertEquals(-3, sum(0,-3));
    }
    @DisplayName("4 + 2 = 2")
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(4, sum(2, 2));
    }
    @DisplayName("-4 + -2 = -2")
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-4, sum(-2,-2));
    }
    @DisplayName("7 + -1 = 8")
    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertEquals(7, sum(-1, 8));
    }
    @DisplayName("-7 + -8 = 1")
    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertEquals(-7, sum(-8, 1));
    }
    @Test
    void zeroShouldNotChangeMaxInt() {
        assertEquals(Integer.MAX_VALUE, sum(0, Integer.MAX_VALUE));
    }
    @Test
    void maxIntAndANegativeNumber() {
        assertEquals(Integer.MAX_VALUE - 1, sum(Integer.MAX_VALUE, -1));
    }
    @Test
    void zeroShouldNotChangeMinInt() {
        assertEquals(Integer.MIN_VALUE, sum(Integer.MIN_VALUE, 0));
    }
    @Test
    void minIntAndAPositiveNumber() {
        assertEquals(Integer.MIN_VALUE + 4, sum(4, Integer.MIN_VALUE));
    }
    @Test
    void minIntAndMaxInt() {
       assertEquals(Integer.MAX_VALUE + Integer.MIN_VALUE, sum(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
    @Disabled
    @Test
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertEquals(Integer.MAX_VALUE + 1, sum(Integer.MAX_VALUE, 1));
    }
}
