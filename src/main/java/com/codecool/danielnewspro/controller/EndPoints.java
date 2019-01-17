package com.codecool.danielnewspro.controller;

import com.codecool.danielnewspro.service.NewsFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EndPoints {

    private NewsFactory newsFactory = new NewsFactory();

    //al-jazeera-english  cnn  fox-news  abc-news  google-news-ru  independent  rt
    @GetMapping("/topnews/{source}")
    public String getAllTopNews(@PathVariable String source)  {
        try {
            return String.valueOf(newsFactory.getNews(source));
        } catch (Exception e) {
            e.printStackTrace();
            return "The is no data";
        }
    }

    @GetMapping("/topnews")
    public String getAllNews() {
        try {
            return String.valueOf(newsFactory.getNews("cnn")); // TODO delete the string, Just for practice
        } catch (Exception e) {
            e.printStackTrace();
            return "The is no data";
        }
    }
}
