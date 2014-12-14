package com.epam.repository

import com.epam.domain.Author
import org.springframework.data.repository.CrudRepository

/**
 * Created by Talvi on 29.11.2014.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
