package main.testing;

public class StringTestingClass {


    public String splitInput(String input) {
        return input.split("\\.")[0];
    }

    public String trimInput(String input) {
        return input.trim();
    }

    public String substring(String input){
        return input.substring(0,16);
    }

    public void textContains(String input, String contains) {
        System.out.println("\"" + input + "\" contains \"" + contains + "\" -> " + input.toLowerCase().contains(contains));
    }
}
