package onlineKuharica.GUI;

import onlineKuharica.Kuhar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener {

    // Login panel
    JPanel loginPanel;

    // Label - polja za unos i nazivi polja
    JLabel imeLabel, prezimeLabel, passwordLabel, message;
    JTextField imeField;
    JTextField prezimeField;
    JPasswordField passwordField;
    JButton loginButton, cancel;

    public LoginWindow() {
        // Labeli
        imeLabel = new JLabel();
        imeLabel.setText("Ime:");
        prezimeLabel = new JLabel();
        prezimeLabel.setText("Prezime:");
        imeField = new JTextField();
        prezimeField = new JTextField();

        // Password
        passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        passwordField = new JPasswordField();

        // Login dugme
        loginButton = new JButton("Login");

        loginPanel = new JPanel(new GridLayout(4, 1));
        loginPanel.add(imeLabel);
        loginPanel.add(imeField);
        loginPanel.add(prezimeLabel);
        loginPanel.add(prezimeField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        message = new JLabel();
        loginPanel.add(message);
        loginPanel.add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components
        loginButton.addActionListener(this);
        add(loginPanel, BorderLayout.CENTER);
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
            message.setText("Korisnik: " + kuhar.getIme() + " " + kuhar.getPrezime() + " uspješno logovan!");
            KuharWindow kuharWindow = new KuharWindow(kuhar);
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            message.setText("Korisnik ne postoji!");
        }
    }
}
