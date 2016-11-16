package ee.joel.decathlon.resource;

import ee.joel.decathlon.model.Event;
import ee.joel.decathlon.service.ScoreCalculator;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

public class  DecathlonScoreResourceTest {
    private static final ScoreCalculator scoreCalculator = mock(ScoreCalculator.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new DecathlonScoreResource(scoreCalculator))
            .build();

    @After
    public void tearDown(){
        reset(scoreCalculator);
    }

    @Test
    public void testCalculateScore() {
        Entity<?> eventResult = Entity.json("{\"event\":\"DISCUS_THROW\",\"result\":10.0}");

        Response post = resources.client().target("/decathlon").request().post(eventResult);

        assertThat(post.getStatusInfo().equals(Response.Status.OK));
        verify(scoreCalculator).calculatePoints(eq(Event.DISCUS_THROW), eq(10f));
    }
}