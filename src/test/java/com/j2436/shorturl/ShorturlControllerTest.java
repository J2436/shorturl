package com.j2436.shorturl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest
public class ShorturlControllerTest {
    private static final String LONG_URL = "https://google.com";
    private static final String SHORT_URL = "1b016c48";
}
