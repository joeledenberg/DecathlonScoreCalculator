package ee.joel.decathlon.acceptancetest.story;

import ee.joel.decathlon.acceptancetest.BaseAcceptanceTestComponent;
import ee.joel.decathlon.model.Event;
import org.junit.Test;

import static com.shazam.gwen.Gwen.then;
import static com.shazam.gwen.Gwen.when;

public class CanCalculateEventScore extends BaseAcceptanceTestComponent {

    @Test
    public void userCanCalculateEventScore() throws Exception {

        when(visitor).inputsScore(Event.POLE_VAULT, 141f);

        then(visitor).seesScore(42);
    }

}
