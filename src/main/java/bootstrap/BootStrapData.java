package bootstrap;

import domain.Author;
import domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repositories.AuthorRepository;
import repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evis");
        Book book = new Book("Domain Driven Design", "244121");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book book1 = new Book("J2EE Development", "rw224242");
        rod.getBooks().add(book1);
        book1.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}
