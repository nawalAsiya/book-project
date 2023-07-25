package com.bookstoreapp.controller;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
@Validated
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @GetMapping
     @ResponseStatus(code=HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookstoreService.getAllBooks();
    }


   @PostMapping
   @ResponseStatus(code=HttpStatus.OK)
    public Book saveBook(@RequestBody Book book) {
        return bookstoreService.saveBook(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Book updateBook(@PathVariable int id,  @RequestBody Book book) {
        return bookstoreService.updateBook(id, book);
    }

   @DeleteMapping("/{id}")
   @ResponseStatus(code=HttpStatus.OK)
    public void deleteBook( @PathVariable  int id) {
        bookstoreService.deleteBook(id);
    }

   @GetMapping("/{id}")
   @ResponseStatus(code=HttpStatus.OK)
    public Book getBookById( @PathVariable  int id) {
       return bookstoreService.getBookById(id);
    }




}
