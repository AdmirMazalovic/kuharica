package onlineKuharica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("Button Example");
        final JTextField tf = new JTextField();
        tf.setBounds(50,50, 150,20);
        Icon loginIcon = new ImageIcon("C:\\Users\\Admir Mazalovic\\IdeaProjects\\online_kuharica\\src\\onlineKuharica\\slike\\loginButton.png");
        JButton b = new JButton();
        b.setIcon(loginIcon);
        b.setBounds(50,100,95,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Kuhar kuhar = new Kuhar();
                kuhar = kuhar.getKuharForLogin("Admir", "Mazalović", "admir0000");
                tf.setText(kuhar.getIme() + " " + kuhar.getPrezime());
            }
        });
        f.add(b);f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
