package com.vvinnyk.isbn.utils.parser.api;

import com.vvinnyk.isbn.TestDataCreator;
import com.vvinnyk.isbn.connectionmanager.api.WebServiceConnectionManager;
import com.vvinnyk.isbn.connectionmanager.impl.WebServiceConnectionManagerImpl;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.utils.parser.impl.XPathXmlParserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class XPathXmlParserTest {
    private XPathXmlParser xPathXmlParser;

    private WebServiceConnectionManager webServiceConnectionManager;

    @Before
    public void setUp() {
        this.xPathXmlParser = new XPathXmlParserImpl();
        this.webServiceConnectionManager = new WebServiceConnectionManagerImpl();
    }

    @Test
    public void should() {
        Book expected = TestDataCreator.createBooks(1).stream().findFirst().get();
        Document document = webServiceConnectionManager.requestXmlDocument("src/test/resources/testBook.xml");
        Book actual = xPathXmlParser.parseBook(document);

        Assert.assertEquals(expected, actual);
    }
    
}