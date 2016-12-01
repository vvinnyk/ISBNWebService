package com.vvinnyk.isbn;

import com.vvinnyk.isbn.model.Author;
import com.vvinnyk.isbn.model.Book;
import com.vvinnyk.isbn.model.ISBN;
import com.vvinnyk.isbn.model.Publisher;
import com.vvinnyk.isbn.model.Title;
import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class TestDataCreator {

    public static List<Book> createBooks(int numberOfBooksToCreate) {
        Set<Book> booksSet = new HashSet<>();

        for (int i = 1; i < numberOfBooksToCreate + 1; i++) {
            Book createdBook = createBook(i);
            booksSet.add(createdBook);
        }

        return Lists.newArrayList(booksSet);
    }

    private static Book createBook(int i) {
        Book book = new Book();

        ISBN isbn = new ISBN("isbn10" + i, "isbn13" + i);
        List<Author> authors = Lists.newArrayList(new Author("555", "Author" + i), new Author("777", "Author" + i));
        Publisher publisher = new Publisher("publisherId" + i, "publisherName" + i, "publishText" + i);
        Title title = new Title("title" + i, "titleLatin" + i, "titleLong" + i);

        book.setIsbn(isbn);
        book.setAuthors(authors);
        book.setAwards("awards" + i);
        book.setBookId("bookId" + i);
        book.setDeweyDecimal("deweyDecimal" + i);
        book.setDeweyNormal("deweyNormal" + i);
        book.setEditionInfo("editInfo" + i);
        book.setLanguage("language" + i);
        book.setLccNumber("lccNumber" + i);
        book.setLanguage("language" + i);
        book.setMarcEncLevel("marcEncLevel" + i);
        book.setNotes("notes" + i);
        book.setPhysicalDescriptionText("physicalDescriptionText" + i);
        book.setPublisher(publisher);
        book.setSummary("summary" + i);
        book.setTitle(title);
        book.setUrlsText("urlsText" + i);
        book.setSubjectIds(Lists.newArrayList("FirstSubjectIds" + i, "SecondSubjectIds" + i));
        return book;
    }
}

