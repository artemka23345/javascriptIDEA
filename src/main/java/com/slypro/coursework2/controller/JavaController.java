package com.slypro.coursework2.controller;

import com.slypro.coursework2.model.Question;
import com.slypro.coursework2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService service;

    public JavaController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam ("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam ("question") String question, @RequestParam ("answer") String answer) {
        return service.remove(new Question( question, answer));
    }
    @GetMapping("/getAll")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
