package Testo;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;

/**
 * Created by Orion on 12/01/14.
 */
public class MyFrame extends JFrame {
    private JPanel nord = new JPanel();
    private JPanel centro = new JPanel();
    private JPanel sud = new JPanel();
    private JLabel etichetta = new JLabel("Prova a cliccare");
    private JTextField txt = new JTextField(20);
    private JButton btn = new JButton("Click me");

    public MyFrame(){
        super("Vai");
        Container c = this.getContentPane();

        c.add(nord, BorderLayout.NORTH);
        c.add(centro, BorderLayout.CENTER);
        c.add(sud, BorderLayout.SOUTH);

        nord.add(etichetta);
        nord.setLayout(new FlowLayout(FlowLayout.LEFT));
        centro.add(txt);
        sud.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esegui();
            }
        });

        //centra la finestra
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void esegui(){
        JOptionPane.showMessageDialog(txt, txt.getText());
        return;
    }
}
