package com.vvinnyk.isbn.rest.impl;

import com.vvinnyk.isbn.Properties;
import com.vvinnyk.isbn.exception.JSONConversionException;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.rest.api.BookRestController;
import com.vvinnyk.isbn.service.api.BookService;
import com.vvinnyk.isbn.service.impl.BookServiceImpl;
import com.google.common.collect.Lists;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.vvinnyk.isbn.utils.Messages.BOOK_CANT_BE_FOUND;
import static com.vvinnyk.isbn.utils.Messages.UNABLE_CONVERT_TO_JSON;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class BookRestControllerImpl implements BookRestController {
    private static final Logger LOG = LoggerFactory.getLogger(Properties.LOGGER_NAME);

    private BookService bookService;

    public BookRestControllerImpl() {
        this.bookService = new BookServiceImpl();
    }

    public BookRestControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    public String getBookAsJSON(String isbn) {
        Book book = bookService.search(isbn);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
        } catch (IOException e) {
            LOG.error(UNABLE_CONVERT_TO_JSON, e);
            throw new JSONConversionException(BOOK_CANT_BE_FOUND, UNABLE_CONVERT_TO_JSON + e, Lists.newArrayList(book.getIsbn().toString()));
        }

    }
}
