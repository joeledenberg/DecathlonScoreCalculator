package ee.joel.decathlon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Result {
    private Event event;
    private float result;

    private Result() {
    }

    public Result(Event event, float result) {
        this.event = event;
        this.result = result;
    }

    public Event getEvent() {
        return event;
    }

    public float getResult() {
        return result;
    }

    @JsonIgnore
    public float getResultValue() {
        return this.result;
    }
}
