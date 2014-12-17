package com.custom.market.controller

import org.springframework.web.bind.annotation.RestController

import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.TEXT

import groovyx.net.http.HTTPBuilder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by Talvi on 12.12.2014.
 */
@RestController
class Steam {

    @RequestMapping('/steam')
    String makeRequest() {
        def http = new HTTPBuilder()

        http.request( 'http://125.252.219.235', GET, TEXT ) { req ->
            uri.path = '/market/search/render/?query=&start=10&count=10&search_descriptions=0&sort_column=quantity&sort_dir=desc&appid=440'
            //uri.query = [ v:'1.0', q: 'Calvin and Hobbes' ]
            headers.'User-Agent' = "Mozilla/5.0 Firefox/3.0.4"
            headers.'Host' = "steamcommunity.com"
            headers.Accept = 'application/json'

            response.success = { resp, reader ->
                assert resp.statusLine.statusCode == 200
                println "Got response: ${resp.statusLine}"
                println "Content-Type: ${resp.headers.'Content-Type'}"
                println reader.text
            }

            response.'404' = {
                println 'Not found'
            }
        }
    }

}
