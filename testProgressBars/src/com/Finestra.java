package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Orion on 30/01/14.
 */
public class Finestra extends JPanel {
    public JFrame frame = new JFrame();
    public JProgressBar pb = new JProgressBar();
    public JLabel l = new JLabel("Caricamento in corso...");

    public Finestra(){

        this.setLayout(new BoxLayout(this, 1));
        this.add(l);
        this.add(pb);

        pb.setStringPainted(true);

               Scarica s = new Scarica(pb);
        Thread t = new Thread(s);
        t.start();

        frame.setContentPane(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
