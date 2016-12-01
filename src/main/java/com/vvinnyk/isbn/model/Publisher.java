package com.vvinnyk.isbn.model;

/**
 * @author Vladyslav_Vinnyk on 30.11.2016.
 */
public class Publisher {
    private String publisherId;

    private String publisherName;

    private String publishText;

    public Publisher(String publisherId, String publisherName, String publishText) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publishText = publishText;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublishText() {
        return publishText;
    }

    public void setPublishText(String publishText) {
        this.publishText = publishText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (publishText != null ? !publishText.equals(publisher.publishText) : publisher.publishText != null)
            return false;
        if (publisherId != null ? !publisherId.equals(publisher.publisherId) : publisher.publisherId != null)
            return false;
        if (publisherName != null ? !publisherName.equals(publisher.publisherName) : publisher.publisherName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = publisherId != null ? publisherId.hashCode() : 0;
        result = 31 * result + (publisherName != null ? publisherName.hashCode() : 0);
        result = 31 * result + (publishText != null ? publishText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId='" + publisherId + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publishText='" + publishText + '\'' +
                '}';
    }
}
