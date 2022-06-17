package com.endava.tmd.soj.junit5.p06.s3;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComputationUtilsTest {
    public static Stream<Arguments> sumOfTwoNumbers() {
        return Stream.of(Arguments.of(1, 2, 3),
                Arguments.of(20, 30, 50),
                Arguments.of(9, 11, 20)
        );
    }

    public static Stream<Arguments> exceptionWithParameter() {
        return Stream.of(Arguments.of(Integer.MAX_VALUE, 2));
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource()
    void sumOfTwoNumbers(int nr1, int nr2, int expected) {
        assertEquals(expected, sum(nr1, nr2));
    }

    @ParameterizedTest(name = "{0} + {1} = Overflow while computing")
    @MethodSource()
    void exceptionWithParameter(int nr1, int nr2) {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(nr1, nr2));
        assertEquals("Overflow while computing the sum", exception.getMessage());
    }
}
