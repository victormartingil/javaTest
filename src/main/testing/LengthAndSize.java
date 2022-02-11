package main.testing;

import java.util.ArrayList;

public class LengthAndSize {

    ArrayList<String> array = new ArrayList<>();
    String[] array2 = {"Uno", "Dos", "Tres"};

    public void SizeAndLength() {
        array.add("Uno");
        array.add("Dos");
        array.add("Tres");
        seeSize();
        seeLength();
    }

    public void seeSize() {
        System.out.println("Size -> " + array.size());
    }

    public void seeLength() {
        System.out.println("Length -> " + array2.length);
    }


}
