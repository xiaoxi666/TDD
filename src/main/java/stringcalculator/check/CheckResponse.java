package stringcalculator.check;

import stringcalculator.check.exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class CheckResponse {
    List<ExceptionMessage> exceptionMessages = new ArrayList<>();

    public void addResult(ExceptionMessage result) {
        exceptionMessages.add(result);
    }

    public List<ExceptionMessage> getExceptionMessage() {
        return exceptionMessages;
    }
}





