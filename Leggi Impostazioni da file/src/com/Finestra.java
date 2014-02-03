package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

import javax.swing.*;

public class Finestra extends JPanel{
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Apri il menu impostazioni in alto");
    JMenu menu = new JMenu("Impostazioni");
    JMenuBar menuBar = new JMenuBar();
    JMenuItem configuraMenuItem = new JMenuItem("Configurazione");

    public static final String PERCORSO = "C:\\Users\\Orion\\Desktop\\settings.txt";

    public Finestra() {
        menu.add(configuraMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        Properties p = leggiFile();

        configuraMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Configurazione c = new Configurazione();
            }
        });

        this.add(label);
        frame.setSize(getWidth(p), getHeight(p));
        frame.setContentPane(frame.getContentPane());
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static Properties leggiFile(){
        Properties properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(PERCORSO);
            properties.load(fis);
            return properties;
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int getWidth(Properties p){
        int w = Integer.parseInt(p.getProperty("width"));
        return w;
    }

    public static int getHeight(Properties p){
        int h = Integer.parseInt(p.getProperty("height"));
        return h;
    }

}
