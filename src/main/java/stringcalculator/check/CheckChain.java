package stringcalculator.check;

import java.util.ArrayList;
import java.util.List;

public class CheckChain{
    private List<Checker> checkers = new ArrayList<>();
    public CheckResponse doCheck(CheckRequest request, CheckResponse response) {
        for (Checker checker : checkers) {
            checker.doCheck(request, response);
        }
        return response;
    }

    public CheckChain add(Checker checker) {
        checkers.add(checker);
        return this;
    }
}
