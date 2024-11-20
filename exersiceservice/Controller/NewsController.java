package com.example.exersiceservice.Controller;


import com.example.exersiceservice.Api.ApiResponse;
import com.example.exersiceservice.Model.NewsModel;
import com.example.exersiceservice.Service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsController {

private final NewsService newsService;

@GetMapping("/display")
public ResponseEntity getNewsArtical(){
    ArrayList<NewsModel> newsModel=newsService.getNewsArtical();
    return ResponseEntity.status(200).body(newsModel);
}

//ADD
@PostMapping("/add")
public ResponseEntity addNewsArtical(@RequestBody @Valid NewsModel model, Errors errors){
   if (errors.hasErrors()){
       String message=errors.getFieldError().getDefaultMessage();
       return ResponseEntity.status(400).body(message);
   }

   newsService.addNews(model);

    return ResponseEntity.status(200).body(new ApiResponse(" add successfuly"));
}



//UPDATE
@PutMapping("/update/{id}")
 public ResponseEntity updateNews(@PathVariable String id,@RequestBody @Valid NewsModel model,Errors errors){
    if (errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    boolean update=newsService.updateNews(id,model);
    if (update==true){
        return ResponseEntity.status(200).body(new ApiResponse(" update success"));
    }
    return ResponseEntity.status(400).body(new ApiResponse("news not found"));
 }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNews(@PathVariable String id) {
        boolean deleted = newsService.deleteNews(id);
        if (deleted==true) {
            return ResponseEntity.status(200).body(new ApiResponse("News article deleted successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("News article not found"));
    }


    // Publish a News  by ID
    @PutMapping("/publishe/{id}")
    public ResponseEntity publishNews(@PathVariable String id) {
        boolean published = newsService.publishNews(id);
        if (published==true) {
            return ResponseEntity.status(200).body(new ApiResponse("News article published successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("News article not found"));
    }

    // Get all Published News Articles
    @GetMapping("/publishe")
    public ResponseEntity getPublishedNews() {
        ArrayList<NewsModel> publishedNews = newsService.getPublishedNews();
        return ResponseEntity.status(200).body(publishedNews);
    }


    @GetMapping("/category/{category}")
    public ResponseEntity getNewsByCategory(@PathVariable String category) {
        ArrayList<NewsModel> newsByCategory = newsService.getNewsByCategory(category);
        return ResponseEntity.status(200).body(newsByCategory);
    }

}
