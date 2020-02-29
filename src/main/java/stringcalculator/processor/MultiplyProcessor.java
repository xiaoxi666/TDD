package stringcalculator.processor;

import stringcalculator.model.OperationResult;
import stringcalculator.separator.Separator;

public class MultiplyProcessor extends AbstractProcessor implements Processor {
    public MultiplyProcessor(String input) {
        super(input);
    }

    @Override
    public OperationResult doProcess() {
        return super.doProcess();
    }

    @Override
    Double calculator(Separator separator) {
        Double result = 1.0d;
        for (String number : separator.split().getValues()) {
            result *= Double.valueOf(number);
        }
        return result;
    }
}
