package io.graphql.project.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.graphql.project.entity.Book;
import io.graphql.project.service.BookService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
class BookControllerDiffblueTest {
    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;

    /**
     * Method under test: {@link BookController#getAllBook()}
     */
    @Test
    void testGetAllBook() {
        // Arrange
        ArrayList<Book> bookList = new ArrayList<>();
        when(bookService.getAllBook()).thenReturn(bookList);

        // Act
        List<Book> actualAllBook = bookController.getAllBook();

        // Assert
        verify(bookService).getAllBook();
        assertTrue(actualAllBook.isEmpty());
        assertSame(bookList, actualAllBook);
    }
}
