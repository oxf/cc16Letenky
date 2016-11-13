package books.entity;

public class Book {

    private String name;
    private String isbn;
    private int publishYear;
    private Author author;

    public Book() {
    }

    public Book(String name, String isbn, int publishYear, Author author) {
        this.name = name;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishYear=" + publishYear +
                ", author=" + author +
                '}';
    }
}
