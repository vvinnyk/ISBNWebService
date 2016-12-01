package com.vvinnyk.isbn.utils.parser;

import com.vvinnyk.isbn.Properties;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public class UrlCreator {

    private static final String SEPARATOR = "/";

    public static String createUrlForRetrievingBookByISBN(String bookISBN) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Properties.URL_WEB_SERVICE + SEPARATOR);
        stringBuilder.append(Properties.API_KEY + SEPARATOR);
        stringBuilder.append(ConstantsContainer.Book.ENTITY_NAME + SEPARATOR);
        stringBuilder.append(bookISBN);

        return stringBuilder.toString();
    }

}
