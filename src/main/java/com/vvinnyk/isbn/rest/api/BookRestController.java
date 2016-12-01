package com.vvinnyk.isbn.rest.api;

/**
 * Rest to deal with Book.
 *
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public interface BookRestController {
    /**
     * By specified isbn of book
     * return data about a book in
     * JSON format.
     *
     * @param isbn - ISBN of book.
     * @return String - JSON that represent the book.
     */
    String getBookAsJSON(String isbn);
}
