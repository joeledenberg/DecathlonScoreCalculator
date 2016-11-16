package ee.joel.decathlon;

import ee.joel.decathlon.component.ApplicationComponent;
import ee.joel.decathlon.component.DaggerApplicationComponent;
import ee.joel.decathlon.configuration.WebConfiguration;
import ee.joel.decathlon.healthcheck.AppHealthCheck;
import ee.joel.decathlon.module.ResourceModule;
import ee.joel.decathlon.module.ServiceModule;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.views.freemarker.FreemarkerViewRenderer;

import static com.google.common.collect.Lists.newArrayList;

public class StartApplication extends Application<WebConfiguration> {

    public static void main(String[] args) throws Exception {
        new StartApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<WebConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/staatiline"));
        bootstrap.addBundle(new ViewBundle<>());
    }

    @Override
    public void run(WebConfiguration configuration, Environment environment) throws ClassNotFoundException {

        ApplicationComponent component;
        component = DaggerApplicationComponent.builder()
                .resourceModule(new ResourceModule())
                .serviceModule(new ServiceModule())
                .build();
        environment.jersey().register(component.indexResource());
        environment.jersey().register(component.decathlonScoreResource());
        environment.jersey().setUrlPattern("/*");
        environment.jersey().register(new JsonProcessingExceptionMapper(true));
        environment.healthChecks().register("Decathlon-app", new AppHealthCheck());
    }
}
