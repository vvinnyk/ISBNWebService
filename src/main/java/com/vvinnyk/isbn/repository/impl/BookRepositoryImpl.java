package com.vvinnyk.isbn.repository.impl;

import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.model.ISBN;
import com.vvinnyk.isbn.repository.api.BookRepository;
import org.apache.commons.collections.IteratorUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public class BookRepositoryImpl implements BookRepository {
    private HashMap<ISBN, Book> booksStorage = new HashMap<>();

    @Override
    public Book save(Book book) {
        ISBN isbn = book.getIsbn();
        this.booksStorage.put(isbn, book);
        return this.booksStorage.get(isbn);
    }

    @Override
    public Iterable<Book> save(Iterable<Book> booksToSave) {
        List<Book> bookList = IteratorUtils.toList(booksToSave.iterator());
        Map<ISBN, Book> isbnToBookMap = bookList.stream()
                .collect(Collectors.toMap(Book::getIsbn, Function.identity()));
        Set<ISBN> savedBooksIsbns = isbnToBookMap.keySet();

        this.booksStorage.putAll(isbnToBookMap);

        return this.booksStorage.values().stream()
                .filter(book -> savedBooksIsbns.contains(book.getIsbn()))
                .collect(Collectors.toList());
    }

    @Override
    public Book findOne(ISBN isbn) {
        return this.booksStorage.get(isbn);
    }

    public Book findOne(String isbnString) {
        for (Book book : this.booksStorage.values()) {
            ISBN isbn = book.getIsbn();
            if (isbn != null && isbn.isISBNExists(isbnString)) {
                return this.booksStorage.get(isbn);
            }
        }
        return null;
    }

    @Override
    public boolean exists(ISBN isbn) {
        return booksStorage.containsKey(isbn);
    }

    @Override
    public Iterable<Book> findAll() {
        return this.booksStorage.values();
    }

    @Override
    public Iterable<Book> findAll(Iterable<ISBN> isbns) {
        List<Book> bookList = IteratorUtils.toList(isbns.iterator());

        return this.booksStorage.values().stream()
                .filter(book -> bookList.contains(book.getIsbn()))
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return this.booksStorage.size();
    }

    @Override
    public void delete(ISBN isbn) {
        this.booksStorage.remove(isbn);
    }

    @Override
    public void delete(Book entity) {
        this.delete(entity.getIsbn());
    }

    @Override
    public void delete(Iterable<? extends Book> books) {
        Iterator<? extends Book> booksIterator = books.iterator();
        while (booksIterator.hasNext()) {
            Book book = booksIterator.next();
            if (book != null) {
                this.delete(book);
            }
        }
    }

    @Override
    public void deleteAll() {
        this.booksStorage.clear();
    }

}
