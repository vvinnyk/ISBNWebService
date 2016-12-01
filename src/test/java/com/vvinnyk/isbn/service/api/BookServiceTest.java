package com.vvinnyk.isbn.service.api;

import com.vvinnyk.isbn.TestDataCreator;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.model.ISBN;
import com.vvinnyk.isbn.repository.api.BookRepository;
import com.vvinnyk.isbn.service.impl.BookServiceImpl;
import com.vvinnyk.isbn.connectionmanager.api.WebServiceConnectionManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class BookServiceTest {
    private BookService bookService;

    @Mock
    private WebServiceConnectionManager webServiceConnectionManager;

    @Mock
    private BookRepository bookRepository;

    private Book book;

    @Before
    public void setup() {
        this.book = TestDataCreator.createBooks(1)
                .stream().findFirst().get();
        initMocks(this);
        this.bookService = new BookServiceImpl(webServiceConnectionManager, bookRepository);
    }

    @Test
    public void shouldReturnBookUsingISBN10() {
        ISBN isbn = book.getIsbn();
        Mockito.when(webServiceConnectionManager.requestBook(isbn.getIsbn10())).thenReturn(book);

        Book result = webServiceConnectionManager.requestBook(isbn.getIsbn10());
        Assert.assertEquals(book, result);
    }

    @Test
    public void shouldReturnBookUsingISBN13() {
        ISBN isbn = book.getIsbn();
        Mockito.when(webServiceConnectionManager.requestBook(isbn.getIsbn13())).thenReturn(book);

        Book result = webServiceConnectionManager.requestBook(isbn.getIsbn13());
        Assert.assertEquals(book, result);
    }
}