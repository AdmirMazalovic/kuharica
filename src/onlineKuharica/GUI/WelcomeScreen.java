package onlineKuharica.GUI;

import onlineKuharica.Kuhar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomeScreen extends JComponent {
    private static Kuhar kuhar;

    public static Kuhar getKuhar() {
        return kuhar;
    }

    //LoginWindow loginWindow = new LoginWindow();
    private BufferedImage backgroundImage = ImageIO.read(new File("C:\\Users\\Admir Mazalovic\\IdeaProjects\\online_kuharica\\src\\onlineKuharica\\GUI\\welcomeScreenPhoto.jpg"));

    WelcomeScreen(Kuhar kuhar) throws IOException {
        this.kuhar = kuhar;
        JFrame welcomeScreenFrame = new JFrame();
        welcomeScreenFrame.setSize(1200, 800);
        welcomeScreenFrame.setContentPane(new ImagePanel(backgroundImage));

        JButton traziReceptButton = new JButton("Traži recepte");
        JButton dodajReceptButton = new JButton("Dodaj recept");
        JButton mojProfilButton = new JButton("Moj profil");
        traziReceptButton.setBounds(500, 200, 200, 50);
        dodajReceptButton.setBounds(500, 300, 200, 50);
        mojProfilButton.setBounds(500, 400, 200, 50);
//        try {
//            Image img = ImageIO.read(getClass().getResource("slike/loginButton.png"));
//            traziReceptButton.setIcon(new ImageIcon(img));
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

        welcomeScreenFrame.add(traziReceptButton);
        welcomeScreenFrame.add(dodajReceptButton);
        welcomeScreenFrame.add(mojProfilButton);

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
            //    RegisterWindow registerWindow = new RegisterWindow();
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
    }


    public static void main(String[] args) throws IOException {
        new WelcomeScreen(WelcomeScreen.getKuhar());
    }
}
