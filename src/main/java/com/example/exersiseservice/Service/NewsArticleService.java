package com.example.exersiseservice.Service;

import com.example.exersiseservice.Model.NewsArticle;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
@AllArgsConstructor
public class NewsArticleService {

    ArrayList<NewsArticle>newsArticles=new ArrayList<>();

    public ArrayList<NewsArticle>getNews(){
        return newsArticles;
    }

    public void addNews(NewsArticle news){
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


    public NewsArticle Publish(String id){
       for(NewsArticle n:newsArticles){
           if(n.getId().equals(id)){
               n.setPuplished(true);
               return n;
           }
       }
       return null;
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

    public ArrayList<NewsArticle>GetNewsByAr(String category){
        ArrayList<NewsArticle>result=new ArrayList<>();
        for(NewsArticle c:newsArticles){
            if(c.getCategory().equals(category)){
                result.add(c);
            }
        }
        return result;
    }

























}
