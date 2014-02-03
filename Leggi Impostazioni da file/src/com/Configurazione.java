package com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Orion on 02/02/14.
 */
public class Configurazione extends JPanel {
    public JFrame frame = new JFrame("Configurazione");
    public JPanel form = new JPanel();
    public JTextField width = new JTextField();
    public JTextField height = new JTextField();
    public JLabel labelWidth = new JLabel("Larghezza");
    public JLabel labelHeight = new JLabel("Altezza");
    public JButton salva = new JButton("Salva");
    public JLabel istruzioni = new JLabel();

    public Configurazione(){
        this.setLayout(new BorderLayout());

        form.setLayout(new GridLayout(0 ,2));
        form.setSize(200, 100);
        this.add(form, BorderLayout.CENTER);

        form.add(labelWidth);
        form.add(width);
        form.add(labelHeight);
        form.add(height);

        JPanel topPanel = new JPanel();
        istruzioni.setText("Definisci le impostazioni del programma da qui");
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        form.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(salva);

        //imposto i valori dal file
        Properties p = Finestra.leggiFile();
        width.setText(Integer.toString(Finestra.getWidth(p)));
        height.setText(Integer.toString(Finestra.getHeight(p)));

        salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scriviImpostazioni();
            }
        });

        this.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(this);
        frame.setContentPane(frame.getContentPane());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void scriviImpostazioni(){
        File f = new File(Finestra.PERCORSO);
        Properties p = new Properties();
        try{
            FileOutputStream fos = new FileOutputStream(f);
            p.setProperty("width", width.getText());
            p.setProperty("height", height.getText());
            p.store(fos, "");
            fos.close();
            frame.dispose();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
