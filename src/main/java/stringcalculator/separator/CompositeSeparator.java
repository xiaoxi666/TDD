package stringcalculator.separator;

import stringcalculator.model.Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeSeparator implements Separator{
    // 定义一个默认分隔符
    private static final String SEPARATOR = ",";
    private final String input;
    private final List<AbstractSeparator> supportSerapators = new ArrayList<>();
    private final Map<Class, AbstractSeparator> cache = new HashMap<>();

    public CompositeSeparator(String input) {
        this.input = input;
    }

    public String getDelimiter() {
        return SEPARATOR;
    }

    public CompositeSeparator add(Class<? extends AbstractSeparator> separatorClazz) {
        AbstractSeparator separator = cache.get(separatorClazz);
        if (separator != null) {
            supportSerapators.add(separator);
            return this;
        }
        updateCache(separatorClazz);
        supportSerapators.add(cache.get(separatorClazz));
        return this;
    }


    private void updateCache(Class<? extends AbstractSeparator> separatorClazz) {
        try {
            separatorClazz.newInstance().updateCache(cache);
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println(e);
        }
    }

    @Override
    public Numbers split() {
        return Numbers.valueOf(replaceDelimiterWithDefault().split(SEPARATOR));
    }

    private String replaceDelimiterWithDefault() {
        String inputAfterReplaceSeparators = input;
        for (AbstractSeparator s : supportSerapators) {
            inputAfterReplaceSeparators = input.replace(s.getSeparator(), SEPARATOR);
        }
        return inputAfterReplaceSeparators;
    }
}
