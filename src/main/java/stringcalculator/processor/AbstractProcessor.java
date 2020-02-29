package stringcalculator.processor;

import stringcalculator.check.CheckChain;
import stringcalculator.check.CheckRequest;
import stringcalculator.check.CheckResponse;
import stringcalculator.check.InvalidSeparatorChecker;
import stringcalculator.check.MissNumberAtLastChecker;
import stringcalculator.check.MissNumberChecker;
import stringcalculator.check.NegativeChecker;
import stringcalculator.check.exception.ExceptionMessage;
import stringcalculator.model.OperationResult;
import stringcalculator.separator.CommaSeparator;
import stringcalculator.separator.CompositeSeparator;
import stringcalculator.separator.CustomSeparator;
import stringcalculator.separator.NewLineSeparator;
import stringcalculator.separator.Separator;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractProcessor implements Processor {
    private final String input;

    public AbstractProcessor(String input) {
        this.input = input;
    }

    @Override
    public OperationResult doProcess() {
        if (input.isEmpty()) {
            return new OperationResult("0");
        }
        if (input.length() == 1) {
            return new OperationResult(input);
        }
        Separator separator = getSeparator(input);
        CheckResponse checkResponse = check(separator);
        return getOperationResult(separator, checkResponse);
    }

    private OperationResult getOperationResult(Separator separator, CheckResponse checkResponse) {
        List<ExceptionMessage> exceptionMessages = checkResponse.getExceptionMessage();
        if (!exceptionMessages.isEmpty()) {
            return new OperationResult(exceptionMessages.stream()
                .map(ExceptionMessage::getMessage)
                .collect(Collectors.joining("\n")));
        }

        Double result = calculator(separator);
        return new OperationResult(result.toString());
    }

    abstract Double calculator(Separator separator);

    private CheckResponse check(Separator separator) {
        String numbers = input;
        String delimiter = null;
        CheckChain checkChain = new CheckChain();
        if (separator instanceof CustomSeparator) {
            numbers = ((CustomSeparator) separator).getNumbers();
            delimiter = ((CustomSeparator) separator).getDelimiter();
            checkChain.add(new InvalidSeparatorChecker(delimiter));
        } else if (separator instanceof CompositeSeparator) {
            delimiter = ((CompositeSeparator) separator).getDelimiter();
        }
        checkChain.add(new NegativeChecker(delimiter))
            .add(new MissNumberChecker(delimiter))
            .add(new MissNumberAtLastChecker());
        return checkChain.doCheck(new CheckRequest(numbers), new CheckResponse());
    }

    private Separator getSeparator(String input) {
        if (input.startsWith(CustomSeparator.TAG)) {
            return new CustomSeparator(input);
        }
        CompositeSeparator compositeSeparator = new CompositeSeparator(input);
        compositeSeparator
            .add(CommaSeparator.class)
            .add(NewLineSeparator.class);
        return compositeSeparator;
    }
}
