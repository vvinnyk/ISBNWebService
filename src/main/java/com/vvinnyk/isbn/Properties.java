package com.vvinnyk.isbn;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public final class Properties {

    private Properties() {
        new IllegalArgumentException("Not designed for instantiation");
    }

    public static final int DEFAULT_HTTP_SERVER_PORT = 8765;

    public static final String LOGGER_NAME = "ISBNWebService";

    public static final String URL_WEB_SERVICE = "http://isbndb.com/api/v2/xml";
    public static final String API_KEY = "YYUDYYMP";
}
