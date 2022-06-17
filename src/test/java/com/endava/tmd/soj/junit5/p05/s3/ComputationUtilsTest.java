package com.endava.tmd.soj.junit5.p05.s3;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s3.ComputationUtils.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
//        assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
//        assertThatThrownBy(() -> sum(2147483647, 1))
//                .isInstanceOf(ArithmeticException.class)
//                .hasMessage("Overflow while computing the sum");
    }
    @Test
    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(Integer.MIN_VALUE, -1));
        assertEquals("Overflow while computing the sum", exception.getMessage());
    }
}
