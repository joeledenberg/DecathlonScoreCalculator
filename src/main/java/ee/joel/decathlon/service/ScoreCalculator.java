package ee.joel.decathlon.service;

import ee.joel.decathlon.model.Event;
import ee.joel.decathlon.model.ResultWithAdjustmentScores;
import ee.joel.decathlon.model.Score;

import java.util.function.Function;

import static ee.joel.decathlon.model.ResultWithAdjustmentScores.Builder.newResultWithAdjustmentScores;

public class ScoreCalculator {

    public Score calculatePoints(Event event, float resultValue) {
        ResultWithAdjustmentScores eventResult = newResultWithAdjustmentScores()
                                                    .withEvent(event)
                                                    .withResult(resultValue)
                                                    .build();
        Function<ResultWithAdjustmentScores, Integer> scoreFunction = event.getScoreFunction();
        Integer apply = scoreFunction.apply(eventResult);
        return new Score(apply, event);
    }
}
