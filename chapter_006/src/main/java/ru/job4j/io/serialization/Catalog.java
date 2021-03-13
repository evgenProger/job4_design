package ru.job4j.io.serialization;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {

     private Book[] book;

     public Catalog() { }

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

    @XmlElement(value = "book")
    private static class Book {
        @XmlAttribute
        private boolean availability;
        @XmlAttribute
        private String author;
        @XmlAttribute
        private int isbn;

        public Book() { }

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

    public static void main(String[] args) throws JAXBException, IOException {
        Book book = new Book(true, "Stephen King", 125);
        Book book1 = new Book(false, "Arthur C. Clarke", 356);
        final Catalog catalog = new Catalog(new Book[] {book, book1});
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        // создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // указываем что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(catalog, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
            // Для сериализации нам нужно создать десериализатор
            Unmarshaller unmarshaller = context.createUnmarshaller();
            try (StringReader reader = new StringReader(xml)) {
                // десериализуем
                Catalog result = (Catalog) unmarshaller.unmarshal(reader);
                System.out.println(result);
            }
        }
    }
}
