package com.custom.market.domain

import groovy.transform.Canonical
import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
@Entity
@Canonical
@ToString
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String name
    String price
    String image
    String link
}
