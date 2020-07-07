package com.ynz.haldemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "Author_Book",
            joinColumns = @JoinColumn(name = "Author_Id"),
            inverseJoinColumns = @JoinColumn(name = "Book_Id")
    )
    private Set<Book> books;
}
