package com.custom.market.controller

import com.custom.market.domain.Quality
import com.custom.market.repository.QualityRepository
import net.sf.json.JSON
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Talvi on 29.11.2014.
 */
@RestController
class QualityController {

    @Autowired
    private QualityRepository qualityRepository

    @RequestMapping(value = '/quality', method = RequestMethod.POST)
    String addQuality(Quality quality) {
        qualityRepository.add(quality)
    }

    @RequestMapping(value = '/quality/{id}', method = RequestMethod.GET)
    @ResponseBody
    String getQuality(@PathVariable('id') long id) {
        qualityRepository.findOne(id) as JSON
    }

}
