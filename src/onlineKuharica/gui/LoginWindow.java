package onlineKuharica.gui;

import onlineKuharica.java.Kuhar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private Kuhar kuhar = new Kuhar();
    private String imeKuhara = "";
    private String prezimeKuhara = "";
    private String password = "";
    private JLabel message;
    private JTextField imeField;
    private JTextField prezimeField;
    private JPasswordField passwordField;

    public Kuhar getLoginKuhar() {
        return this.kuhar;
    }

    private LoginWindow() {
        // Login panel
        JPanel loginPanel = new JPanel(new GridLayout(5, 1));

        // Label - polja za unos i nazivi polja
        JLabel imeLabel = new JLabel();
        imeLabel.setText("Ime:");
        JLabel prezimeLabel = new JLabel();
        prezimeLabel.setText("Prezime:");
        imeField = new JTextField();
        prezimeField = new JTextField();

        // Password
        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        passwordField = new JPasswordField();

        loginPanel.add(imeLabel);
        loginPanel.add(imeField);
        loginPanel.add(prezimeLabel);
        loginPanel.add(prezimeField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        JButton loginButton = new JButton("Prijavi se");
        JButton registerButton = new JButton("Registriraj se");
        message = new JLabel();
        loginPanel.add(message);
        loginPanel.add(new JLabel(""));
        message.setText("Postani naš kuhar!");
        loginPanel.add(registerButton);
        loginPanel.add(loginButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imeKuhara = imeField.getText();
                prezimeKuhara = prezimeField.getText();
                password = passwordField.getText();
                try {
                    // Dohvati kuhara iz baze po imenu, prezimenu i passwordu. U slucaju da nema takvog kuhara,
                    // dobit ce se No such element exception koju baci getKuharForLoginDB metoda
                    kuhar = kuhar.getKuharForLogin(imeKuhara, prezimeKuhara, password);
                    message.setText("\"<html><p><font color=\"green\"> Korisnik: " + kuhar.getIme() + " " + kuhar.getPrezime() + " uspješno prijavljen!</html></p>");
                    // Ako su podaci ispravni idi na korisnicki prozor
                    setVisible(false);
                    // KuharWindow kuharWindow = new KuharWindow(kuhar);
                    WelcomeScreen welcomeScreen = new WelcomeScreen(kuhar);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    message.setText("<html><p><font color=\"red\">Korisnik ne postoji!</html></p>");
                }

            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterWindow registerWindow = new RegisterWindow();
            }
        });

        add(loginPanel, BorderLayout.CENTER);
        setTitle("Prijavi se u kuharicu");
        setSize(350, 200);

        // Pozicioniraj login panel na centar displaya
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}
