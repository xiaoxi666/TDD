package stringcalculator.model;

public class Numbers {
    String[] values;

    private Numbers(String[] values) {
        this.values = values;
    }

    public static Numbers valueOf(String[] values) {
        return new Numbers(values);
    }

    public String[] getValues() {
        return values;
    }
}
