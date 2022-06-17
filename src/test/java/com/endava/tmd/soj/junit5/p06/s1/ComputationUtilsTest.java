package com.endava.tmd.soj.junit5.p06.s1;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// ---> E suficient sa scrieti 2 teste distincte: <---
// - Un test care verifica valoarea sumei a doua numere;
// - Un test care verifica exceptiile generate;         // metoda pt exceptii
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName, ci in atributul "name" al adnotarii @ParameterizedTest.

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
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
        assertEquals(3, sum(0, 3));
    }

    @DisplayName("-3 + 0 = -3")
    @Test
    void zeroShouldNotChangeNegative() {
        assertEquals(-3, sum(0, -3));
    }

    @DisplayName("4 + 2 = 2")
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(4, sum(2, 2));
    }

    @DisplayName("-4 + -2 = -2")
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-4, sum(-2, -2));
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

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({"2,3,5", "8,11,19"})
    void sumOfTwoNumbers(int nr1, int nr2, int expected) {
        assertEquals(expected, sum(nr1, nr2));
    }

    @ParameterizedTest(name = "{0} + {1} = Overflow while computing")
    @CsvSource({"2147483647,9", "2147483647,30"})
    void exceptionWithParameter(int nr1, int nr2) {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(nr1, nr2));
        assertEquals("Overflow while computing the sum", exception.getMessage());
    }
}
