package com.sparta.springaiintro.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OpenAIService3rdPartyTest {
    @Autowired
    OpenAIService openAIService;


    @Test
    void testGetAnswer() {
//        String ans = openAIService.getAnswer("can you play a song for me?");
        System.out.println("Finished fetching ans");
//        System.out.println(ans);
    }
}