package com.vvinnyk.isbn.service.api;

import com.vvinnyk.isbn.TestDataCreator;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.model.ISBN;
import com.vvinnyk.isbn.repository.api.BookRepository;
import com.vvinnyk.isbn.repository.impl.BookRepositoryImpl;
import com.vvinnyk.isbn.service.impl.BookServiceImpl;
import com.vvinnyk.isbn.connectionmanager.api.WebServiceConnectionManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class BookServiceIntegrationTest {
    private BookService bookService;

    @Mock
    private WebServiceConnectionManager webServiceConnectionManager;

    private BookRepository bookRepository;

    private Book book;

    @Before
    public void setup() {
        bookRepository = new BookRepositoryImpl();
        this.book = TestDataCreator.createBooks(1)
                .stream().findFirst().get();
        initMocks(this);
        this.bookService = new BookServiceImpl(webServiceConnectionManager, bookRepository);
        Mockito.when(webServiceConnectionManager.requestXmlDocument(Matchers.any(String.class))).thenThrow(new RuntimeException("External Resource not allowed"));
    }

    @Test
    public void shouldReturnBookUsingISBN10FromDataBase() {
        book = this.bookRepository.save(book);
        ISBN isbn = book.getIsbn();

        Book result = bookService.search(isbn.getIsbn10());

        Assert.assertEquals(book, result);
    }

    @Test
    public void shouldReturnBookUsingISBN13FromDataBase() {
        book = this.bookRepository.save(book);
        ISBN isbn = book.getIsbn();

        Book result = bookService.search(isbn.getIsbn13());

        Assert.assertEquals(book, result);
    }

}
