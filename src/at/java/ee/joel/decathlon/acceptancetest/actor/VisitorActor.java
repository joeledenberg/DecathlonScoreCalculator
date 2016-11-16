package ee.joel.decathlon.acceptancetest.actor;

import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Asserter;
import ee.joel.decathlon.model.Event;
import ee.joel.decathlon.model.Score;
import ee.joel.decathlon.service.ScoreCalculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;


public class VisitorActor implements Actor, Asserter {

    Score lastScore;

    private ScoreCalculator scoreCalculator;

    public VisitorActor(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public void inputsScore(Event event, float result) {
        lastScore = scoreCalculator.calculatePoints(event, result);
    }

    public void seesScore(int expectedScore) {
        assertThat(lastScore.getScore(), equalTo(expectedScore));
    }
}
