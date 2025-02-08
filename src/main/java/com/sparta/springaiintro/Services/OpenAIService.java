package com.sparta.springaiintro.Services;

import com.sparta.springaiintro.Models.Answer;
import com.sparta.springaiintro.Models.GetCapitalRequest;
import com.sparta.springaiintro.Models.Question;

public interface OpenAIService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    Answer getCapital(GetCapitalRequest getcapitalRequest);
}
