package com.ynz.haldemo.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
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

    private String title;
    private BigDecimal price;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "books", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Author> authors;

}
