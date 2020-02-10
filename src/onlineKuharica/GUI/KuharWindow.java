package onlineKuharica.GUI;

import onlineKuharica.Kuhar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class KuharWindow extends JFrame {

    JPanel kuharPanel;
    JButton snimiNovePodatkeButton;
    JButton promijeniPassword;

    JLabel imeLabel, prezimeLabel, emailLabel, datumRodjenjaLabel, drzavaLabel, gradLabel,
            zipLabel, adresaLabel, brojTelefonaLabel, oMeniLabel;

    JTextField imeField, prezimeField, emailField, datumRodjenjaField,
            drzavaField, gradField, zipField, adresaField, brojTelefonaField, oMeniField;

    public KuharWindow(Kuhar kuhar) {
        imeLabel = new JLabel();
        prezimeLabel = new JLabel();
        emailLabel = new JLabel();
        datumRodjenjaLabel = new JLabel();
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

        snimiNovePodatkeButton = new JButton("Snimi");
        promijeniPassword = new JButton("Promijeni password");

        kuharPanel = new JPanel(new GridLayout(11, 1));
        kuharPanel.add(imeLabel);
        kuharPanel.add(imeField);
        kuharPanel.add(prezimeLabel);
        kuharPanel.add(prezimeField);
        kuharPanel.add(emailLabel);
        kuharPanel.add(emailField);
        kuharPanel.add(datumRodjenjaLabel);
        kuharPanel.add(datumRodjenjaField);
        kuharPanel.add(drzavaLabel);
        kuharPanel.add(drzavaField);
        kuharPanel.add(gradLabel);
        kuharPanel.add(gradField);
        kuharPanel.add(zipLabel);
        kuharPanel.add(zipField);
        kuharPanel.add(adresaLabel);
        kuharPanel.add(adresaField);
        kuharPanel.add(brojTelefonaLabel);
        kuharPanel.add(brojTelefonaField);
        kuharPanel.add(oMeniLabel);
        kuharPanel.add(oMeniField);
        kuharPanel.add(snimiNovePodatkeButton);
        kuharPanel.add(promijeniPassword);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //snimiNovePodatkeButton.addActionListener(this);
        add(kuharPanel, BorderLayout.CENTER);
        setTitle("Moji podaci");
        setSize(300, 300);
        setVisible(true);

        // Prikazi kuharove informacije
        showKuharInfo(kuhar);

        snimiNovePodatkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "Želite li snimiti izmjenjene podatke", "Snimi nove podatke!", JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == 0) {
                    // Pokupi tekst iz Fieldova i snimi nove podatke za kuhara
                    kuhar.setIme(imeField.getText());
                    kuhar.setPrezime(prezimeField.getText());
                    kuhar.setEmail(emailField.getText());
                    kuhar.setDatumRodjenja(Date.valueOf(datumRodjenjaField.getText()));
                    kuhar.setGrad(gradField.getText());
                    kuhar.setZip(Integer.parseInt(zipField.getText()));
                    kuhar.setAdresa(adresaField.getText());
                    kuhar.setBrojTelefona(brojTelefonaField.getText());
                    kuhar.setOmeni(oMeniField.getText());
                    kuhar.updateKuharInfo(kuhar);
                } else if (result == 1) {
                    showKuharInfo(kuhar);
                }
            }
        });

        promijeniPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    /**
     * Helper metoda koja ispisuje informacije o kuharu
     *
     * @param kuhar
     */
    private void showKuharInfo(Kuhar kuhar) {
        imeField.setText(kuhar.getIme());
        prezimeField.setText(kuhar.getPrezime());
        emailField.setText(kuhar.getEmail());
        datumRodjenjaField.setText(kuhar.getDatumRodjenja().toString());
        drzavaField.setText(kuhar.getDrzava());
        gradField.setText(kuhar.getGrad());
        zipField.setText(kuhar.getZip().toString());
        adresaField.setText(kuhar.getAdresa());
        brojTelefonaField.setText(kuhar.getBrojTelefona());
        oMeniField.setText(kuhar.getOmeni());
    }
}
