package com.vvinnyk.isbn.connectionmanager.api;

import com.vvinnyk.isbn.model.Book;
import org.w3c.dom.Document;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public interface WebServiceConnectionManager {
    /**
     * To get Book from the remote web service
     * by bookISBN. Retrieve XML then parse it.
     *
     * @param bookISBN - ISBN of book.
     * @return Book - Retrieved book.
     */
    Book requestBook(String bookISBN);

    /**
     * To get XML document from the remote web service.
     *
     * @param xmlWebServiceUrl - URL of XML
     * @return
     */
    Document requestXmlDocument(String xmlWebServiceUrl);
}
