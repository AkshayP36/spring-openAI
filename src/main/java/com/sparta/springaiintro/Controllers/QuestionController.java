package com.sparta.springaiintro.Controllers;

import com.sparta.springaiintro.Models.Answer;
import com.sparta.springaiintro.Models.GetCapitalRequest;
import com.sparta.springaiintro.Models.Question;
import com.sparta.springaiintro.Services.OpenAIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/question")
    public Answer askQuestion(@RequestBody Question question){
        return openAIService.getAnswer(question);
    }


    @PostMapping("/capital")
    public Answer getCapital(@RequestBody GetCapitalRequest getcapitalRequest) {
        return this.openAIService.getCapital(getcapitalRequest);
    }

}
