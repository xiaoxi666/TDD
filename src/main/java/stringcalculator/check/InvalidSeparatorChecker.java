package stringcalculator.check;

import stringcalculator.check.exception.ExceptionMessage;
import stringcalculator.transform.CharTransformer;

public class InvalidSeparatorChecker extends AbstractChecker implements Checker {
    private final String delimiter;

    public InvalidSeparatorChecker(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public void doCheck(CheckRequest request, CheckResponse response) {
        String numbers = request.getNumbers();
        char cur;
        for (int i = 0; i < numbers.length(); ) {
            cur = numbers.charAt(i);
            if (isDigital(cur) || isDot(cur)) {
                ++i;
                continue;
            }
            // 根据题意，只检查一位非法字符
            if (cur != delimiter.charAt(0)) {
                response.addResult(ExceptionMessage.valueOf(buildMessage(cur, i)));
                return;
            } else {
                i += delimiter.length();
            }
        }
    }

    private String buildMessage(char cur, int i) {
        return "'" + delimiter + "' expected but '" + CharTransformer.transform(cur) + "' found at position "+ i +".";
    }


}
