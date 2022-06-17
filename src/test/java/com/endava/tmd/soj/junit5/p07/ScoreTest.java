package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare?

class ScoreTest {
    private Score score;

    @BeforeAll
    static void setupLocaleTimeZone(){
        Locale.setDefault(Locale.US);
    }

    @BeforeEach
    void setup() {
        score = new Score();
    }

    @Test
    void oneCorrectAnswer() {
        score.addCorrectAnswer();
        assertEquals("100.0", score.getPercent());
    }

    @Test
    void oneIncorrectAnswer() {
        score.addIncorrectAnswer();
        assertEquals("0.0", score.getPercent());
    }

    @Test
    void oneCorrectAndTwoIncorrectAnswers() {
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        assertEquals("33.3", score.getPercent());
    }
}


// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?