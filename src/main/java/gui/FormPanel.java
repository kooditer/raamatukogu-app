package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel publishedLabel;
    private JTextField titleTextField;
    private JTextField authorTextField;
    private JTextField publishedTextField;
    private JButton btn_OK;
    private FormListener formListener;
    private JComboBox zhanrCombo;
    private JComboBox arvustusCombo;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);

        titleLabel = new JLabel("Pealkiri: ");
        authorLabel = new JLabel("Autor: ");
        publishedLabel = new JLabel("Ilmumisaasta: ");
        titleTextField = new JTextField(10);
        authorTextField = new JTextField(10);
        publishedTextField = new JTextField(10);
        zhanrCombo = new JComboBox();


        DefaultComboBoxModel zhanrModel = new DefaultComboBoxModel();
        zhanrModel.addElement("Kriminull");
        zhanrModel.addElement("Põnevik");
        zhanrModel.addElement("Õpik");
        zhanrModel.addElement("Eneseabi");
        zhanrModel.addElement("Investeerimine");
        zhanrModel.addElement("Lasteraamat");
        zhanrCombo.setModel(zhanrModel);
        zhanrCombo.setSelectedIndex(0);

        arvustusCombo = new JComboBox();
        DefaultComboBoxModel arvustusModel = new DefaultComboBoxModel();
        arvustusModel.addElement("Väga hea");
        arvustusModel.addElement("Hea");
        arvustusModel.addElement("Keskmine");
        arvustusModel.addElement("Halb");
        arvustusModel.addElement("Väga halb");
        arvustusCombo.setModel(arvustusModel);
        zhanrCombo.setSelectedIndex(0);



        btn_OK = new JButton("OK");
        btn_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();
                String author = authorTextField.getText();
                String published = publishedTextField.getText();
                String zhanr = (String) zhanrCombo.getSelectedItem();
                String arvustus = (String) arvustusCombo.getSelectedItem();


                FormEvent ev = new FormEvent(this, title, author, published, zhanr, arvustus);

                if (formListener != null) {
                    formListener.formEventOccured(ev);
                }
            }
        });




        Border innerBorder = BorderFactory.createTitledBorder("RAAMATUD");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

    }//constructori lõpp

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();


/// ///////////////Pealkirja rida//////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(titleLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(titleTextField, gc);
/// ///////////////Autori rida//////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(authorLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);;
        add(authorTextField, gc);
/// ///////////////Ilmumisaasta rida//////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(publishedLabel, gc);

        gc.gridy = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);;
        add(publishedTextField, gc);

        /// ///////////////ZhanriCombobox rida//////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Raamatu zhanr: "), gc);

        gc.gridy = 3;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);;
        add(zhanrCombo, gc);

        /// ///////////////ArvustusCombobox rida//////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Raamatu arvustus: "), gc);

        gc.gridy = 4;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);;
        add(arvustusCombo, gc);
/// ///////////////Nupu rida//////////////////
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);;
        add(btn_OK, gc);

    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }

}//klassi lõpp
