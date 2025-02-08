package com.sparta.springaiintro.Services;

import com.sparta.springaiintro.Models.Answer;
import com.sparta.springaiintro.Models.GetCapitalRequest;
import com.sparta.springaiintro.Models.Question;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAIService3rdParty implements OpenAIService{

    private final ChatModel chatModel;

    public OpenAIService3rdParty(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();
        ChatResponse chatResponse = chatModel.call(prompt);
        return chatResponse.getResult().getOutput().getContent();
    }

    @Override
    public Answer getAnswer(Question question) {
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();
        ChatResponse chatResponse = chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getContent());
    }


    @Value("classpath:templates/get-capital-prompt.st")
    private Resource getCapitalPrompt;
    @Override
    public Answer getCapital(GetCapitalRequest getcapitalRequest) {
//        PromptTemplate promptTemplate = new PromptTemplate("What is the capital of "+ getcapitalRequest.stateOrCountry()+" ?");
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", getcapitalRequest.stateOrCountry()));
        ChatResponse chatResponse = chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getContent());
    }
}
