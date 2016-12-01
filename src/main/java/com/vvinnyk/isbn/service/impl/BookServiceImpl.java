package com.vvinnyk.isbn.service.impl;

import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.repository.api.BookRepository;
import com.vvinnyk.isbn.repository.impl.BookRepositoryImpl;
import com.vvinnyk.isbn.service.api.BookService;
import com.vvinnyk.isbn.connectionmanager.api.WebServiceConnectionManager;
import com.vvinnyk.isbn.connectionmanager.api.WebServiceConnectionManagerWrapper;
import com.vvinnyk.isbn.connectionmanager.impl.WebServiceConnectionManagerImpl;
import com.vvinnyk.isbn.connectionmanager.impl.WebServiceConnectionManagerWrapperImpl;

/**
 * @author Vladyslav_Vinnyk on 30.11.2016.
 */
public class BookServiceImpl implements BookService {

    private WebServiceConnectionManager webServiceConnectionManager;

    private BookRepository bookRepository;

    public BookServiceImpl() {
        this.webServiceConnectionManager = new WebServiceConnectionManagerImpl();
        this.bookRepository = new BookRepositoryImpl();
    }

    public BookServiceImpl(WebServiceConnectionManager webServiceConnectionManager, BookRepository bookRepository) {
        this.webServiceConnectionManager = webServiceConnectionManager;
        this.bookRepository = bookRepository;
    }

    @Override
    public Book search(String isbn) {
        WebServiceConnectionManagerWrapper webServiceConnectionMangerWrapper = new WebServiceConnectionManagerWrapperImpl(webServiceConnectionManager, bookRepository);
        return webServiceConnectionMangerWrapper.requestBook(isbn);
    }

}
