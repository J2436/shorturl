package com.j2436.shorturl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortUrlController {
    @GetMapping("/")
    public String home(){
        return "Hello Docker";
    }
}
