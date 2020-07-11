package com.ynz.haldemo;

import com.ynz.haldemo.domain.Author;
import com.ynz.haldemo.domain.Book;
import com.ynz.haldemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@SpringBootApplication
@RequiredArgsConstructor
public class HalDemoApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(HalDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = Author.builder()
                .firstName("Eric")
                .lastName("Evans")
                .books(new HashSet<>())
                .build();

        Book book1 = Book.builder()
                .price(BigDecimal.valueOf(435.00))
                .title("Domain Driven Design")
                .authors(new HashSet<>())
                .build();

        //associate book and author in bi-direction.
        book1.addAuthor(author1);

        bookRepository.save(book1);


        Author author2 = Author.builder().firstName("Daoqi").lastName("Yang").books(new HashSet<>()).build();
        Book book2 = Book.builder().authors(new HashSet<>()).price(BigDecimal.valueOf(320.99))
                .title("Java TM Persistence with JPA").build();

        book2.addAuthor(author2);
        bookRepository.save(book2);

        Author author3 = Author.builder().firstName("K.Sam").lastName("Shanmugan").books(new HashSet<>()).build();
        Author author4 = Author.builder().firstName("A.M.").lastName("Breipohl").books(new HashSet<>()).build();

        Book book3 = Book.builder().authors(new HashSet<>())
                .price(BigDecimal.valueOf(545)).title("Random Signals").build();

        book3.addAuthor(author3);
        book3.addAuthor(author4);

        bookRepository.save(book3);

    }
}
