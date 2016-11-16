package ee.joel.decathlon.model;

public class ResultWithAdjustmentScores {
    private float a;
    private float b;
    private float c;
    private float result;

    private ResultWithAdjustmentScores(Builder builder) {
        a = builder.a;
        b = builder.b;
        c = builder.c;
        result = builder.result;
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

    public float getResult() {
        return result;
    }

    public static final class Builder {
        private float a;
        private float b;
        private float c;
        private float result;

        public static Builder newResultWithAdjustmentScores() {
            return new Builder();
        }

        private Builder() {
        }

        public Builder withA(float a) {
            this.a = a;
            return this;
        }

        public Builder withB(float b) {
            this.b = b;
            return this;
        }

        public Builder withC(float c) {
            this.c = c;
            return this;
        }

        public Builder withEvent(Event event) {
            this.a = event.getA();
            this.b = event.getB();
            this.c = event.getC();
            return this;
        }

        public Builder withResult(float val) {
            result = val;
            return this;
        }

        public ResultWithAdjustmentScores build() {
            return new ResultWithAdjustmentScores(this);
        }
    }
}
