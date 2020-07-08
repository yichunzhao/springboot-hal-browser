package com.ynz.haldemo.repository;

import com.ynz.haldemo.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface BookRepository extends PagingAndSortingRepository<Book, UUID> {
}
