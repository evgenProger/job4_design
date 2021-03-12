package ru.job4j.io.serialization;

import java.util.Arrays;

public class Catalog {
    Book[] book;

    public Catalog(Book[] book) {
        this.book = book;
    }


    @Override
    public String toString() {
        return "Catalog{" +
                "book=" + book +
                '}';
    }

    private static class Book {
        boolean availability;
        String author;
        int isbn;


        public Book(boolean availability, String author, int isbn) {
            this.availability = availability;
            this.author = author;
            this.isbn = isbn;

        }

        @Override
        public String toString() {
            return "Book{" +
                    "availability=" + availability +
                    ", author='" + author + '\'' +
                    ", isbn=" + isbn +
                    '}';
        }
    }

    public static void main(String[] args) {
        Book book = new Book(true, "Stephen King", 125);
        Book book1 = new Book(false, "Arthur C. Clarke", 356);
        Catalog catalog = new Catalog(new Book[] {book, book1});
    }
}
