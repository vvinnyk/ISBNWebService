package com.vvinnyk.isbn.connectionmanager.impl;

import com.vvinnyk.isbn.Properties;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.repository.api.BookRepository;
import com.vvinnyk.isbn.connectionmanager.api.WebServiceConnectionManager;
import com.vvinnyk.isbn.connectionmanager.api.WebServiceConnectionManagerWrapper;
import com.vvinnyk.isbn.utils.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import java.util.Optional;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public class WebServiceConnectionManagerWrapperImpl implements WebServiceConnectionManagerWrapper {
    private static final Logger LOG = LoggerFactory.getLogger(Properties.LOGGER_NAME);

    private WebServiceConnectionManager webServiceConnectionManager;

    private BookRepository bookRepository;

    public WebServiceConnectionManagerWrapperImpl(WebServiceConnectionManager webServiceConnectionManager,
                                                  BookRepository bookRepository) {
        this.webServiceConnectionManager = webServiceConnectionManager;
        this.bookRepository = bookRepository;
    }

    @Override
    public Book requestBook(String bookISBN) {
        Book bookFromRepository = bookRepository.findOne(bookISBN);
        return Optional.ofNullable(bookFromRepository)
                .orElseGet(() -> requestBookAndIfNotNullSaveInRepository(bookISBN));
    }

    @Override
    public Document requestXmlDocument(String xmlWebServiceUrl) {
        return this.webServiceConnectionManager.requestXmlDocument(xmlWebServiceUrl);
    }

    private Book requestBookAndIfNotNullSaveInRepository(String bookISBN) {
        Book bookFromWebService = webServiceConnectionManager.requestBook(bookISBN);

        if (bookFromWebService != null && bookFromWebService.getIsbn() != null
                && bookFromWebService.getIsbn().isNotNull()) {
            LOG.debug(Messages.SAVING_BOOK, bookFromWebService.getIsbn());
            bookFromWebService = bookRepository.save(bookFromWebService);
        }

        return bookFromWebService;
    }

}
