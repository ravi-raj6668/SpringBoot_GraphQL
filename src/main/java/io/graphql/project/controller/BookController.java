package io.graphql.project.controller;

import io.graphql.project.entity.Book;
import io.graphql.project.service.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //create book
    @MutationMapping("createBook")
    public Book createBook(@Argument BookInput book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setDescription(book.getDescription());
        b.setPrice(book.getPrice());
        b.setPages(book.getPages());
        return bookService.createBook(b);
    }

    //find all book
    @QueryMapping("allBooks")
    public List<Book> getAllBook() {
        return bookService.getAllBook();

    }

    //get book by id
    @QueryMapping("getBook")
    public Book getBook(@Argument int id) {
        return bookService.getBook(id);
    }

    @MutationMapping("deleteBook")
    public boolean deleteBook(@Argument int id){
        bookService.deleteBook(id);
        return true;
    }
}

@Data
class BookInput {
    private String title;
    private String description;
    private String author;
    private double price;
    private int pages;
}
