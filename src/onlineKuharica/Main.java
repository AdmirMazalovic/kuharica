package onlineKuharica;

import onlineKuharica.GUI.LoginWindow;

public class Main {
    public static void main(String[] args) {
//
//        JFrame f = new JFrame("Button Example");
//        final JTextField tf = new JTextField();
//        tf.setBounds(50,50, 150,20);
//        //b.setIcon(new ImageIcon("src/main/resources/slike/loginButton.png"));
//        Icon loginIcon = new ImageIcon("src/onlineKuharica/GUI/slike/loginButton.png");
//        JButton b = new JButton();
//        b.setIcon(loginIcon);
//        b.setBounds(50,100,95,30);
//        b.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                Kuhar kuhar = new Kuhar();
//                kuhar = kuhar.getKuharForLogin("Admir", "Mazalović", "admir0000");
//                tf.setText(kuhar.getIme() + " " + kuhar.getPrezime());
//            }
//        });
//        f.add(b);f.add(tf);
//        f.setSize(400,400);
//        f.setLayout(null);
//        f.setVisible(true);
        LoginWindow login = new LoginWindow();
    }
}
