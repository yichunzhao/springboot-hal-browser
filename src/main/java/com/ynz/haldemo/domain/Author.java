package com.ynz.haldemo.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@Data
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "Author_Book",
            joinColumns = @JoinColumn(name = "Author_Id"),
            inverseJoinColumns = @JoinColumn(name = "Book_Id")
    )
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book should not be a null value");
        books.add(book);
    }


}
