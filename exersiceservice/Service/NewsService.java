package com.example.exersiceservice.Service;


import com.example.exersiceservice.Model.NewsModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsService {
    ArrayList<NewsModel>news=new ArrayList<>();


    //display all
    public ArrayList<NewsModel>getNewsArtical(){
        return news;

    }



    public void addNews(NewsModel newsArtical){
        news.add(newsArtical);
    }


    public boolean updateNews(String id,NewsModel ne) {
        for (NewsModel model : news) {
            if (model.getId().equals(id)) {
                int i = news.indexOf(model);
                news.set(i, ne);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNews(String id){
        for(NewsModel model:news){
            if (model.getId().equals(id)){
                int i=news.indexOf(model);
                news.remove(i);
                return true;
            }
        }
        return false;
    }

//get published news
    public ArrayList<NewsModel> getPublishedNews() {
        ArrayList<NewsModel> publishedNews = new ArrayList<>();
        for (NewsModel model : news) {
            if (model.isPublished()) {
                publishedNews.add(model);
            }
        }
        return publishedNews;
    }

    //get by caterogy
    public ArrayList<NewsModel> getNewsByCategory(String category) {
        ArrayList<NewsModel> filteredNews = new ArrayList<>();
        for (NewsModel model : news) {
            if (model.getCategory().equalsIgnoreCase(category)) {
                filteredNews.add(model);
            }
        }
        return filteredNews;
    }

    public boolean publishNews(String id) {
        for (NewsModel model : news) {
            if (model.getId().equals(id)) {
                model.setPublished(true);
                return true;
            }
        }
        return false;  // If not found
    }
}





