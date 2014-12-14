package com.epam.repository

import com.epam.domain.Book
import org.springframework.data.repository.CrudRepository

/**
 * Created by Talvi on 29.11.2014.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}