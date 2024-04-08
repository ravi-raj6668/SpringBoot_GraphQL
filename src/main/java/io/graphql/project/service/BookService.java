package io.graphql.project.service;

import io.graphql.project.entity.Book;

import java.util.List;

public interface BookService {
    public Book createBook(Book book);

    public List<Book> getAllBook();

    public Book getBook(int id);

    public boolean deleteBook(int id);

}
