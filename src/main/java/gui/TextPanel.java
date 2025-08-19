package gui;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JTextArea textArea;

    public TextPanel() {
        textArea = new JTextArea();

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }//gui.TextPanel constructor lõppeb
    public void appendText(String text) {
        textArea.append(text);
    }

}//gui.TextPanel class lõppeb
