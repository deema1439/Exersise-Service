package com.example.exersiseservice.Service;

import com.example.exersiseservice.Model.NewsArticle;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticleService {

    ArrayList<NewsArticle>newsArticles=new ArrayList<>();

    public ArrayList<NewsArticle>getNews(){

        return newsArticles;
    }

    public void addNews(NewsArticle news){
        news.setPuplished(false);
        newsArticles.add(news);
    }

    public boolean updatenews(String id,NewsArticle news){
        for(int i =0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getId().equals(id)){
                news.setId(id);
                newsArticles.set(i,news);
                return true;
            }
        }

        return false;
    }

    public boolean deleteNews(String id){
        for(int i=0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getId().equals(id)){
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
    }


    public int Publish(String id){
       for(NewsArticle n:newsArticles){
           if(n.getId().equals(id)){
               if(n.isPuplished()){
                   return 1;
               }
               n.setPuplished(true);
               return 0;
           }
       }
       return 2;
    }

    public ArrayList<NewsArticle>GetPublish(){
        ArrayList<NewsArticle>result=new ArrayList<>();
        for (NewsArticle n:newsArticles){
            if(n.isPuplished()){
                result.add(n);
            }
        }
        return result;
    }

    public NewsArticle getid(String id){
        for(NewsArticle n:newsArticles){
            if(n.getId().equals(id)){
                return n;
            }
        }
        return null;
    }

    public ArrayList<NewsArticle>GetNewsByAr(String category){
        ArrayList<NewsArticle>result=new ArrayList<>();
        for(NewsArticle c:newsArticles){
            if(c.getCategory().equalsIgnoreCase(category)){
                result.add(c);
            }
        }
        return result;
    }

























}
