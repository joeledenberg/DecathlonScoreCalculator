package ee.joel.decathlon.component;

import dagger.Component;
import ee.joel.decathlon.module.ResourceModule;
import ee.joel.decathlon.module.ServiceModule;
import ee.joel.decathlon.resource.DecathlonScoreResource;
import ee.joel.decathlon.resource.IndexResource;

import javax.inject.Singleton;

@Singleton
@Component(modules={
    ResourceModule.class,
    ServiceModule.class
})
public interface ApplicationComponent {

    IndexResource indexResource();
    DecathlonScoreResource decathlonScoreResource();

}