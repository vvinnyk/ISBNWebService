package com.vvinnyk.isbn.utils.parser.impl;

import com.vvinnyk.isbn.Properties;
import com.vvinnyk.isbn.exception.XmlParserException;
import com.vvinnyk.isbn.model.Author;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.model.ISBN;
import com.vvinnyk.isbn.model.Publisher;
import com.vvinnyk.isbn.model.Title;
import com.vvinnyk.isbn.utils.parser.api.XPathXmlParser;
import com.google.common.collect.Lists;
import com.vvinnyk.isbn.utils.Messages;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.AUTHOR_DATA;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.AUTHOR_DATA_ID;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.AUTHOR_DATA_NAME;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.AWARDS_TEXT;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.BOOK_ID;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.DATA;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.DEWEY_DECIMAL;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.DEWEY_NORMAL;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.EDITION_INFO;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.ISBN_10;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.ISBN_13;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.LANGUAGE;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.LCC_NUMBER;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.MARC_ENC_LEVEL;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.NOTES;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.PHYSICAL_DESCRIPTION_TEXT;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.PUBLISHER_ID;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.PUBLISHER_NAME;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.PUBLISHER_TEXT;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.ROOT;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.SUBJECT_IDS;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.SUMMARY;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.TITLE;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.TITLE_LATIN;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.TITLE_LONG;
import static com.vvinnyk.isbn.utils.parser.ConstantsContainer.Book.URLS_TEXT;

/**
 * @author Vladyslav_Vinnyk on 30.11.2016.
 */
public class XPathXmlParserImpl implements XPathXmlParser {
    private static final Logger LOG = LoggerFactory.getLogger(Properties.LOGGER_NAME);

    @Override
    public Book parseBook(Document xmlDocument) {
        Book book = new Book();

        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList dataNodeList = (NodeList) xPath.compile(ROOT).evaluate(xmlDocument, XPathConstants.NODESET);

            if (dataNodeList != null && dataNodeList.getLength() > 0) {
                Node node = dataNodeList.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE
                        && DATA.equals(((Element) node).getTagName())) {
                    Element dataElement = (Element) node;

                    NodeList authorDates = dataElement.getElementsByTagName(AUTHOR_DATA);
                    NodeList subjectIdsNodes = dataElement.getElementsByTagName(SUBJECT_IDS);

                    List<Author> authors = new ArrayList<>();
                    for (int i = 0; i < authorDates.getLength(); i++) {
                        Node authorDate = authorDates.item(i);
                        if (authorDate.getNodeType() == Node.ELEMENT_NODE) {
                            Element authorDateElement = (Element) authorDate;
                            String id = authorDateElement.getElementsByTagName(AUTHOR_DATA_ID).item(0).getTextContent();
                            String name = authorDateElement.getElementsByTagName(AUTHOR_DATA_NAME).item(0).getTextContent();
                            authors.add(new Author(id, name));
                        }
                    }

                    List<String> subjectIds = new ArrayList<>();
                    for (int i = 0; i < subjectIdsNodes.getLength(); i++) {
                        Node subjectId = subjectIdsNodes.item(i);
                        if (subjectId.getNodeType() == Node.ELEMENT_NODE) {
                            subjectIds.add(getTextContentOfElementNode(subjectId));
                        }
                    }

                    book.setAuthors(authors);
                    book.setAwards(retrieveText(dataElement, AWARDS_TEXT));
                    book.setBookId(retrieveText(dataElement, BOOK_ID));
                    book.setDeweyDecimal(retrieveText(dataElement, DEWEY_DECIMAL));
                    book.setDeweyNormal(retrieveText(dataElement, DEWEY_NORMAL));
                    book.setEditionInfo(retrieveText(dataElement, EDITION_INFO));
                    book.setIsbn(new ISBN(retrieveText(dataElement, ISBN_10), retrieveText(dataElement, ISBN_13)));
                    book.setLanguage(retrieveText(dataElement, LANGUAGE));
                    book.setLccNumber(retrieveText(dataElement, LCC_NUMBER));
                    book.setMarcEncLevel(retrieveText(dataElement, MARC_ENC_LEVEL));
                    book.setNotes(retrieveText(dataElement, NOTES));
                    book.setPhysicalDescriptionText(retrieveText(dataElement, PHYSICAL_DESCRIPTION_TEXT));
                    book.setPublisher(new Publisher(retrieveText(dataElement, PUBLISHER_ID), retrieveText(dataElement, PUBLISHER_NAME),
                            retrieveText(dataElement, PUBLISHER_TEXT)));
                    book.setSubjectIds(subjectIds);
                    book.setSummary(retrieveText(dataElement, SUMMARY));
                    book.setTitle(new Title(retrieveText(dataElement, TITLE), retrieveText(dataElement, TITLE_LATIN),
                            retrieveText(dataElement, TITLE_LONG)));
                    book.setUrlsText(retrieveText(dataElement, URLS_TEXT));
                }
            }
        } catch (XPathExpressionException e) {
            LOG.error(Messages.UNABLE_CREATE_XPATH + e);
            throw new XmlParserException(Messages.BOOK_CANT_BE_FOUND, Messages.UNABLE_CREATE_XPATH, Lists.newArrayList(xmlDocument.getDocumentURI()));
        }
        return book;
    }

    private String retrieveText(Element dataElement, String tagName) {
        Node node = dataElement.getElementsByTagName(tagName).item(0);
        return getTextContentOfElementNode(node);
    }

    private String getTextContentOfElementNode(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            return element.getTextContent();
        }
        return StringUtils.EMPTY;
    }
}