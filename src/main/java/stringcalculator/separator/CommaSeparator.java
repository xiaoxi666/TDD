package stringcalculator.separator;

import java.util.Map;

public class CommaSeparator extends AbstractSeparator {
    private static final String SEPARATOR = ",";

    @Override
    public String getSeparator() {
        return SEPARATOR;
    }

    @Override
    public void updateCache(Map<Class, AbstractSeparator> cache) {
        cache.put(CommaSeparator.class, new CommaSeparator());
    }
}
