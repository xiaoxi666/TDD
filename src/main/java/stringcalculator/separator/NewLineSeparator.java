package stringcalculator.separator;

import java.util.Map;

public class NewLineSeparator extends AbstractSeparator {
    private static final String SEPARATOR = "\n";

    @Override
    public String getSeparator() {
        return SEPARATOR;
    }

    @Override
    public void updateCache(Map<Class, AbstractSeparator> cache) {
        cache.put(NewLineSeparator.class, new NewLineSeparator());
    }
}
