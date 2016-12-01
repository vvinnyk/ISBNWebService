package com.vvinnyk.isbn.repository.api;

import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.model.ISBN;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public interface BookRepository extends CrudRepository<Book, ISBN> {
    /**
     * Search Book by isbn10 or isbn13
     * You can specify one of them.
     *
     * @param isbn - Represent isbn10 or isbn13.
     * @return
     */
    Book findOne(String isbn);
}
