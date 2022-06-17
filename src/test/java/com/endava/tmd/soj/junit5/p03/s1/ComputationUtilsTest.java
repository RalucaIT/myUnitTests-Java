package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.endava.tmd.soj.junit5.p03.s1.ComputationUtils.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
}
