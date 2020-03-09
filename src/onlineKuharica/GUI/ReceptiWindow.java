package onlineKuharica.GUI;

import onlineKuharica.Jelo;
import onlineKuharica.Kuhar;
import onlineKuharica.Namirnica;
import onlineKuharica.Recept;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class ReceptiWindow extends JFrame {
    private BufferedImage backgroundImage = ImageIO.read(getClass().getResource("images/welcomeScreenPhoto2.jpg"));

    ReceptiWindow() throws IOException {
        Color colorOldLace  = new Color(253,245,230);

        Jelo jelo = new Jelo();
        ArrayList<Jelo> jela = jelo.getAllJelo();
        int brojJela = jela.size();

        JFrame receptiFrame = new JFrame();
        receptiFrame.setContentPane(new ImagePanel(backgroundImage));

        JButton vidiReceptButton = new JButton("Prikaži recept");
        vidiReceptButton.setBounds(910, 160, 140, 30);
        DefaultListModel<String> listaJela = new DefaultListModel<>();
        for (int i = 0; i < brojJela; i++) {
            listaJela.addElement(jela.get(i).getImeJela().toUpperCase() + " - " + jela.get(i).getOpisJela());
        }

        // scroll panel u koji ce biti dodana lista recepata
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 50, 1000, 100);
        scrollPane.setBackground(colorOldLace);

        JList<String> listaRecepata = new JList<>(listaJela);
        listaRecepata.setBackground(colorOldLace);
        scrollPane.setViewportView(listaRecepata);
        receptiFrame.add(scrollPane);
        receptiFrame.add(vidiReceptButton);

        receptiFrame.setSize(1200, 800);
        receptiFrame.setLayout(null);

        // Postavi receptiFrame na sredinu displaya pri prikazu
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        receptiFrame.setLocation(dim.width/2-receptiFrame.getSize().width/2, dim.height/2-receptiFrame.getSize().height/2);
        receptiFrame.setVisible(true);

        JLabel imeJela = new JLabel();
        imeJela.setSize(1000, 100);

        imeJela.setBackground(colorOldLace);
        imeJela.setOpaque(true);
        imeJela.setBounds(50, 200, 1000, 40);
        receptiFrame.add(imeJela);
        imeJela.setVisible(false);

        DefaultTableModel model = new DefaultTableModel();
        JTable prikazRecepta = new JTable(model);
        prikazRecepta.setShowGrid(false);
        prikazRecepta.setShowHorizontalLines(true);
        prikazRecepta.setGridColor(colorOldLace);
        model.addColumn("Col1");
        model.addColumn("Col2");
        int firstColumnWidth = 170;
        int secondColumnWidth = 830;
        prikazRecepta.getColumnModel().getColumn(0).setMaxWidth(firstColumnWidth);
        DefaultTableCellRenderer firstColumnRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer secondColumnRender = new DefaultTableCellRenderer();

        firstColumnRender.setBackground(colorOldLace);
        firstColumnRender.setVerticalAlignment(JLabel.TOP);
        secondColumnRender.setVerticalAlignment(JLabel.TOP);

        prikazRecepta.getColumnModel().getColumn(0).setCellRenderer(firstColumnRender);
        prikazRecepta.getColumnModel().getColumn(1).setMaxWidth(secondColumnWidth);
        prikazRecepta.getColumnModel().getColumn(1).setCellRenderer(secondColumnRender);

        prikazRecepta.setSize(1000, 1000);
        prikazRecepta.setBackground(Color.WHITE);
        prikazRecepta.setOpaque(true);
        prikazRecepta.setBounds(50, 245, 1000, 500);
        receptiFrame.add(prikazRecepta);
        prikazRecepta.setVisible(false);

        vidiReceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                int numberOfrows = model.getRowCount();

                // izbrisi podatke za prethodno ispisan recept
                while (numberOfrows > 0) {
                    model.removeRow(numberOfrows - 1);
                    numberOfrows--;
                }

                // ispisi podatke za odabrani recept
                if (listaRecepata.getSelectedIndex() != -1) {
                    data = "Recept za jelo: " + listaRecepata.getSelectedValue();
                    imeJela.setText(data);
                    imeJela.setVisible(true);

                    int jeloIndex = listaRecepata.getSelectedIndex();
                    Jelo jeloZaRecept = jela.get(jeloIndex);

                    Recept recept = new Recept();
                    recept = recept.getReceptByJeloId(jeloZaRecept.getJeloId());
                    Kuhar autorJela = new Kuhar();
                    autorJela = autorJela.getKuharById(jeloZaRecept.getKuharId());
                    Namirnica namirnica = new Namirnica();
                    ArrayList<Namirnica> namirnice = namirnica.getNamirniceByJeloIdDB(jeloZaRecept.getJeloId());

                    model.addRow(new Object[]{"Autor jela: ", autorJela.getIme() + " " + autorJela.getPrezime()});
                    model.addRow(new Object[]{"Trajanje pripreme: ", jeloZaRecept.getTrajanjePripreme()});
                    model.addRow(new Object[]{"Broj osoba: ", jeloZaRecept.getBrojOsoba()});
                    model.addRow(new Object[]{"Tezina pripreme: ", jeloZaRecept.getTezinaPripreme()});
                    model.addRow(new Object[]{"Datum objave: ", recept.getDatumObjave()});
                    model.addRow(new Object[]{"", ""});

                    String sastojci = "<html><p>";
                    for (Namirnica it : namirnice) {
                        sastojci = sastojci + it.getKolicina() + " " + it.getMjernaJedinica() + " " +it.getImeNamirnice() +"<br>";
                    }
                    sastojci = sastojci + "</p></html>";

                    model.addRow(new Object[]{"Sastojci:", sastojci});
                    model.addRow(new Object[]{"Opis pripreme:", "<html>" + recept.getOpisPipreme() + "</html>"});
                    prikazRecepta.setRowHeight(7, 200);
                    prikazRecepta.setRowHeight(6, 200);

                    prikazRecepta.setVisible(true);
                }
            }
        });
    }

    public static void main(String args[]) throws IOException {
        new ReceptiWindow();
    }

}
