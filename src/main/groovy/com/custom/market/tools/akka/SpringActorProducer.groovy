package com.custom.market.tools.akka

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
class SpringActorProducer implements IndirectActorProducer {

    final ApplicationContext applicationContext
    final String actorBeanName

    SpringActorProducer(ApplicationContext applicationContext,
                               String actorBeanName) {
        this.applicationContext = applicationContext
        this.actorBeanName = actorBeanName
    }

    @Override
    Actor produce() {
        return (Actor) applicationContext.getBean(actorBeanName)
    }

    @Override
    Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName)
    }
}