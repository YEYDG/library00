package com.example.library00.book.domain;

public class BookRequest {
    private long bookId;
    private String name;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                '}';
    }
}
