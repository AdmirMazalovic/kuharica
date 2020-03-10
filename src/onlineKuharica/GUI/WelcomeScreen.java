package onlineKuharica.GUI;

import onlineKuharica.Kuhar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WelcomeScreen extends JComponent {
    private static Kuhar kuhar;
    private BufferedImage backgroundImage = ImageIO.read(getClass().getResource("images/welcomeScreenPhoto.jpg"));

    public static Kuhar getKuhar() {
        return kuhar;
    }

    WelcomeScreen(Kuhar kuhar) throws IOException {
        this.kuhar = kuhar;
        JFrame welcomeScreenFrame = new JFrame();
        welcomeScreenFrame.setSize(1200, 800);
        welcomeScreenFrame.setContentPane(new ImagePanel(backgroundImage));

        JButton traziReceptButton = new JButton("Traži recepte");
        JButton dodajReceptButton = new JButton("Dodaj recept");
        JButton mojProfilButton = new JButton("Moj profil");
        JButton izadjiButton = new JButton("Izađi");
        traziReceptButton.setBounds(500, 200, 200, 50);
        dodajReceptButton.setBounds(500, 300, 200, 50);
        mojProfilButton.setBounds(500, 400, 200, 50);
        izadjiButton.setBounds(500, 500, 200, 50);
        welcomeScreenFrame.add(traziReceptButton);
        welcomeScreenFrame.add(dodajReceptButton);
        welcomeScreenFrame.add(mojProfilButton);
        welcomeScreenFrame.add(izadjiButton);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        welcomeScreenFrame.setLocation(dim.width/2-welcomeScreenFrame.getSize().width/2, dim.height/2-welcomeScreenFrame.getSize().height/2);

        welcomeScreenFrame.setVisible(true);
        traziReceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReceptiWindow receptiWindow = new ReceptiWindow();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        mojProfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KuharWindow kuharWindow = new KuharWindow(kuhar);
            }
        });

        dodajReceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DodajReceptWindow dodajReceptWindow = new DodajReceptWindow(kuhar);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        izadjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
