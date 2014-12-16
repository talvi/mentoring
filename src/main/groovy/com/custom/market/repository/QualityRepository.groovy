package com.custom.market.repository

import com.custom.market.domain.Quality
import org.springframework.data.repository.CrudRepository

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
interface QualityRepository extends CrudRepository<Quality, Long> {

}