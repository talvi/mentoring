package com.epam.domain

import groovy.transform.Canonical
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id;

/**
 * Created by Talvi on 29.11.2014.
 */

@Entity
@Canonical
class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String name

}
