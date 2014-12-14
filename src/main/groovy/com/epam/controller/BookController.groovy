package com.epam.controller

import com.epam.repository.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import com.epam.domain.Author

/**
 * Created by Talvi on 29.11.2014.
 */
@RestController
class BookController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping('/item')
    String getItem() {
        'item';
    }

    @RequestMapping(value = '/author', method = RequestMethod.GET)
    String getAuthor() {
        authorRepository.findAll();
    }

    @RequestMapping(value = '/author/add', method = RequestMethod.GET)
    String addAuthor() {
        Author author = new Author();
        author.setName('lol');
        authorRepository.save(author)
    }

}
