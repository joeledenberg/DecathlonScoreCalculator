package ee.joel.decathlon.model;

import java.util.function.Function;

public enum EventType {

    TRACK(data -> (int) Math.floor(data.getA() * Math.pow(data.getB() - data.getResult(), data.getC()))),
    FIELD(data -> (int) Math.floor(data.getA() * Math.pow(data.getResult() - data.getB(), data.getC())));

    private Function<ResultWithAdjustmentScores, Integer> scoreFunction;

    EventType(Function<ResultWithAdjustmentScores, Integer> scoreFunction) {
        this.scoreFunction = scoreFunction;
    }

    public Function<ResultWithAdjustmentScores, Integer> getScoreFunction() {
        return scoreFunction;
    }
}
