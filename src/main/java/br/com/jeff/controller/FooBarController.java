package br.com.jeff.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("book-service")
public class FooBarController {

    private Logger logger = LoggerFactory.getLogger(FooBarController.class);


    @GetMapping("/foo-bar")
    //@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
    //@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    @RateLimiter(name = "default")
    public String FooBar(){
        logger.info("request to foo bar is received!");
        //var response = new RestTemplate()
        //        .getForEntity("http://localhost:8080/foo-bar", String.class);
        return "FooBar!!!";
        //return response.getBody();
    }

    public String fallbackMethod(Exception ex){
        return "FallBackMethod foo-bar!";
    }
}
