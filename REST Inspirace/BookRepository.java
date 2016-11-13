package books;

import books.entity.Author;
import books.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<Book>();
        initializeSampleData();
    }

    private void initializeSampleData() {
        books.add(new Book("Kmotr", "80-242-1102-5", 1969, new Author("Mario", "Puzo")));
        books.add(new Book("Omerta", "80-242-1642-6", 2000, new Author("Mario", "Puzo")));
        books.add(new Book("Inferno", "978-80-257-0934-4", 2013, new Author("Dan", "Brown")));
        books.add(new Book("Stoletý stařík, který vylezl z okna a zmizel", "978-80-87697-00-9", 2009, new Author("Jonas", "Jonasson")));
        books.add(new Book("Digitální pevnost", "80-86518-95-7", 1998, new Author("Dan", "Brown")));
        books.add(new Book("Modrá sféra", "80-7303-047-0", 2001, new Author("Jeffery", "Deaver")));
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst().orElse(null);
    }

    public Book add(Book book) {
        boolean exist = findByIsbn(book.getIsbn()) != null;
        if (exist)
            throw new RuntimeException("Books exist - ISBN: " + book.getIsbn());

        books.add(book);
        return book;
    }

    public Book remove(String isbn) {
        Book book = findByIsbn(isbn);
        if (book != null) {
            books.remove(book);
            return book;
        }

        throw new RuntimeException("Books doesn't exist - ISBN: " + book.getIsbn());
    }

    public Book update(String isbn, Book changes) {
        Book currentBook = findByIsbn(isbn);
        if (currentBook == null) {
            throw new RuntimeException("Books doesn't exist - ISBN: " + isbn);
        }

        if (!isbn.equals(changes.getIsbn()) && findByIsbn(changes.getIsbn()) != null) {
            throw new RuntimeException("Duplicate book - ISBN: " + isbn);
        }

        currentBook.setIsbn(changes.getIsbn());
        currentBook.setName(changes.getName());
        currentBook.setPublishYear(changes.getPublishYear());
        currentBook.setAuthor(changes.getAuthor());
        return currentBook;
    }
}
