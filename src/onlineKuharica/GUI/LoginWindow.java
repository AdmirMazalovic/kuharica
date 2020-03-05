package onlineKuharica.GUI;

import onlineKuharica.Kuhar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener {
    Kuhar kuhar = new Kuhar();
    String imeKuhara = "";
    String prezimeKuhara = "";
    String password = "";
    // Login panel
    JPanel loginPanel;

    // Label - polja za unos i nazivi polja
    JLabel imeLabel, prezimeLabel, passwordLabel, message;
    JTextField imeField;
    JTextField prezimeField;
    JPasswordField passwordField;
    JButton loginButton, cancel;

    public Kuhar getLoginKuhar(){
        return this.kuhar;
    }
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

        // Pozicioniraj login panel na centar displaya
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginWindow();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        imeKuhara = imeField.getText();
        prezimeKuhara = prezimeField.getText();
        password = passwordField.getText();
        try {
            // Dohvati kuhara iz baze po imenu, prezimenu i passwordu. U slucaju da nema takvog kuhara,
            // dobit ce se No such element exception koju baci getKuharForLoginDB metoda
            kuhar = kuhar.getKuharForLogin(imeKuhara, prezimeKuhara, password);
            message.setText("Korisnik: " + kuhar.getIme() + " " + kuhar.getPrezime() + " uspješno logovan!");
            // Ako su podaci ispravni idi na korisnicki prozor
            setVisible(false);
           // KuharWindow kuharWindow = new KuharWindow(kuhar);
            WelcomeScreen welcomeScreen = new WelcomeScreen(kuhar);
        } catch (Exception e) {
            e.printStackTrace();
            message.setText("Korisnik ne postoji!");
        }
    }
}
