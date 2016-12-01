package com.vvinnyk.isbn.repository.api;

import com.vvinnyk.isbn.TestDataCreator;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.model.ISBN;
import com.vvinnyk.isbn.repository.impl.BookRepositoryImpl;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class BookRepositoryTest {
    private BookRepository bookRepository;

    private List<Book> books;

    @Before
    public void setUp() {
        this.books = TestDataCreator.createBooks(2);
        this.bookRepository = new BookRepositoryImpl();
    }

    @Test
    public void shouldSaveBookInRepositoryAndThanFindIt() {
        Book book = books.get(0);
        assertEquals(0, bookRepository.count());

        bookRepository.save(book);

        assertEquals(1, bookRepository.count());
        Assert.assertEquals(book, bookRepository.findOne(book.getIsbn()));
    }

    @Test
    public void shouldSaveBatchOfBooksThanFindThem() {
        Book firstBook = books.get(0);
        Book secondBook = books.get(1);
        assertEquals(0, bookRepository.count());

        bookRepository.save(books);

        assertEquals(2, bookRepository.count());
        Assert.assertEquals(firstBook, bookRepository.findOne(firstBook.getIsbn()));
        Assert.assertEquals(secondBook, bookRepository.findOne(secondBook.getIsbn()));
    }

    @Test
    public void shouldFindBookInRepository() {
        ISBN isbn = books.get(0).getIsbn();
        assertEquals(0, bookRepository.count());

        bookRepository.save(books);

        assertTrue(bookRepository.exists(isbn));
    }

    @Test
    public void shouldNotFindBookInRepository() {
        ISBN isbn = new ISBN("isbn10", "isbn13");
        assertEquals(0, bookRepository.count());

        bookRepository.save(books);

        assertFalse(bookRepository.exists(isbn));
    }

    @Test
    public void shouldFindAllBooksInRepository() {
        ArrayList<Book> booksSubArray = Lists.newArrayList(this.books);
        List<ISBN> subArray = booksSubArray.stream()
                .map(Book::getIsbn).collect(Collectors.toList());
        this.books = TestDataCreator.createBooks(4);

        bookRepository.save(this.books);

        ArrayList<Book> allFoundBooks = Lists.newArrayList(bookRepository.findAll(subArray));
        assertTrue(allFoundBooks.containsAll(booksSubArray) && booksSubArray.containsAll(allFoundBooks));
    }

    @Test
    public void shouldDeleteBookByISBNFromRepository() {
        Book bookToDelete = books.get(0);
        assertEquals(0, bookRepository.count());

        bookRepository.save(books);

        assertEquals(2, bookRepository.count());
        Assert.assertEquals(bookToDelete, bookRepository.findOne(bookToDelete.getIsbn()));
        assertTrue(bookRepository.findOne(bookToDelete.getIsbn()).equals(bookToDelete));

        bookRepository.delete(bookToDelete.getIsbn());

        assertEquals(1, bookRepository.count());
        assertFalse(bookRepository.exists(bookToDelete.getIsbn()));
        assertTrue(bookRepository.findOne(bookToDelete.getIsbn()) == null);
    }

    @Test
    public void shouldDeleteBookByEntityFromRepository() {
        Book bookToDelete = books.get(0);
        assertEquals(0, bookRepository.count());

        bookRepository.save(books);

        assertEquals(2, bookRepository.count());
        Assert.assertEquals(bookToDelete, bookRepository.findOne(bookToDelete.getIsbn()));
        assertTrue(bookRepository.findOne(bookToDelete.getIsbn()).equals(bookToDelete));

        bookRepository.delete(bookToDelete);

        assertEquals(1, bookRepository.count());
        assertFalse(bookRepository.exists(bookToDelete.getIsbn()));
        assertTrue(bookRepository.findOne(bookToDelete.getIsbn()) == null);
    }

    @Test
    public void shouldDeleteBatchOfBooksFromRepository() {
        ArrayList<Book> booksSubArray = Lists.newArrayList(this.books);
        List<ISBN> subArray = booksSubArray.stream()
                .map(Book::getIsbn).collect(Collectors.toList());
        this.books = TestDataCreator.createBooks(5);

        bookRepository.save(books);

        List<Book> allFinedBooks = Lists.newArrayList(bookRepository.findAll(subArray));
        assertEquals(5, bookRepository.count());
        assertTrue(allFinedBooks.containsAll(booksSubArray) && booksSubArray.containsAll(allFinedBooks));

        bookRepository.delete(booksSubArray);
        assertEquals(3, bookRepository.count());
        allFinedBooks = Lists.newArrayList(bookRepository.findAll(subArray));

        assertFalse(allFinedBooks.containsAll(booksSubArray) && booksSubArray.containsAll(allFinedBooks));
    }

    @Test
    public void shouldDeleteAllBooksFromRepository() {
        this.books = TestDataCreator.createBooks(5);
        assertEquals(0, bookRepository.count());

        bookRepository.save(books);

        assertEquals(5, bookRepository.count());

        bookRepository.deleteAll();
        assertEquals(0, bookRepository.count());
    }
}