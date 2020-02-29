package stringcalculator.check;

public class AbstractChecker {
    protected boolean isDigital(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    protected boolean isDot(char c) {
        if (c == '.') {
            return true;
        }
        return false;
    }
}
