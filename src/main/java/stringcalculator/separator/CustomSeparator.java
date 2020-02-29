package stringcalculator.separator;

import stringcalculator.model.Numbers;
import stringcalculator.transform.CharTransformer;

public class CustomSeparator implements Separator {
    public static final String TAG = "//";
    private final String input;

    public CustomSeparator(String input) {
        this.input = input;
    }

    @Override
    public Numbers split() {
        return Numbers.valueOf(getNumbers().split(CharTransformer.transform(getDelimiter())));
    }

    public String getDelimiter() {
        int indexOfNewLine = input.indexOf("\n");
        return input.substring("//".length(), indexOfNewLine);
    }

    public String getNumbers() {
        int indexOfNewLine = input.indexOf("\n");
        return input.substring(indexOfNewLine + 1);
    }


}
