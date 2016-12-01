package com.vvinnyk.isbn.service.api;

import com.vvinnyk.isbn.model.Book;

/**
 * Service to deal with a Book entity.
 *
 * @author Vladyslav_Vinnyk on 30.11.2016.
 */
public interface BookService {
    /**
     * Search book in the remote WebService.
     * If Book will be founded it will save it
     * in repository.
     * <p>
     * First of all search in Repository
     * if not found will request
     * remote Web Service.
     *
     * @param isbn
     * @return
     */
    Book search(String isbn);
}
