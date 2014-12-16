package com.custom.market.config

import akka.actor.ActorSystem
import com.custom.market.tools.akka.SpringExtension
import com.typesafe.config.ConfigFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
@Configuration
class AkkaConfig {

    // the application context is needed to initialize the Akka Spring Extension
    @Autowired
    private ApplicationContext applicationContext
    @Value('${akka.config}')
    private String akkaConfig

    @Bean
    public ActorSystem actorSystem() {
        ActorSystem system = ActorSystem.create("CustomMarketSystem", ConfigFactory.load(akkaConfig));
        SpringExtension.SpringExtProvider.get(system).initialize(applicationContext);
        return system;
    }

}
