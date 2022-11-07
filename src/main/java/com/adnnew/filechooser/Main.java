package com.adnnew.filechooser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

    private static Setting setting = new Setting();
    private static String path = "";
    private static int counter = 1;
    private static int line = 0;

    public void setCounter(int counter) {
        Main.counter = counter;
    }

    public static void main(String[] args) throws InterruptedException {
        new Main();

        while (true) {
            Thread.sleep(1000);
            while (!path.equals(setting.getPath()) && path != null) {
                path = "" + setting.getPath();
                setting.setTextChooser("Scieżka piku: " + path);
            }
            while (counter == 0) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(path));
                    String plik = "";
                    line = 0;

                    while ((plik = reader.readLine()) != null) {
                        line++;
                        if (plik.toLowerCase().contains(setting.getText().toLowerCase())) {
                            counter = 1;
                            JOptionPane.showMessageDialog(setting, "Wybrany fragment znajduje się w pliku w " + line + " linii, w zdaniu: " + plik.substring(0, 70) + "...");
                            break;
                        }
                    }
                    if (counter == 0) {
                        JOptionPane.showMessageDialog(setting, "Nie znaleziono danego fragmentu");
                        counter = 1;
                    }
                    reader.close();

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
