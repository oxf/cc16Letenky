package books;

import books.entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@EnableAutoConfiguration
public class BooksController {

    private final BookRepository bookRepository;

    public BooksController() {
        this.bookRepository = new BookRepository();
    }

    @ResponseBody
    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Book> getAll() {
        return bookRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findByIsbn(@PathVariable String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @ResponseBody
    @RequestMapping(value = "/books/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book add(@RequestBody Book book) {
        return bookRepository.add(book);
    }

    @ResponseBody
    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book update(@PathVariable String isbn, @RequestBody Book book) {
        return bookRepository.update(isbn, book);
    }


    @ResponseBody
    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book remove(@PathVariable String isbn) {
        return bookRepository.remove(isbn);
    }


    public static void main(String[] args) {
        SpringApplication.run(BooksController.class, args);
    }
}
