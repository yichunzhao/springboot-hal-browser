package com.ynz.haldemo.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@Data
public class Book {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String title;
    private BigDecimal price;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "books", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();

    public void addAuthor(Author author) {
        if (author == null) throw new IllegalArgumentException("Argument should not be a null");

        //forming bi-directional association from the Book by one kick.
        author.addBook(this);
        authors.add(author);
    }

}
