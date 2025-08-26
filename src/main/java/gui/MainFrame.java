package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    //siia loon komponendid/variable-d
    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;
    private Controller controller;
    private TablePanel tablePanel;
    private JFileChooser failChooser;

    public MainFrame() {
        super("Raamatukogu Äpp");
        setLayout(new BorderLayout());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //siin aktiveerin komponendid
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        controller = new Controller();
        failChooser = new JFileChooser();


        tablePanel.setData(controller.getRaamatud());

        tablePanel.setRaamatuTabeliListener(new RaamatuTabeliListener() {
            public void rowDeleted(int row) {
                controller.removeRaamat(row);

            }
        });

        setJMenuBar(createMenubar());



        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                //System.out.println(text);
                textPanel.appendText(text);
                System.out.println("ahaa");
            }
        });

        formPanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {
                //tahan saata selle jama Raamat klassi database-i
                controller.addRaamat(e);
                tablePanel.refresh();
//
//                String title = e.getTitle();
//                String author = e.getAuthor();
//                String published = e.getPublished();
//                String zhanr = e.getZhanrCategory();
//                String arvustus = e.getArvustusCategory();
//
//                textPanel.appendText("Pealkiri: " + title + " *** " + "Autor: " + author + " *** " + "Ilmumisaasta: " + published + " *** " + "Zhanr: " + zhanr + " *** " + " Arvustus: " + arvustus +"\n");


            }
        });




        //siin panen komponendid content pane-le
        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);




    }//gui.MainFrame constructori lõpp
    private JMenuBar createMenubar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportItem = new JMenuItem("Export Data...");
        JMenuItem importItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exportItem);
        fileMenu.add(importItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        JMenuItem showFormItem = new JMenuItem("PersonForm");
        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);


        return menuBar;
    }


}//public class Mainframe lõpp
