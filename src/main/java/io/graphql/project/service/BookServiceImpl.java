package io.graphql.project.service;

import io.graphql.project.entity.Book;
import io.graphql.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found on server !!!"));
    }

    @Override
    public boolean deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found on server...!!!"));
        bookRepository.delete(book);
        return true;
    }
}
