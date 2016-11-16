package ee.joel.decathlon.model;

import java.util.function.Function;

import static ee.joel.decathlon.model.MeasurementUnit.CENTIMETRES;
import static ee.joel.decathlon.model.MeasurementUnit.SECOND;

public enum Event {

    HUNDRED_METRES("100m", 25.4347f, 18f, 1.81f, EventType.TRACK, SECOND),
    LONG_JUMP("long jump", 0.14354f, 220f, 1.4f, EventType.FIELD, CENTIMETRES),
    SHOT_PUT("shot put", 51.39f, 1.5f, 1.05f, EventType.FIELD, MeasurementUnit.METRES),
    HIGH_JUMP("high jump", 0.8465f, 75f, 1.42f, EventType.FIELD, CENTIMETRES),
    FOUR_HUNDRED_METRES("400m", 1.53775f, 82f, 1.81f, EventType.TRACK, SECOND),
    ONE_HUNDRED_AND_TEN_METRES_HURDLES("110m hurdles", 5.74352f, 28.5f, 1.92f,EventType.TRACK, SECOND),
    DISCUS_THROW("discus throw", 12.91f, 4f, 1.1f, EventType.FIELD, MeasurementUnit.METRES),
    POLE_VAULT("pole vault", 0.2797f, 100f, 1.35f, EventType.FIELD, CENTIMETRES),
    JAVELIN_THROW("javelin throw", 10.14f, 7f, 1.08f, EventType.FIELD, MeasurementUnit.METRES),
    ONE_POINT_FIVE_KILOMETERS("1500m", 0.03768f, 480f, 1.85f, EventType.TRACK, SECOND);

    private String name;
    private final float a;
    private final float b;
    private final float c;
    private EventType eventType;
    private MeasurementUnit measurementUnit;

    Event(String name, float a, float b, float c, EventType eventType, MeasurementUnit measurementUnit) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.eventType = eventType;
        this.measurementUnit = measurementUnit;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public String getName() {
        return name;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public Function<ResultWithAdjustmentScores, Integer> getScoreFunction() {
        return eventType.getScoreFunction();
    }

}






