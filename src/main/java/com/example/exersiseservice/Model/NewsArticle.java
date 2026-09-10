package com.example.exersiseservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {

    @NotEmpty(message = "id can not be empty ")
    private String id;

    @NotEmpty(message = "title can not be Empty ")
    @Size(max = 100 ,message = " to 100 characters only  ")
    private String title;


    @NotEmpty(message = "author can not be Empty ")
    @Size(min = 5,max = 20 ,message = "between 5 and 20 characters only ")
    private String author;



     @NotEmpty(message = "content can not be Empty")
     @Size(min = 201,message = "must be more than 200")
    private String content;


    @NotEmpty(message = "can not be empty")
    @Pattern(regexp = "(?i)^(Politics|Sports|Technology)$"
            ,message = "must be Politics , Sports ,Technology")
    private String category;

    @NotEmpty(message = "imgUrl Can not be Empty")
    private String imgUrl;

    @AssertFalse(message = "set False as a default")
    private boolean isPuplished;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;





























}
