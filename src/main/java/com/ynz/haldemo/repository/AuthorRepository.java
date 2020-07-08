package com.ynz.haldemo.repository;

import com.ynz.haldemo.domain.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface AuthorRepository extends PagingAndSortingRepository<Author, UUID> {
}
