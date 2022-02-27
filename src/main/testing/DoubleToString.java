package main.testing;

public class DoubleToString {

    public String doubleToString (double number) {
        return String.valueOf(number*100).split("\\.")[0];
    }
}
