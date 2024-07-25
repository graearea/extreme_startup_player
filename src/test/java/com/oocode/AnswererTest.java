package com.oocode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class AnswererTest {
    @Test
    void canAnswerMyName() {
        var contents = new Answerer().answerFor("What is your name?");

        assertThat(contents, equalTo("JaeRae"));
    }

    @Test
    void picksBiggestNumber() {
        var contents = new Answerer().answerFor("Which of the following numbers is the largest: 98, 77, 19?");

        assertThat(contents, equalTo("98"));
    }

    @Test
    void addition() {
        var contents = new Answerer().answerFor("What is 35 plus 26?");

        assertThat(contents, equalTo("61"));
    }

    @Test
    void minus() {
        var contents = new Answerer().answerFor("What is 35 minus 26?");

        assertThat(contents, equalTo("9"));
    }

    @Test
    void mult() {
        var contents = new Answerer().answerFor("What is 53 multiplied by 95?");

        assertThat(contents, equalTo("5035"));
    }

    @Test
    void squareAndCubed() {
        var content = new Answerer().answerFor("Which of the following numbers is both a square and a cube: 4096, 216, 2973, 2500, 756, 4506, 592?");

        assertThat(content, equalTo("4096"));
    }

    @Test
    void squarePowered() {
        var content = new Answerer().answerFor("What is 4 to the power of 2?");

        assertThat(content, equalTo("16"));
    }
}