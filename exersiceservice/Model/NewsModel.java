package com.example.exersiceservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Valid
public class NewsModel {

    @NotEmpty(message = " you should enter an id for News article")
    @Size(min = 3,message = "  the length of ID should be between 3 and 100 characters")
    private String id;


    @NotEmpty(message = " you should enter title")
    @Size(min = 5,max = 100,message = " The title length should be between 5 and 100 characters")
    private String title;


    @NotEmpty(message = " you should enter an author")
    @Size(min = 5,max = 20,message = " the length of author should be between 5 and 10 characters")
    private String author;

    @NotEmpty(message = " the content can not be null")
    @Size(min = 201,message =" the content length should be more than 200" )
    private String content;

    @NotEmpty(message = " the category can not be null")
    @Pattern(regexp = "^(politics|sports|technology)$", message = "Category must be either 'politics', 'sports', or 'technology' only")
    private String category;

    @NotNull(message = " can not be null")
@AssertFalse(message = " you should enter false")
    private boolean isPublished;

    @NotNull(message = " the publish date can not be null")
    @PastOrPresent(message = "Publish date must be in the past or present")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;





}
