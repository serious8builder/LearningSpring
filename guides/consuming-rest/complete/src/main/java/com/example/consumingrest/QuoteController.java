package com.example.consumingrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/quote")
    public String getQuote() {
        Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
        String quoteStr = quote.getValue().getQuote();
        return quoteStr;
    }
}
