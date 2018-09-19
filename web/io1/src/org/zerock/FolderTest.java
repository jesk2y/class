package org.zerock;

import java.io.File;

public class FolderTest {

    public static void main(String[] args) {

        File folder =
                new File("C:\\zzz\\img");

        String[] fileNames = folder.list();

        for (String fileName:fileNames   ) {
            System.out.println(fileName);
        }
        int idx = (int)(Math.random()* fileNames.length);
        System.out.println(idx);

    }
}
