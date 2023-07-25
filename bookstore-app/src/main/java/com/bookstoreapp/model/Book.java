package com.bookstoreapp.model;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;

import javax.validation.constraints.*;


//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Valid
public class Book {

   @Id
    private int id;
    @Column(name = "title_name", length = 50, nullable = false)
	@NotBlank(message = "Title is required")
	@Size(max = 100, message = "Title should not exceed 100 characters")
    private String title;

    @NotBlank(message = "Author name required")
	@Size(max = 200, message = "author should not exceed 200 characters")
    private String author;
    
    @Column(unique = true)
    //@Digits(integer = 4, message = "Publication year must be a valid 4-digit number", fraction = 0)
    @Min(1000)
    @Max(9999)
    private int publicationYear;
    
    @Column(unique = true)
	//@Pattern(regexp = "^(\\d{10}||\\d{13})$", message = "The ISBN should be a valid 10- or 13-digit number")
    @Min(1000000000l)
    @Max(9999999999999l)
    private long isbn;
    @Positive(message = "The price should be a positive decimal value.")
	@DecimalMin(value = "0.01", message = "Price must be a positive decimal value")
    private double price;
    public Book(int id,
            @NotBlank(message = "Title is required") @Size(max = 100, message = "Title should not exceed 100 characters") String title,
            @NotBlank(message = "Author name required") @Size(max = 200, message = "author should not exceed 200 characters") String author,
            @Min(1000) @Max(9999) int publicationYear, @Min(1000000000) @Max(9999999999999l) long isbn,
            @Positive(message = "The price should be a positive decimal value.") @DecimalMin(value = "0.01", message = "Price must be a positive decimal value") double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + publicationYear;
        result = prime * result + (int) (isbn ^ (isbn >>> 32));
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (publicationYear != other.publicationYear)
            return false;
        if (isbn != other.isbn)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }





    

}
