package onlineKuharica.GUI;

import onlineKuharica.Kuhar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PasswordResetWindow extends JFrame {
    JPanel passwordEditPanel;
    JButton snimiButton;
    JPasswordField stariPasswordField, noviPasswordField, potvrdiNoviPasswordField;
    JLabel stariPasswordLabel, noviPasswordLabel, potvrdiNoviPasswordLabel;

    public PasswordResetWindow(Kuhar kuhar) {
        passwordEditPanel = new JPanel(new GridLayout(4, 1));
        snimiButton = new JButton("Snimi");
        stariPasswordField = new JPasswordField();
        potvrdiNoviPasswordField = new JPasswordField();
        noviPasswordField = new JPasswordField();
        stariPasswordLabel = new JLabel("Unesite trenutni password:");
        noviPasswordLabel = new JLabel("Novi password:");
        potvrdiNoviPasswordLabel = new JLabel("Potvrdite novi password:");
        passwordEditPanel.add(stariPasswordLabel);
        passwordEditPanel.add(stariPasswordField);
        passwordEditPanel.add(noviPasswordLabel);
        passwordEditPanel.add(noviPasswordField);
        passwordEditPanel.add(potvrdiNoviPasswordLabel);
        passwordEditPanel.add(potvrdiNoviPasswordField);
        passwordEditPanel.add(snimiButton);

        add(passwordEditPanel, BorderLayout.CENTER);
        setTitle("Promijeni password");
        setSize(400, 200);
        setVisible(true);

        snimiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Želite snimiti novi password?", "Snimi novi password!", JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == 0) {
                    if (kuhar.getPassword().equals(stariPasswordField.getText())) {
                        if (noviPasswordField.getText().equals(potvrdiNoviPasswordField.getText())) {
                            kuhar.setPassword(noviPasswordField.getText());
                            kuhar.updateKuharPassword(kuhar);
                            setVisible(false);

                        } else {
                            JOptionPane.showConfirmDialog(null,
                                    "Niste potvrdili novi password ili ste unijeli pogrešan password", "Potvrdite password!",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showConfirmDialog(null,
                                "Pogrešan stari password!", "Unesite ispravan password", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else if (result == 1) {
                    stariPasswordField.setText("");
                    noviPasswordField.setText("");
                    potvrdiNoviPasswordField.setText("");
                }
            }
        });
    }
}
