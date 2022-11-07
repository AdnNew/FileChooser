package com.adnnew.filechooser;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class TypeFile extends FileFilter {

    private String[] types = {".txt", ".htm", ".rtf", ".xml"};
    private String description = "Pliki tekstowe";

    @Override
    public boolean accept(File file) {
        for (int i = 0; i < types.length; i++) {
            if (file.getName().toLowerCase().endsWith(types[i]) || file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
