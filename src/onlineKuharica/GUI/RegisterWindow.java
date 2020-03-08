package onlineKuharica.GUI;

import onlineKuharica.Kuhar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class RegisterWindow extends JFrame {
    private JPanel registerPanel;
    private JButton snimiNovePodatkeButton;
    //private JButton promijeniPassword;
    private JLabel imeLabel, prezimeLabel, emailLabel, datumRodjenjaLabel, drzavaLabel, gradLabel, spolLabel,
            zipLabel, adresaLabel, brojTelefonaLabel, oMeniLabel, passwordLabel, potvrdiPasswordLabel;
    private JTextField imeField, prezimeField, emailField, datumRodjenjaField, spolField,
            drzavaField, gradField, zipField, adresaField, brojTelefonaField, oMeniField, passwordField, potvrdiPasswordField;


    public RegisterWindow() {
        this.imeLabel = new JLabel();
        prezimeLabel = new JLabel();
        emailLabel = new JLabel();
        datumRodjenjaLabel = new JLabel();
        passwordLabel = new JLabel();
        potvrdiPasswordLabel = new JLabel();
        spolLabel = new JLabel();
        drzavaLabel = new JLabel();
        gradLabel = new JLabel();
        zipLabel = new JLabel();
        adresaLabel = new JLabel();
        brojTelefonaLabel = new JLabel();
        oMeniLabel = new JLabel();

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
        potvrdiPasswordField = new JTextField();
        spolField = new JTextField();

        snimiNovePodatkeButton = new JButton("Snimi");
        //promijeniPassword = new JButton("Promijeni password");

        registerPanel = new JPanel(new GridLayout(14, 1));
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

       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //snimiNovePodatkeButton.addActionListener(this);
        add(registerPanel, BorderLayout.CENTER);
        setTitle("Moji podaci");
        setSize(400, 500);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

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
                try{
                    WelcomeScreen welcomeScreen = new WelcomeScreen(newKuhar);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

}
