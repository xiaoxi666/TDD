package stringcalculator.check;

import stringcalculator.check.exception.ExceptionMessage;

public class MissNumberAtLastChecker extends AbstractChecker implements Checker{

    @Override
    public void doCheck(CheckRequest request, CheckResponse response) {
        String numbers = request.getNumbers();
        char lastChar = numbers.charAt(numbers.length() - 1);
        if (!isDigital(lastChar)) {
            response.addResult(ExceptionMessage.valueOf(buildMessage()));
        }
    }

    private String buildMessage() {
        return "Number expected but EOF found.";
    }
}
