package ee.joel.decathlon.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Score {
    private int score;
    private String warning;

    public Score(int score) {
        this.score = score;
    }

    public Score(int score, Event event) {
        this.score = score;
        if (suspiciousValue(score)) {
            warning = createWarningMessage(event);
        }
    }

    private boolean suspiciousValue(int score) {
        return score == 0 || score > 2000;
    }

    private String createWarningMessage(Event event) {
        return String.format("Check measurement units. The %s result should be given in %s",
                event.getName(), event.getMeasurementUnit().getUnit());
    }

    public int getScore() {
        return score;
    }

    public String getWarning() {
        return warning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;

        Score score1 = (Score) o;

        return score == score1.score;

    }

    @Override
    public int hashCode() {
        return score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                '}';
    }
}
