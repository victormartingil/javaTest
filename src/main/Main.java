package main;

import main.testing.*;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
//        trimAndSplit();
//        lengthAndSize();
//        writeFile();
        generateTreeDir();

    }

    private static void generateTreeDir() {
        DirTree dt = new DirTree();
        dt.generateTreeDir("uno/dos/tres/cuatro");
    }

    private static void writeFile() throws IOException {
        WritingFiles w = new WritingFiles();
        w.writeFileWithExistingText();
    }

    public static void lengthAndSize() {
        LengthAndSize ls = new LengthAndSize();
        ls.SizeAndLength();

    }

    public static void trimAndSplit() {
        String input = "12345678-A";
        String input2 = "aAbBcC A";

        StringTestingClass s = new StringTestingClass();

        // Trim
        System.out.println("Split 1 -> " + s.splitInput(input));
        System.out.println("Split 2 -> " + s.splitInput(input2));

        //Split
        System.out.println("Trim 1 -> " + s.trimInput(input));
        System.out.printf("Trim 2 -> %s\n", s.trimInput(input2));
        System.out.printf("Trim 3 -> %S\n", s.trimInput(input2));
    }

}
