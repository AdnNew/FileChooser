package com.adnnew.filechooser;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class Setting extends JFrame {

    private int xScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int yScreen = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int marker = 0;
    private JButton buttonFind = new JButton("FindWords");
    private JButton buttonChoose = new JButton("ChooseFile");
    private JTextArea textFinder = new JTextArea("Fragment, który chcesz wyszukać", 15, 40);
    private JTextArea textChooser = new JTextArea("Scieżka piku: ", 2, 40);
    private JScrollPane scrollFinder = new JScrollPane(textFinder);
    private JScrollPane scrollChooser = new JScrollPane(textChooser);
    private JFileChooser chooser = new JFileChooser();
    private String path;
    private String text = "";
    private Main main = new Main();

    public Setting() {
        super("FileChooser");
        this.setBounds(xScreen / 4, yScreen / 4, xScreen / 2, yScreen / 2);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        initComponent();
        setChooser();
        findFile();
        findText();
    }

    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }

    public int getMarker() {
        return marker;
    }

    public void setTextChooser(String text) {
        textChooser.setText(text);
    }

    private void initComponent() {
        JPanel panelButton = new JPanel();
        JPanel panelText = new JPanel();
        Container container = this.getContentPane();
        panelButton.add(buttonChoose);
        panelButton.add(buttonFind);
        panelText.add(scrollFinder, BorderLayout.NORTH);
        panelText.add(scrollChooser, BorderLayout.LINE_END);
        container.add(panelButton, BorderLayout.SOUTH);
        container.add(panelText, BorderLayout.CENTER);
        textChooser.setEditable(false);
    }

    private void setChooser() {
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        chooser.setFileFilter(new TypeFile());
        chooser.setAcceptAllFileFilterUsed(true);
    }

    private void findFile() {
        buttonChoose.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int choos = chooser.showOpenDialog(rootPane);
                if (choos == 0) {
                    path = chooser.getSelectedFile().getPath();
                }
            }
        });
    }

    private void findText() {
        buttonFind.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!textFinder.equals(text)) {
                    text = "" + textFinder.getText();
                }
                main.setCounter(0);
            }
        });
    }
}
