package com.j2436.shorturl;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;

@RequestMapping("/")
@RestController
public class ShortUrlController {

   @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/{id}")
    public String home(@PathVariable String id){
        String url = redisTemplate.opsForValue().get(id);
        System.out.println("URL Retrieved" + url);
        return url;
    }

    @PostMapping
    public String createShortUrl(@RequestBody String longUrl){

        UrlValidator urlValidator = new UrlValidator(
                new String[]{"http", "https"}
        );

        if (urlValidator.isValid(longUrl)){
            String id = Hashing.murmur3_32().hashString(longUrl, StandardCharsets.UTF_8).toString();
            redisTemplate.opsForValue().set(id,longUrl);
            return id;
        }

        throw new RuntimeException("URL invalid: " + longUrl);
    }
}
