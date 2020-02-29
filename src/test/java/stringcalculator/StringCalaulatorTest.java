package stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalaulatorTest {

    @Test
    public void should_add_when_input_is_empty() {
        String input = "";
        String expected = "0";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_add_when_input_have_one_number() {
        String input = "1";
        String expected = "1";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_add_when_input_have_two_numbers() {
        String input = "1.1,2.2";
        String expected = "3.3";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_add_with_newLine_separator() {
        String input = "1\n2,3";
        String expected = "6";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_add_when_misssing_number() {
        String input = "175.2,\n35";
        String expected = "Number expected but '\\n' found at position 6.";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_add_when_misssing_number_at_last() {
        String input = "1,3,";
        String expected = "Number expected but EOF found.";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_add_with_custom_separator_case1() {
        String input = "//;\n1;2";
        String expected = "3";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_add_with_custom_separator_case2() {
        String input = "//|\n1|2|3";
        String expected = "6";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_add_with_custom_separator_case3() {
        String input = "//sep\n2sep3";
        String expected = "5";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_add_with_custom_separator_with_invalid_separator() {
        String input = "//|\n1|2,3";
        String expected = "'|' expected but ',' found at position 3.";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_add_with_negative_numbers_case1() {
        String input = "-1,2";
        String expected = "Negative not allowed : -1";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_add_with_negative_numbers_case2() {
        String input = "2,-4,-5";
        String expected = "Negative not allowed : -4, -5";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_add_with_multiples_error() {
        String input = "-1,,2";
        String expected = "Negative not allowed : -1\nNumber expected but ',' found at position 3.";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.add(input);
        Assert.assertEquals(expected, actual);
    }

    private boolean compareDouble(String d1Str, String d2Str) {
        Double d1 = Double.valueOf(d1Str);
        Double d2 = Double.valueOf(d2Str);
        return d1 - 1e-6 < d2 && d1 + 1e-6 > d2;
    }







    @Test
    public void should_multiply_when_input_is_empty() {
        String input = "";
        String expected = "0";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_multiply_when_input_have_one_number() {
        String input = "1";
        String expected = "1";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_multiply_when_input_have_two_numbers() {
        String input = "1.1,2.2";
        String expected = "2.42";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_multiply_with_newLine_separator() {
        String input = "2\n3,4";
        String expected = "24";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_multiply_when_misssing_number() {
        String input = "175.2,\n35";
        String expected = "Number expected but '\\n' found at position 6.";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_multiply_when_misssing_number_at_last() {
        String input = "1,3,";
        String expected = "Number expected but EOF found.";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_multiply_with_custom_separator_case1() {
        String input = "//;\n1;2";
        String expected = "2";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_multiply_with_custom_separator_case2() {
        String input = "//|\n2|3|4";
        String expected = "24";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_multiply_with_custom_separator_case3() {
        String input = "//sep\n2sep3";
        String expected = "6";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertTrue(compareDouble(expected, actual));
    }

    @Test
    public void should_multiply_with_custom_separator_with_invalid_separator() {
        String input = "//|\n1|2,3";
        String expected = "'|' expected but ',' found at position 3.";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_multiply_with_negative_numbers_case1() {
        String input = "-1,2";
        String expected = "Negative not allowed : -1";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_multiply_with_negative_numbers_case2() {
        String input = "2,-4,-5";
        String expected = "Negative not allowed : -4, -5";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_multiply_with_multiples_error() {
        String input = "-1,,2";
        String expected = "Negative not allowed : -1\nNumber expected but ',' found at position 3.";
        StringCalculator calculator = new StringCalculator();
        String actual = calculator.multiply(input);
        Assert.assertEquals(expected, actual);
    }
}
