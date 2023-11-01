package com.mongo.quickStart.library;


import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String bookId) {
        Book book = new Book();
        Book id = bookRepository.findByBookId(bookId);
        if (Objects.nonNull(id)) {
            return id;
        } else {
            new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
        }
        return book;
    }
    public List<Book> getBooksByGenre(String genre){
       return bookRepository.findBookByGenre(genre);
    }

    public void addBook(BookDto book) {
        Book book1 = new Book();
        BeanUtils.copyProperties(book, book1);
        bookRepository.save(book1);
    }

    public void removeBook(String bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book updateBook(BookDto book) {
        Book book1 = new Book();
        BeanUtils.copyProperties(book, book1);
        return bookRepository.save(book1);
    }
}
