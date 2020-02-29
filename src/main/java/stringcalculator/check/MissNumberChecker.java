package stringcalculator.check;

import stringcalculator.check.exception.ExceptionMessage;
import stringcalculator.transform.CharTransformer;

public class MissNumberChecker extends AbstractChecker implements Checker {

    private final String delimiter;

    public MissNumberChecker(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public void doCheck(CheckRequest request, CheckResponse response) {
        String numbers = request.getNumbers();
        char cur;
        char prev;
        for (int i = 1; i < numbers.length(); ) {
            cur = numbers.charAt(i);
            prev = numbers.charAt(i - 1);
            if (!isDigital(cur) && !isDot(cur) && !isNegative(cur)) {
                if (!isDigital(prev) && !isDot(prev) && !isNegative(prev)) {
                    response.addResult(ExceptionMessage.valueOf(buildMessage(cur, i)));
                    break;
                }
                i += delimiter.length();
            } else {
                ++i;
            }
        }
    }

    private boolean isNegative(char cur) {
        if (cur == '-') {
            return true;
        }
        return false;
    }

    private String buildMessage(char cur, int i) {
        String invalidChar = CharTransformer.transform(cur);
        return "Number expected but '" + invalidChar + "' found at position " + i + ".";
    }

}
