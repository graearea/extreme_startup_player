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
    void mult() {
        var contents = new Answerer().answerFor("What is 53 multiplied by 95?");

        assertThat(contents, equalTo("5035"));
    }
}