package com.custom.market.domain

import com.custom.market.enums.QualityType
import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
@Entity
@Canonical
class Quality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    @Enumerated(EnumType.STRING)
    QualityType qualityType
    @OneToMany
    @JoinTable(
            name = 'QUALITY_ITEMS',
            joinColumns = @JoinColumn(name = 'ITEM_ID'),
            inverseJoinColumns = @JoinColumn(name = 'QUALITY_ID')
    )
    List<Item> items

}
