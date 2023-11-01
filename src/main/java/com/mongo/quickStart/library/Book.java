package com.mongo.quickStart.library;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "books")
public class Book {
    @Id
    private String bookId;
    private String title;
    private String genre;
    private Boolean read;
    private int rating;
    private String imageUrl;


    public Book(){

    };


}
