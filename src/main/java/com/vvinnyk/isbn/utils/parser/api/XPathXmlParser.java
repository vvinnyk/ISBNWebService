package com.vvinnyk.isbn.utils.parser.api;

import com.vvinnyk.isbn.model.Book;
import org.w3c.dom.Document;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public interface XPathXmlParser {
    Book parseBook(Document xmlDocument);
}
