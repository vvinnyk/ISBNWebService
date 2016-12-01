package com.vvinnyk.isbn.connectionmanager.api;

import com.vvinnyk.isbn.model.Book;
import org.w3c.dom.Document;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public interface WebServiceConnectionManager {
    Book requestBook(String bookISBN);

    Document requestXmlDocument(String webServiceUrl);
}
