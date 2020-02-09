package onlineKuharica.GUI;

import onlineKuharica.Kuhar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener {

    // Login panel
    JPanel panel;

    // Label - polja za unos i nazivi polja
    JLabel imeLabel, prezimeLabel, passwordLabel, message;
    JTextField imeField;
    JTextField prezimeField;
    JPasswordField passwordField;
    JButton submit, cancel;

    public LoginWindow() {
        // User Label
        imeLabel = new JLabel();
        imeLabel.setText("Ime :");
        prezimeLabel = new JLabel();
        prezimeLabel.setText("Prezime");
        imeField = new JTextField();
        prezimeField = new JTextField();

        // Password
        passwordLabel = new JLabel();
        passwordLabel.setText("Password :");
        passwordField = new JPasswordField();

        // Login dugme
        submit = new JButton("LogIn");

        panel = new JPanel(new GridLayout(4, 1));


        panel.add(imeLabel);
        panel.add(imeField);
        panel.add(prezimeLabel);
        panel.add(prezimeField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Login in u Online Kuharica");
        setSize(350, 150);
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginWindow();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String imeKuhara = imeField.getText();
        String prezimeKuhara = prezimeField.getText();
        String password = passwordField.getText();
        Kuhar kuhar = new Kuhar();
        try {
            // Dohvati kuhara iz baze po imenu, prezimenu i passwordu. U slucaju da nema takvog kuhara,
            // dobit ce se No such element exception koju baci getKuharForLoginDB metoda
            kuhar = kuhar.getKuharForLogin(imeKuhara, prezimeKuhara, password);
            message.setText("Korisnik:  " + kuhar.getIme() + " " + kuhar.getPrezime() + " uspješno logovan!");
        } catch (Exception e) {
            e.printStackTrace();
            message.setText("Korisnik ne postoji!");
        }
    }
}
