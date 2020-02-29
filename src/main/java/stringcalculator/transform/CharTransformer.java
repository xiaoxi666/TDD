package stringcalculator.transform;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符转义
 */
public class CharTransformer {
    private static final Map<Character, String> MAP = new HashMap<>();

    static {
        MAP.put('|', "\\|");
        MAP.put('\n', "\\n");
    }

    public static String transform(char c) {
        String result = MAP.get(c);
        return result == null ? String.valueOf(c) : result;
    }

    public static String transform(String str) {
        if (str.length() == 1) {
            String result = MAP.get(str.charAt(0));
            if (result != null) {
                return result;
            }
        }
        return str;
    }
}
