package com.vvinnyk.isbn.utils.parser;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public final class ConstantsContainer {

    private ConstantsContainer() {
        new IllegalArgumentException("Not designed for instantiation");
    }

    public static final class Book {
        public static final String ENTITY_NAME = "book";

        public static final String ROOT = "/isbndb/data";
        public static final String AUTHOR_DATA = "author_data";
        public static final String AUTHOR_DATA_ID = "id";
        public static final String AUTHOR_DATA_NAME = "name";
        public static final String AWARDS_TEXT = "awards_text";
        public static final String BOOK_ID = "book_id";
        public static final String DEWEY_DECIMAL = "dewey_decimal";
        public static final String DEWEY_NORMAL = "dewey_normal";
        public static final String EDITION_INFO = "edition_info";
        public static final String ISBN_10 = "isbn10";
        public static final String ISBN_13 = "isbn13";
        public static final String LANGUAGE = "language";
        public static final String LCC_NUMBER = "lcc_number";
        public static final String MARC_ENC_LEVEL = "marc_enc_level";
        public static final String NOTES = "notes";
        public static final String PHYSICAL_DESCRIPTION_TEXT = "physical_description_text";
        public static final String PUBLISHER_ID = "publisher_id";
        public static final String PUBLISHER_NAME = "publisher_name";
        public static final String PUBLISHER_TEXT = "publisher_text";
        public static final String SUBJECT_IDS = "subject_ids";
        public static final String SUMMARY = "summary";
        public static final String TITLE = "title";
        public static final String TITLE_LATIN = "title_latin";
        public static final String TITLE_LONG = "title_long";
        public static final String DATA = "data";
        public static final String URLS_TEXT = "urls_text";
    }
}
