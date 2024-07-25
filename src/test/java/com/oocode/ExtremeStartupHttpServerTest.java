package com.oocode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class ExtremeStartupHttpServerTest {
    private ExtremeStartupHttpServer server;

    @Test
    void canAnswerMyName() throws Exception {
        var contents = new SimpleHttpClient().readUrl("http://127.0.0.1:9123?q=What+is+your+name%3F");

        assertThat(contents, equalTo("JaeRae"));
    }

    @Test
    void showsHomePageIfMissingQueryString() throws Exception {
        var contents = new SimpleHttpClient().readUrl("http://127.0.0.1:9123");

        assertThat(contents, containsString("<html>"));
    }

    @BeforeEach
    void startLocalServer() {
        server = new ExtremeStartupHttpServer(9123);
        server.start();
    }

    @AfterEach
    void stopLocalServer() {
        server.stop();
    }
}
