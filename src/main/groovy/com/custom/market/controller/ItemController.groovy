package com.custom.market.controller

import com.custom.market.domain.Item
import com.custom.market.repository.ItemRepository
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Talvi on 29.11.2014.
 */
@RestController
class ItemController {

    @Autowired
    private ItemRepository itemRepository

    @RequestMapping(value = '/item', method = RequestMethod.POST)
    String addQuality(@RequestBody Item item) {
        itemRepository.save(item)
    }

    @RequestMapping(value = '/item/{id}', method = RequestMethod.GET)
    @ResponseBody
    String getQuality(@PathVariable('id') long id) {
        return new JsonBuilder(itemRepository.findOne(id)).toPrettyString()
    }

}
