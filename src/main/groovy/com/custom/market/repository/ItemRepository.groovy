package com.custom.market.repository

import com.custom.market.domain.Item
import org.springframework.data.repository.CrudRepository

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
interface ItemRepository extends CrudRepository<Item, Long> {

}