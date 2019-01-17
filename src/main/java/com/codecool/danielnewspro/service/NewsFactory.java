package com.codecool.danielnewspro.service;
import org.json.JSONObject;

public class NewsFactory {

    public Object getNews(String channelName) throws Exception {
        return buildNews(channelName);
    }

    private Object buildNews(String channelName) throws Exception{
        Object newsObject = getNewsApiRead(channelName).get("articles");
        return newsObject;
    }

    private JSONObject getNewsApiRead(String channelName) throws Exception {
        String url = "https://newsapi.org/v2/everything?sources=" + channelName + "&apiKey=707805dad8ed44f1b6c24adb59e2739c";
        return UrlReader.getJsonObjectFromUrl(url);
    }
}
