package com.vvinnyk.isbn.rest.api;

import com.vvinnyk.isbn.TestDataCreator;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.model.ISBN;
import com.vvinnyk.isbn.rest.impl.BookRestControllerImpl;
import com.vvinnyk.isbn.service.api.BookService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class BookRestControllerTest {
    private BookRestController bookRestController;

    @Mock
    private BookService bookService;

    private Book book;

    @Before
    public void setUp() {
        this.book = TestDataCreator.createBooks(1)
                .stream().findFirst().get();
        initMocks(this);
        this.bookRestController = new BookRestControllerImpl(bookService);
    }

    @Test
    public void shouldReturnValidFormattedJSON() throws IOException {
        ISBN isbn = book.getIsbn();
        Mockito.when(bookService.search(isbn.getIsbn10())).thenReturn(book);

        ObjectMapper objectMapper = new ObjectMapper();

        String expectedJSON = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(book);
        String resultJSON = bookRestController.getBookAsJSON(isbn.getIsbn10());

        Assert.assertEquals(expectedJSON, resultJSON);
    }
}