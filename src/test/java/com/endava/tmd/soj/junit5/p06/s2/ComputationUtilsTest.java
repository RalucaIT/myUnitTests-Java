package com.endava.tmd.soj.junit5.p06.s2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s2.ComputationUtils.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Provocare: Rescrieti testul care verifica valoarea sumei a doua numere din tema precedenta
// folosind un fisier (Comma-Separated Value) care sa stocheze datele necesare pentru test
// Fisierul se va numi "sumCheckArguments.csv" si va fi creat in folderul src/test/resources
// Se va utiliza adnotarea @CsvFileSource.
// 
// Testul care verifica exceptiile generate se va copia din tema precedenta
class ComputationUtilsTest {
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvFileSource(resources = "/sumCheckArguments.csv")
    void sumOfTwoNumbers(int nr1, int nr2, int expected) {
        assertEquals(expected, sum(nr1, nr2));
    }

    @ParameterizedTest(name = "{0} + {1} = Overflow while computing")
    @CsvSource({"2147483647,9", "2147483647,30"})
    void exceptionWithParameter(int nr1, int nr2) {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum(nr1, nr2));
        assertEquals("Overflow while computing the sum", exception.getMessage());
    }
}
