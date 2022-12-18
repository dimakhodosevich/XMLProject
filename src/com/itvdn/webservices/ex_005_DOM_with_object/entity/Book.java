package com.itvdn.webservices.ex_005_DOM_with_object.entity;

public class Book {
    private String id;
    private long isdn;
    private String title;
    private String author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getIsdn() {
        return isdn;
    }

    public void setIsdn(long isdn) {
        this.isdn = isdn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", isdn=" + isdn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
