package com.mongo.quickStart.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library/")
public class BookController {

    @Autowired
    private BookServiceImpl service;

    @GetMapping("getBooks")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }
    @GetMapping("getBook/{id}")
    public Book getBookById(@PathVariable("id") String bookId) {
      return service.getBookById(bookId);
    }
    @GetMapping("getBookByGenre/{genre}")
    public List<Book> getBookByGenre(@PathVariable("genre") String genre){
        return service.getBooksByGenre(genre);
    }

    @PostMapping("addBook")
    public String uploadBook (@RequestBody BookDto book){
        service.addBook(book);
        return "added book with book id: " + book.getBookId();
    }
    @PutMapping("updateBook")
    public Book editBook(@RequestBody BookDto book){
        return service.updateBook(book);
    }
    @DeleteMapping("removeBook/{id}")
    public void removeBook(@PathVariable("id") String bookId){
         service.removeBook(bookId);

    }

}
