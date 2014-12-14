package com.epam.domain

import groovy.transform.Canonical

import javax.persistence.*

/**
 * Created by Talvi on 29.11.2014.
 */

@Entity
@Canonical
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String name
    int pages
    @OneToMany
    @JoinTable(
            name = 'BOOK_AUTHORS',
            joinColumns = @JoinColumn(name = 'AUTHOR_ID'),
            inverseJoinColumns = @JoinColumn(name = 'BOOK_ID')
    )
    List<Author> authors

}
