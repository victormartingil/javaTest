package main.testing;

import java.io.File;

public class DirTree {

    public void generateTreeDir(String dirTree) {
        // This method will generate the folder tree in case any folder does not exist
        String[] directories = dirTree.split("/");
        int folders = directories.length;
        String builtPath = "";

        for (int i = 0; i < folders; i++) {
            if (i == 0) {
                if (!(new File(directories[i]).exists())) {
                    (new File(directories[i])).mkdir();
                    builtPath = directories[i];
                } else {
                    builtPath = directories[i];
                }
            } else {
                if (!(new File(builtPath + "/" + directories[i]).exists())) {
                    (new File(builtPath + "/" + directories[i])).mkdir();
                    builtPath = builtPath + "/" + directories[i];
                } else {
                    builtPath = builtPath + "/" + directories[i];
                }
            }
        }
    }

}
