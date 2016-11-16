package ee.joel.decathlon.model;

public enum MeasurementUnit {
    SECOND("seconds"),
    METRES("meters"),
    CENTIMETRES("centimeters");

    private String unit;

    MeasurementUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
