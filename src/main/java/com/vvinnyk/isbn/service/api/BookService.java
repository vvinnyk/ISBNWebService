package com.vvinnyk.isbn.service.api;

import com.vvinnyk.isbn.model.Book;

/**
 * @author Vladyslav_Vinnyk on 30.11.2016.
 */
public interface BookService {
    Book search(String isbn);
}
