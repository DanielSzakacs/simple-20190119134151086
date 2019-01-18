package com.codecool.danielnewspro.controller;

import com.codecool.danielnewspro.service.NewsFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EndPoints {

    private NewsFactory newsFactory = new NewsFactory();
    //al-jazeera-english  cnn  fox-news  abc-news  google-news-ru  independent  rt
    @GetMapping("/topnews/{source}")
    public String getNewsBySource(@PathVariable String source, @RequestParam(name = "type", required = false) String type)  {
        type = type == null ? "top" : "";
        try {
            return String.valueOf(newsFactory.getNews(source, type));
        } catch (Exception e) {
            e.printStackTrace();
            return "The is no data";
        }
    }

    @GetMapping("/topnews")
    public String getAllNews() {
        try {
            return String.valueOf(newsFactory.getNews("cnn", "")); // TODO delete the string. Only for test
        } catch (Exception e) {
            e.printStackTrace();
            return "The is no data";
        }
    }
}
