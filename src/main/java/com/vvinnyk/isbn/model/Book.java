package com.vvinnyk.isbn.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 30.11.2016.
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 672214905L;

    private ISBN isbn;

    private Title title;

    private List<Author> authors;

    private Publisher publisher;

    private String awards;

    private String bookId;

    private String editionInfo;

    private String language;

    private String deweyDecimal;

    private String deweyNormal;

    private String lccNumber;

    private String marcEncLevel;

    private String notes;

    private String physicalDescriptionText;

    private List<String> subjectIds;

    private String summary;

    private String urlsText;

    public ISBN getIsbn() {
        return isbn;
    }

    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getEditionInfo() {
        return editionInfo;
    }

    public void setEditionInfo(String editionInfo) {
        this.editionInfo = editionInfo;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDeweyDecimal() {
        return deweyDecimal;
    }

    public void setDeweyDecimal(String deweyDecimal) {
        this.deweyDecimal = deweyDecimal;
    }

    public String getDeweyNormal() {
        return deweyNormal;
    }

    public void setDeweyNormal(String deweyNormal) {
        this.deweyNormal = deweyNormal;
    }

    public String getLccNumber() {
        return lccNumber;
    }

    public void setLccNumber(String lccNumber) {
        this.lccNumber = lccNumber;
    }

    public String getMarcEncLevel() {
        return marcEncLevel;
    }

    public void setMarcEncLevel(String marcEncLevel) {
        this.marcEncLevel = marcEncLevel;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhysicalDescriptionText() {
        return physicalDescriptionText;
    }

    public void setPhysicalDescriptionText(String physicalDescriptionText) {
        this.physicalDescriptionText = physicalDescriptionText;
    }

    public List<String> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<String> subjectIds) {
        this.subjectIds = subjectIds;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrlsText() {
        return urlsText;
    }

    public void setUrlsText(String urlsText) {
        this.urlsText = urlsText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (authors != null ? !authors.equals(book.authors) : book.authors != null) return false;
        if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;
        if (awards != null ? !awards.equals(book.awards) : book.awards != null) return false;
        if (bookId != null ? !bookId.equals(book.bookId) : book.bookId != null) return false;
        if (editionInfo != null ? !editionInfo.equals(book.editionInfo) : book.editionInfo != null) return false;
        if (language != null ? !language.equals(book.language) : book.language != null) return false;
        if (deweyDecimal != null ? !deweyDecimal.equals(book.deweyDecimal) : book.deweyDecimal != null) return false;
        if (deweyNormal != null ? !deweyNormal.equals(book.deweyNormal) : book.deweyNormal != null) return false;
        if (lccNumber != null ? !lccNumber.equals(book.lccNumber) : book.lccNumber != null) return false;
        if (marcEncLevel != null ? !marcEncLevel.equals(book.marcEncLevel) : book.marcEncLevel != null) return false;
        if (notes != null ? !notes.equals(book.notes) : book.notes != null) return false;
        if (physicalDescriptionText != null ? !physicalDescriptionText.equals(book.physicalDescriptionText) : book.physicalDescriptionText != null)
            return false;
        if (subjectIds != null ? !subjectIds.equals(book.subjectIds) : book.subjectIds != null) return false;
        if (summary != null ? !summary.equals(book.summary) : book.summary != null) return false;
        return urlsText != null ? urlsText.equals(book.urlsText) : book.urlsText == null;

    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (awards != null ? awards.hashCode() : 0);
        result = 31 * result + (bookId != null ? bookId.hashCode() : 0);
        result = 31 * result + (editionInfo != null ? editionInfo.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (deweyDecimal != null ? deweyDecimal.hashCode() : 0);
        result = 31 * result + (deweyNormal != null ? deweyNormal.hashCode() : 0);
        result = 31 * result + (lccNumber != null ? lccNumber.hashCode() : 0);
        result = 31 * result + (marcEncLevel != null ? marcEncLevel.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (physicalDescriptionText != null ? physicalDescriptionText.hashCode() : 0);
        result = 31 * result + (subjectIds != null ? subjectIds.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (urlsText != null ? urlsText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title=" + title +
                ", authors=" + authors +
                ", publisher=" + publisher +
                ", awards='" + awards + '\'' +
                ", bookId='" + bookId + '\'' +
                ", editionInfo='" + editionInfo + '\'' +
                ", language='" + language + '\'' +
                ", deweyDecimal='" + deweyDecimal + '\'' +
                ", deweyNormal='" + deweyNormal + '\'' +
                ", lccNumber='" + lccNumber + '\'' +
                ", marcEncLevel='" + marcEncLevel + '\'' +

                ", notes='" + notes + '\'' +
                ", physicalDescriptionText='" + physicalDescriptionText + '\'' +
                ", subjectIds=" + subjectIds +
                ", summary='" + summary + '\'' +
                ", urlsText='" + urlsText + '\'' +
                '}';
    }

}
