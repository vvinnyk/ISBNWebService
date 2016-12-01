package com.vvinnyk.isbn.model;

import java.io.Serializable;

/**
 * @author Vladyslav_Vinnyk on 30.11.2016.
 */
public class ISBN implements Serializable {

    private static final long serialVersionUID = 543776412L;

    private String isbn10;

    private String isbn13;

    public ISBN(String isbn10, String isbn13) {
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public boolean isNotNull() {
        if (isbn10 == null && isbn13 == null) {
            return false;
        }
        return true;
    }

    public boolean isISBNExists(String isbn) {
        if (isbn10.equals(isbn) ||
                isbn13.equals(isbn)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ISBN isbn = (ISBN) o;

        if (isbn10 != null ? !isbn10.equals(isbn.isbn10) : isbn.isbn10 != null) return false;
        if (isbn13 != null ? !isbn13.equals(isbn.isbn13) : isbn.isbn13 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = isbn10 != null ? isbn10.hashCode() : 0;
        result = 31 * result + (isbn13 != null ? isbn13.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ISBN{" +
                "isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                '}';
    }
}
