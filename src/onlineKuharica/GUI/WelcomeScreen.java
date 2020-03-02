package onlineKuharica.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomeScreen extends JComponent {
    private BufferedImage backgroundImage = ImageIO.read(new File("C:\\Users\\Admir Mazalovic\\IdeaProjects\\online_kuharica\\src\\onlineKuharica\\GUI\\welcomeScreenPhoto.jpg"));

    private WelcomeScreen() throws IOException {
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


//        JLabel welcomeScreenText= new JLabel("Online kuharica text");
//        welcomeScreenText.setText("<html> <font size=\"60\" color=\"white\"> Moja kuharica");
//        welcomeScreenText.setBounds(480, 500, 800, 80);
//        welcomeScreenFrame.add(welcomeScreenText);


        welcomeScreenFrame.setVisible(true);
    }


    public static void main(String[] args) throws IOException {
        new WelcomeScreen();
    }
}
