package com.mongo.quickStart.library;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    String bookId;
    String title;
    String genre;
    Boolean read;
    int rating;
    String imageUrl;
}
