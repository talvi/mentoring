package com.custom.market.actor

import akka.actor.UntypedActor
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SteamRequestActor extends UntypedActor {

    @Override
    void onReceive(Object o) throws Exception {
        if (o instanceof String) {
            getSender().tell('wtf', self())
            //sender.tell 'wtf' self()
        }
    }
}
