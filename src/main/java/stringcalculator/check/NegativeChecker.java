package stringcalculator.check;

import stringcalculator.check.exception.ExceptionMessage;
import stringcalculator.transform.CharTransformer;

import java.util.StringJoiner;

public class NegativeChecker implements Checker {
    private final String delimiter;

    public NegativeChecker(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public void doCheck(CheckRequest request, CheckResponse response) {
        String[] values = request.getNumbers().split(CharTransformer.transform(delimiter));
        StringJoiner sj = new StringJoiner(", ");
        for (String number : values) {
            if (number.startsWith("-")) {
                sj.add(number);
            }
        }
        String negatives = sj.toString();
        if (!negatives.isEmpty()) {
            response.addResult(ExceptionMessage.valueOf(buildMessage(negatives)));
        }
    }

    private String buildMessage(String negatives) {
        return "Negative not allowed : " + negatives;
    }
}
