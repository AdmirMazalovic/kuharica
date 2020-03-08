package onlineKuharica;

import onlineKuharica.GUI.LoginWindow;

import java.sql.Date;
import java.time.LocalDate;

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
        Jelo jelo = new Jelo(2, "Test", 2, 2, TezinaPripreme.LAKO.getTezinaPripeme(), "1:00", 4, "Opis jela");
        jelo.addJelo(jelo);
        Jelo jelo1 = jelo.getJeloByNameAndKuharId(jelo.getImeJela(), jelo.getKuharId());
        Recept recept = new Recept(jelo1.getJeloId(), "Opis");
        recept.addRecept(recept);
        Namirnica namirnica = new Namirnica(jelo1.getJeloId(), 2,"Namirnica za jelo", MjernaJedinica.KILOGRAM.toString(), (long)1.00);
        namirnica.addNamirnica(namirnica, 1);
      //  LoginWindow login = new LoginWindow();
    }
}
