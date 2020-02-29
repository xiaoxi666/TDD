package stringcalculator.processor;

import stringcalculator.model.OperationResult;
import stringcalculator.separator.Separator;

public class AddProcessor extends AbstractProcessor implements Processor {
    public AddProcessor(String input) {
        super(input);
    }

    @Override
    public OperationResult doProcess() {
        return super.doProcess();
    }

    @Override
    Double calculator(Separator separator) {
        Double result = 0.0d;
        for (String number : separator.split().getValues()) {
            result += Double.valueOf(number);
        }
        return result;
    }
}
