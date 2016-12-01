package com.vvinnyk.isbn.connectionmanager.impl;

import com.vvinnyk.isbn.Properties;
import com.vvinnyk.isbn.exception.TechnicalException;
import com.vvinnyk.isbn.exception.XmlParserException;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.utils.parser.UrlCreator;
import com.vvinnyk.isbn.connectionmanager.api.WebServiceConnectionManager;
import com.vvinnyk.isbn.utils.parser.impl.XPathXmlParserImpl;
import com.vvinnyk.isbn.utils.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public class WebServiceConnectionManagerImpl implements WebServiceConnectionManager {
    private static final Logger LOG = LoggerFactory.getLogger(Properties.LOGGER_NAME);

    @Override
    public Book requestBook(String bookISBN) {
        String webServiceUrl = UrlCreator.createUrlForRetrievingBookByISBN(bookISBN);
        Document xmlDocument = requestXmlDocument(webServiceUrl);
        return new XPathXmlParserImpl().parseBook(xmlDocument);
    }

    @Override
    public Document requestXmlDocument(String xmlWebServiceUrl) {
        LOG.debug(Messages.START_SENDING_REQUEST, xmlWebServiceUrl);

        Document document = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlWebServiceUrl);
        } catch (ParserConfigurationException e) {
            LOG.error(Messages.UNABLE_CREATE_DOCUMENT_BUILDER, e);
            throw new TechnicalException(Messages.UNABLE_CREATE_DOCUMENT_BUILDER, e);
        } catch (SAXException e) {
            LOG.error(Messages.UNABLE_PARSE_XML_DOCUMENT, e);
            throw new XmlParserException(Messages.BOOK_CANT_BE_FOUND, Messages.UNABLE_PARSE_XML_DOCUMENT + e.getStackTrace(),
                    newArrayList(document.getDocumentURI()));
        } catch (IOException e) {
            LOG.error(Messages.UNABLE_REQUEST_BOOK, e);
            throw new TechnicalException(e);
        }

        LOG.debug(Messages.RESPONSE_WAS_SUCCESSFULLY_RECEIVED, document.getDocumentURI());
        return document;
    }
}
