package com.custom.market.tools.akka

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;

/**
 * Created by Maksim_Strelnikov on 12/16/2014.
 */
class SpringExtension extends AbstractExtensionId<SpringExtension.SpringExt> {

    /**
     * The identifier used to access the SpringExtension.
     */
    static SpringExtension SpringExtProvider = new SpringExtension()

    /**
     * Is used by Akka to instantiate the Extension identified by this
     * ExtensionId, internal use only.
     */
    @Override
    SpringExt createExtension(ExtendedActorSystem system) {
        return new SpringExt();
    }

    /**
     * The Extension implementation.
     */
    static class SpringExt implements Extension {
        private volatile ApplicationContext applicationContext

        /**
         * Used to initialize the Spring application context for the extension.
         * @param applicationContext
         */
        void initialize(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext
        }

        /**
         * Create a Props for the specified actorBeanName using the
         * SpringActorProducer class.
         *
         * @param actorBeanName  The name of the actor bean to create Props for
         * @return a Props that will create the named actor bean using Spring
         */
        Props props(String actorBeanName) {
            return Props.create(SpringActorProducer.class,
                    applicationContext, actorBeanName)
        }
    }
}
