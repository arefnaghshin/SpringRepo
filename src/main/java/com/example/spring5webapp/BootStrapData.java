package com.example.spring5webapp;

import com.example.spring5webapp.domain.Author;
import com.example.spring5webapp.domain.Book;
import com.example.spring5webapp.domain.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
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

        Publisher publisher = new Publisher();
        publisher.setName("Ali Sadeghi");
        publisher.setState("LA");
        publisher.setZip("4552");
        publisher.setAddressLine1("Tehran");

        book.setPublisher(publisher);

        book1.setPublisher(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}
