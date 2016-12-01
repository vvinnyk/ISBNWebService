package com.vvinnyk.isbn.model;

/**
 * @author Vladyslav_Vinnyk on 30.11.2016.
 */
public class Title {
    private String title;

    private String titleLatin;

    private String titleLong;

    public Title(String title, String titleLatin, String titleLong) {
        this.title = title;
        this.titleLatin = titleLatin;
        this.titleLong = titleLong;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleLatin() {
        return titleLatin;
    }

    public void setTitleLatin(String titleLatin) {
        this.titleLatin = titleLatin;
    }

    public String getTitleLong() {
        return titleLong;
    }

    public void setTitleLong(String titleLong) {
        this.titleLong = titleLong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Title title1 = (Title) o;

        if (title != null ? !title.equals(title1.title) : title1.title != null) return false;
        if (titleLatin != null ? !titleLatin.equals(title1.titleLatin) : title1.titleLatin != null) return false;
        if (titleLong != null ? !titleLong.equals(title1.titleLong) : title1.titleLong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (titleLatin != null ? titleLatin.hashCode() : 0);
        result = 31 * result + (titleLong != null ? titleLong.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", titleLatin='" + titleLatin + '\'' +
                ", titleLong='" + titleLong + '\'' +
                '}';
    }
}
