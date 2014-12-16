package com.custom.market.actor

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.testkit.JavaTestKit
import scala.concurrent.duration.Duration
import spock.lang.Specification

import java.util.concurrent.TimeUnit

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
class SteamRequestActorTest extends Specification {

    ActorSystem system
    JavaTestKit testKit
    ActorRef steamRequestActor

    def setup() {
        system = ActorSystem.create()
        testKit = new JavaTestKit(system)
        //shortUrlRepository = Mockito.mock(ShortUrlRepository)
        Props props = Props.create(SteamRequestActor)
        steamRequestActor = system.actorOf(props, 'steamRequestActor')
    }

    def "actor must return a response containing short url"() {
        given: 'short url request'
        String request = 'lol'
        when: 'calling generate short url actor'
        steamRequestActor.tell request, testKit.ref
        String response = testKit.receiveOne(Duration.create(1, TimeUnit.SECONDS))
        then: 'response containing short url'
        println response
    }

}
