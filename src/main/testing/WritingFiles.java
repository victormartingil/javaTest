package main.testing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WritingFiles {

    public void writeFileWithExistingText() throws IOException {
        File file = new File("documents/hola.txt");
        String textToAdd = "Texto añadido linea 1\nTexto añadido línea 2";

        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String line = "";
        ArrayList<String> oldContentArray = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            oldContentArray.add(line);
        }

        String fullContent = "";

        for (int i = 0; i < oldContentArray.size(); i++) {
            if (i != oldContentArray.size()-1) { // if not last, we add a line break
                fullContent = fullContent + oldContentArray.get(i) + "\n";
            } else { // if last, we also add line break
                fullContent = fullContent + oldContentArray.get(i) + "\n";
            }
        }

        fullContent = fullContent + textToAdd;

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        writer.write(fullContent);
        writer.flush();
        writer.close();
    }
}
