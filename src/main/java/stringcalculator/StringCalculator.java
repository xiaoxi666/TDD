package stringcalculator;

import stringcalculator.model.OperationResult;
import stringcalculator.processor.AddProcessor;
import stringcalculator.processor.MultiplyProcessor;

public class StringCalculator {
    public String add(String input) {
        OperationResult result = new AddProcessor(input).doProcess();
        return result.getValue();
    }

    public String multiply(String input) {
        OperationResult result = new MultiplyProcessor(input).doProcess();
        return result.getValue();
    }
}
