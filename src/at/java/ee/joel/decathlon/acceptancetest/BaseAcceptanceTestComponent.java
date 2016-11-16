package ee.joel.decathlon.acceptancetest;

import ee.joel.decathlon.StartApplication;
import ee.joel.decathlon.acceptancetest.actor.VisitorActor;
import ee.joel.decathlon.acceptancetest.configuration.AcceptanceTestComponent;
import ee.joel.decathlon.acceptancetest.configuration.DaggerAcceptanceTestComponent;
import ee.joel.decathlon.configuration.WebConfiguration;
import ee.joel.decathlon.module.ResourceModule;
import ee.joel.decathlon.module.ServiceModule;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.AfterClass;
import org.junit.ClassRule;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;

public class BaseAcceptanceTestComponent {
    public AcceptanceTestComponent component;
    public VisitorActor visitor;

    @ClassRule
    public static final DropwizardAppRule<WebConfiguration> RULE =
            new DropwizardAppRule<>(StartApplication.class, resourceFilePath("dropwizardConfig.yml"));

    public BaseAcceptanceTestComponent() {
        component = DaggerAcceptanceTestComponent.builder()
                .serviceModule(new ServiceModule())
                .build();
        visitor = component.visitorActor();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        RULE.getEnvironment().getApplicationContext().stop();
    }
}
