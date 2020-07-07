package com.ynz.haldemo.repository;

import com.ynz.haldemo.domain.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {
}
