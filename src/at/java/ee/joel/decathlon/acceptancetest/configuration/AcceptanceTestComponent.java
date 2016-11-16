package ee.joel.decathlon.acceptancetest.configuration;

import dagger.Component;
import ee.joel.decathlon.acceptancetest.actor.VisitorActor;
import ee.joel.decathlon.acceptancetest.configuration.module.ActorsModule;
import ee.joel.decathlon.module.ResourceModule;
import ee.joel.decathlon.module.ServiceModule;

import javax.inject.Singleton;

@Singleton
@Component(modules={ResourceModule.class,
                    ServiceModule.class,
                    ActorsModule.class})
public interface AcceptanceTestComponent {
    VisitorActor visitorActor();
}