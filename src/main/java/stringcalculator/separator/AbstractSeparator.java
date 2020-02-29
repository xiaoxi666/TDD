package stringcalculator.separator;

import java.util.Map;

public abstract class AbstractSeparator {
    abstract String getSeparator();
    abstract void updateCache(Map<Class, AbstractSeparator> cache);
}
