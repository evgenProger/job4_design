package ru.job4j.io.serialization;

public class Catalog {
     private Book[] book;

    public Catalog(Book[] book) {
        this.setBook(book);
    }


    @Override
    public String toString() {
        return "Catalog{" +
                "book=" + getBook() +
                '}';
    }

    public Book[] getBook() {
        return book;
    }

    public void setBook(Book[] book) {
        this.book = book;
    }

    private static class Book {
        private boolean availability;
        private String author;
        private int isbn;


        public Book(boolean availability, String author, int isbn) {
            this.setAvailability(availability);
            this.setAuthor(author);
            this.setIsbn(isbn);

        }

        @Override
        public String toString() {
            return "Book{" +
                    "availability=" + isAvailability() +
                    ", author='" + getAuthor() + '\'' +
                    ", isbn=" + getIsbn() +
                    '}';
        }

        public boolean isAvailability() {
            return availability;
        }

        public void setAvailability(boolean availability) {
            this.availability = availability;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getIsbn() {
            return isbn;
        }

        public void setIsbn(int isbn) {
            this.isbn = isbn;
        }
    }

    public static void main(String[] args) {
        Book book = new Book(true, "Stephen King", 125);
        Book book1 = new Book(false, "Arthur C. Clarke", 356);
        Catalog catalog = new Catalog(new Book[] {book, book1});
    }
}
