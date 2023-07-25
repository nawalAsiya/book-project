package com.bookstoreapp.service;



import com.bookstoreapp.exception.BookAlreadyExistsException;

import com.bookstoreapp.exception.BookNotFoundException;

import com.bookstoreapp.model.Book;

import com.bookstoreapp.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

//import java.util.Optional;

@Service
public class BookstoreServiceImpl implements BookstoreService {
	@Autowired
	private BookRepository repo;

	public List<Book> getAllBooks() {
	
		return repo.findAll();
	}

	public Book getBookById(int id) {
		Book b = null;
		if (repo.existsById(id)) {
		 b = repo.findById(id).get();
		} else {
		 throw new BookNotFoundException("Book not found");
		}
		return b;
	}

	public Book saveBook(Book book) {
		if (repo.existsById(book.getId())) {		
			 throw new BookAlreadyExistsException("Book already exists");		
			}			
			return repo.save(book);	
	}

	public Book updateBook(int id, Book book) {
		Book b = null;		
		if (repo.existsById(id)) {		
		 b = repo.save(book);		
		} else {		
		 throw new BookNotFoundException("Book not found");		
		}		
		return b;				
	}

	
	public void deleteBook(int id) {
		if (repo.existsById(id)) {
			
			 repo.deleteById(id);
			
			} else {
			
			 throw new BookNotFoundException("Book not found");
			
			}
		
	}



}

//
