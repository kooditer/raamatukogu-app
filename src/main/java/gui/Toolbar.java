package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton btn_save;
    private JButton btn_new;
    private JButton btn_update;
    private JButton btn_delete;
    private StringListener textListener;
    public Toolbar() {

        setBorder(BorderFactory.createEtchedBorder());

        btn_new = new JButton("Lisa raamat");
        btn_save = new JButton("Salvesta raamat");
        btn_update = new JButton("Uuenda raamat");
        btn_delete = new JButton("Kustuta raamat");

        btn_new.addActionListener(this);
        btn_save.addActionListener(this);
        btn_update.addActionListener(this);
        btn_delete.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(btn_new);
        add(btn_save);
        add(btn_update);
        add(btn_delete);


    }//gui.Toolbar constructor lõpp

//    public void setTextPanel(gui.TextPanel textPanel) {
//        this.textPanel = textPanel;
    public void setStringListener(StringListener listener) {
        this.textListener = listener;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //JButton.getsource näitab ära mis nupult info tuleb
        JButton clicked = (JButton)e.getSource();
        if (clicked==btn_new) {
            if (textListener!=null) {
                textListener.textEmitted("Uue raamatu sisestamine\n");
            }
            //textPanel.appendText("Uue raamatu sisestamine\n");
            //System.out.println("Uue raamatu sisestamine");
        } else if (clicked==btn_save) {
            if (textListener!=null) {
                textListener.textEmitted("Raamatu salvestamine\n");
            }
            //textPanel.appendText("Raamat salvestatud\n");
            //System.out.println("Raamat salvestatud");
        } else if (clicked==btn_update) {
            if (textListener!=null) {
                textListener.textEmitted("Raamatu uuendamine\n");
            }
            //textPanel.appendText("Raamat uuendatud\n");
            //System.out.println("Raamat uuendatud");
        } else if (clicked==btn_delete) {
            if (textListener!=null) {
                textListener.textEmitted("Raamatu kustutamine\n");
            }
            //textPanel.appendText("Raamat kustutatud\n");
            //System.out.println("Raamat kustutatud");
        }
    }
}//class gui.Toolbar lõpp
