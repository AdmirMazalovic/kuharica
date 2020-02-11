package onlineKuharica.GUI;

import onlineKuharica.Jelo;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReceptiWindow extends JFrame {

    ReceptiWindow() {

        JLabel kratakOpisJela = new JLabel();


        Jelo jelo = new Jelo();
        ArrayList<Jelo> jela = jelo.getAllJelo();
        int brojJela = jela.size();

        JFrame receptiFrame = new JFrame();

        JButton vidiReceptButton = new JButton("Vidi recept");
        vidiReceptButton.setBounds(1100, 100, 140, 30);
        DefaultListModel<String> lista = new DefaultListModel<>();
        for (int i = 0; i < brojJela; i++) {
                    lista.addElement(jela.get(i).getImeJela().toUpperCase() + " - " + jela.get(i).getOpisJela());
        }


        JList<String> listaRecepata = new JList<>(lista);
        listaRecepata.setBounds(50, 50, 1000, 100);

        receptiFrame.add(listaRecepata);
        receptiFrame.add(vidiReceptButton);

        receptiFrame.setSize(1100, 450);
        receptiFrame.setLayout(null);
        receptiFrame.setVisible(true);

        JLabel imeJela = new JLabel();
        imeJela.setSize(1000, 100);
        imeJela.setBackground(Color.WHITE);
        imeJela.setOpaque(true);
        imeJela.setBounds(50, 160, 1000,50);
        receptiFrame.add(imeJela);
        imeJela.setVisible(false);

        vidiReceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (listaRecepata.getSelectedIndex() != -1) {
                    data = "Recept za jelo: " + listaRecepata.getSelectedValue();
                    imeJela.setText(data);
                    imeJela.setVisible(true);
                }
               // imeJela.setText(data);
            }
        });
    }


    public static void main(String args[]) {
        new ReceptiWindow();
    }

}
