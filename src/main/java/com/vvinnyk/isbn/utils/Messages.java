package com.vvinnyk.isbn.utils;

/**
 * Messages for Exceptions.
 *
 * @authors Vladyslav_Vinnyk on 12/1/2016.
 */
public final class Messages {

    private Messages() {
        new IllegalArgumentException("Not designed for instantiation");
    }

    //ServerMeassages
    public final static String SERVER_IS_GOING_TO_START = "Server is going to Starting...";
    public final static String SERVER_IS_STARTED_AT_PORT = "Server is started at port {}";

    //Book meassages
    public final static String UNABLE_CREATE_XPATH = "Unable to create XPath of the Xml document.";
    public final static String BOOK_CANT_BE_FOUND = "Book can't be found";

    public final static String UNABLE_CONVERT_TO_JSON = "Unable to convert book to JSON";
    public final static String START_SENDING_REQUEST = "Start sending request to External Web Service. URl : {} ";
    public final static String RESPONSE_WAS_SUCCESSFULLY_RECEIVED = "Xml Document was Successfully received. {} ";
    public final static String UNABLE_CREATE_DOCUMENT_BUILDER = "Unable to Create Xml documentBuilder {}";
    public final static String UNABLE_PARSE_XML_DOCUMENT = "Unable to Parse Xml document. {}";
    public final static String UNABLE_REQUEST_BOOK = "Unable to request the Book {}";
    public final static String ADVICE_TO_USER = "Server is Accessible on http://localhost:{}/some?book=ISBN" +
            "\n Replace ISBN with real isbn of eny book";
    public final static String SAVING_BOOK = "Saving Retrieved Book in Repository. ISBN is {}";

}
