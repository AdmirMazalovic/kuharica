package onlineKuharica.gui;

import onlineKuharica.java.Kuhar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;

class RegisterWindow extends JFrame {
    private JTextField imeField;
    private JTextField prezimeField;
    private JTextField emailField;
    private JTextField datumRodjenjaField;
    private JTextField spolField;
    private JTextField drzavaField;
    private JTextField gradField;
    private JTextField zipField;
    private JTextField adresaField;
    private JTextField brojTelefonaField;
    private JTextField oMeniField;
    private JTextField passwordField;

    RegisterWindow() {
        //private JButton promijeniPassword;
        JLabel imeLabel = new JLabel();
        JLabel prezimeLabel = new JLabel();
        JLabel emailLabel = new JLabel();
        JLabel datumRodjenjaLabel = new JLabel();
        JLabel passwordLabel = new JLabel();
        JLabel potvrdiPasswordLabel = new JLabel();
        JLabel spolLabel = new JLabel();
        JLabel drzavaLabel = new JLabel();
        JLabel gradLabel = new JLabel();
        JLabel zipLabel = new JLabel();
        JLabel adresaLabel = new JLabel();
        JLabel brojTelefonaLabel = new JLabel();
        JLabel oMeniLabel = new JLabel();

        imeLabel.setText("Ime:");
        prezimeLabel.setText("Prezime:");
        emailLabel.setText("E-mail:");
        datumRodjenjaLabel.setText("Datum rođenja:");
        passwordLabel.setText("Password:");
        potvrdiPasswordLabel.setText("Potvrdi password");
        spolLabel.setText("Spol");
        drzavaLabel.setText("Država:");
        gradLabel.setText("Grad:");
        zipLabel.setText("Zip:");
        adresaLabel.setText("Adresa:");
        brojTelefonaLabel.setText("Broj telefona:");
        oMeniLabel.setText("O meni:");

        imeField = new JTextField();
        prezimeField = new JTextField();
        emailField = new JTextField();
        datumRodjenjaField = new JTextField();
        drzavaField = new JTextField();
        gradField = new JTextField();
        zipField = new JTextField();
        adresaField = new JTextField();
        brojTelefonaField = new JTextField();
        oMeniField = new JTextField();
        passwordField = new JTextField();
        JTextField potvrdiPasswordField = new JTextField();
        spolField = new JTextField();

        JButton snimiNovePodatkeButton = new JButton("Snimi");
        //promijeniPassword = new JButton("Promijeni password");

        JPanel registerPanel = new JPanel(new GridLayout(14, 1));
        registerPanel.add(imeLabel);
        registerPanel.add(imeField);
        registerPanel.add(prezimeLabel);
        registerPanel.add(prezimeField);
        registerPanel.add(emailLabel);
        registerPanel.add(emailField);
        registerPanel.add(datumRodjenjaLabel);
        registerPanel.add(datumRodjenjaField);
        registerPanel.add(spolLabel);
        registerPanel.add(spolField);
        registerPanel.add(drzavaLabel);
        registerPanel.add(drzavaField);
        registerPanel.add(gradLabel);
        registerPanel.add(gradField);
        registerPanel.add(zipLabel);
        registerPanel.add(zipField);
        registerPanel.add(adresaLabel);
        registerPanel.add(adresaField);
        registerPanel.add(brojTelefonaLabel);
        registerPanel.add(brojTelefonaField);
        registerPanel.add(oMeniLabel);
        registerPanel.add(oMeniField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(potvrdiPasswordLabel);
        registerPanel.add(potvrdiPasswordField);
        registerPanel.add(snimiNovePodatkeButton);

        //snimiNovePodatkeButton.addActionListener(this);
        add(registerPanel, BorderLayout.CENTER);
        setTitle("Moji podaci");
        setSize(400, 500);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        snimiNovePodatkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kuhar kuhar = new Kuhar(imeField.getText(),
                        prezimeField.getText(),
                        emailField.getText(),
                        passwordField.getText(),
                        spolField.getText().toCharArray()[0],
                        Date.valueOf(datumRodjenjaField.getText()),
                        drzavaField.getText(),
                        gradField.getText(),
                        Integer.parseInt(zipField.getText()),
                        adresaField.getText(),
                        brojTelefonaField.getText(),
                        oMeniField.getText()
                );
                Kuhar newKuhar = kuhar.addKuhar(kuhar);
                try {
                    WelcomeScreen welcomeScreen = new WelcomeScreen(newKuhar);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
