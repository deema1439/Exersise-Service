package com.example.exersiseservice.Controller;

import com.example.exersiseservice.ApiResponse.ApiRes;
import com.example.exersiseservice.Model.NewsArticle;
import com.example.exersiseservice.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor

public class NewsArticleController {
    private final NewsArticleService newsservice;

    @GetMapping("/get")
    public ResponseEntity<?>getNews(){
        ArrayList<NewsArticle>getNews=newsservice.getNewsArticles();
        return ResponseEntity.status(200).body(getNews);
    }

    @PostMapping("/addnews")
    public ResponseEntity<?>addNews(@RequestBody @Valid NewsArticle newsArticle, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        newsservice.addNews(newsArticle);
        return ResponseEntity.status(200).body(new ApiRes("has added"));
    }
    @PutMapping("/updatenews/{id}")
    public ResponseEntity<?>updteNews(@PathVariable String id,@RequestBody @Valid NewsArticle newsArticle,Errors errors){
       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
        boolean updatenews=newsservice.updatenews(id,newsArticle);
       if(updatenews) {
           return ResponseEntity.status(200).body(new ApiRes("news has updated "));
       }
        return ResponseEntity.status(400).body(new ApiRes("Id Not Found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteNews(@PathVariable String id){
        boolean deleteid=newsservice.deleteNews(id);
        if(deleteid){
            return ResponseEntity.status(200).body(new ApiRes("news has deleted"));
        }
        return ResponseEntity.status(400).body(new ApiRes("Id Not Found"));
    }

    @PutMapping("/updateispuplish/{id}")
    public ResponseEntity<?>updateSet(@PathVariable String id){
        NewsArticle update=newsservice.Publish(id);
        if(update==null){
            return ResponseEntity.status(400).body(new ApiRes("id not found"));
        }
        return ResponseEntity.status(200).body(update);
    }
    @GetMapping("/getpuplish")
    public ResponseEntity<?>GetPuplished(){
        ArrayList<NewsArticle>getPublish=newsservice.GetPublish();
        if(getPublish.isEmpty()){
            return ResponseEntity.status(400).body(new ApiRes("not found"));
        }
        return ResponseEntity.status(200).body(getPublish);

    }
    @GetMapping("/getnewsbycatagory/{category}")
    public ResponseEntity<?>GetNewsByAr(@PathVariable String category){
        ArrayList<NewsArticle>getNewsBy=newsservice.GetNewsByAr(category);
        if(getNewsBy.isEmpty()){
            return ResponseEntity.status(400).body(new ApiRes("not found"));
        }
        return ResponseEntity.status(200).body(getNewsBy);
    }






















}
