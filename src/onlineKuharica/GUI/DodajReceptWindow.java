package onlineKuharica.GUI;

import onlineKuharica.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DodajReceptWindow extends JFrame {
    private BufferedImage backgroundImage = ImageIO.read(new File("C:\\Users\\Admir Mazalovic\\IdeaProjects\\online_kuharica\\src\\onlineKuharica\\GUI\\welcomeScreenPhoto2.jpg"));
    private Color colorOldLace = new Color(253, 245, 230);
    private static Integer dodajNamirnicuTabelaHeight = 16;

    public DodajReceptWindow() throws IOException {
        JFrame dodajReceptiFrame = new JFrame();
        dodajReceptiFrame.setContentPane(new ImagePanel(backgroundImage));
        dodajReceptiFrame.setSize(1200, 800);

        // Dropdown lista svih kuhinja koje je moguce odabrati za jelo
        Kuhinja kuhinja = new Kuhinja();
        ArrayList<Kuhinja> kuhinje = kuhinja.getAllKuhinja();
        ArrayList<String> imenaKuhinja = new ArrayList<>();
        kuhinje.forEach(kuhinja1 -> imenaKuhinja.add(kuhinja1.getImeKuhinje()));
        String[] imenaKuhinjaArray = new String[imenaKuhinja.size()];
        // Konverzija array liste u array
        for (int i = 0; i < imenaKuhinja.size(); i++) {
            imenaKuhinjaArray[i] = imenaKuhinja.get(i);
        }
        JComboBox<String> kuhinjeList = new JComboBox<>(imenaKuhinjaArray);


        // Dropdown lista svih vrsta jela koje je moguce odabrati za jelo
        VrstaJela vrstaJela = new VrstaJela();
        ArrayList<VrstaJela> vrsteJela = vrstaJela.getAllVrstaJela();
        ArrayList<String> imenaVrstaJela = new ArrayList<>();
        vrsteJela.forEach(vrstaJela1 -> imenaVrstaJela.add(vrstaJela1.getVrsta_jela()));
        String[] imenaVrstaJelaArray = new String[imenaVrstaJela.size()];
        for (int i = 0; i < imenaVrstaJela.size(); i++) {
            imenaVrstaJelaArray[i] = imenaVrstaJela.get(i);
        }
        JComboBox<String> vrstaJelaList = new JComboBox<>(imenaVrstaJelaArray);

        // Dropdown lista za tezinu pripreme
        String[] tezinaPripreme = {TezinaPripreme.LAKO.toString(), TezinaPripreme.SREDNJE.toString(), TezinaPripreme.TESKO.toString()};
        JComboBox<String> tezinaPripremeList = new JComboBox<>(tezinaPripreme);

        // Dropdown lista svih vrsta namirnica koje je moguce odabrati za jelo
        VrstaNamirnice vrstaNamirnice = new VrstaNamirnice();
        ArrayList<VrstaNamirnice> vrsteNamirnica = vrstaNamirnice.getAllVrstaNamirnice();
        ArrayList<String> imenaVrstaNarminica = new ArrayList<>();
        vrsteNamirnica.forEach(vrstaNamirnice1 -> imenaVrstaNarminica.add(vrstaNamirnice1.getImeVrste()));
        String[] imenaVrstaNamirnicaArray = new String[imenaVrstaNarminica.size()];
        for (int i = 0; i < imenaVrstaNarminica.size(); i++) {
            imenaVrstaNamirnicaArray[i] = imenaVrstaNarminica.get(i);
        }
        JComboBox<String> vrsteNamirnicaList = new JComboBox<>(imenaVrstaNamirnicaArray);

        // Dropdown lista za mjernu jedinicu namirnice
        String[] mjerneJediniceArray = {
                MjernaJedinica.GRAM.getName(),
                MjernaJedinica.DEKAGRAM.getName(),
                MjernaJedinica.KILOGRAM.getName(),
                MjernaJedinica.MILILITAR.getName(),
                MjernaJedinica.DECILITAR.getName(),
                MjernaJedinica.LITAR.getName()
        };
        JComboBox<String> mjerneJediniceList = new JComboBox<>(mjerneJediniceArray);

        // Polja za unos podataka za jelo
        // pozicija labela i text field-ova
        int yLabelDefaultPosition = 50;
        int xLabelDefaultPosition = 50;
        int labelDefaultWidth = 300;
        int labelDefaultHight = 30;
        int xTextFieldDefaultPosition = 300;
        int yTextFieldDefaultPosition = 50;
        int textFieldDefaultWidth = 140;
        int textFieldDefaultHight = 30;

        // ime jela
        JLabel imeJelaLabel = new JLabel();
        imeJelaLabel.setText("<html><p><b><font size = \"5\" color = \"white\">Ime jela </p></html>");
        JTextField imeJelaTextField = new JTextField();
        imeJelaLabel.setBounds(xLabelDefaultPosition, yLabelDefaultPosition, labelDefaultWidth, labelDefaultHight);
        imeJelaTextField.setBounds(xTextFieldDefaultPosition, yTextFieldDefaultPosition, 400, textFieldDefaultHight);
        dodajReceptiFrame.add(imeJelaLabel);
        dodajReceptiFrame.add(imeJelaTextField);

        // Kratak opis jela
        JLabel opisJelaLabel = new JLabel();
        opisJelaLabel.setText("<html><p><b><font size = \"5\" color = \"white\">Opis jela </p></html>");
        yLabelDefaultPosition += 50;
        yTextFieldDefaultPosition += 50;
        JTextField opisJelaTextField = new JTextField();
        opisJelaLabel.setBounds(xLabelDefaultPosition, yLabelDefaultPosition, labelDefaultWidth, labelDefaultHight);
        opisJelaTextField.setBounds(xTextFieldDefaultPosition, yTextFieldDefaultPosition, 700, textFieldDefaultHight);
        dodajReceptiFrame.add(opisJelaLabel);
        dodajReceptiFrame.add(opisJelaTextField);

        // Vrsta kuhinje
        JLabel kuhinjaLabel = new JLabel();
        kuhinjaLabel.setText("<html><p><b><font size = \"5\" color = \"white\">Kuhinja</p></html>");
        yLabelDefaultPosition += 50;
        yTextFieldDefaultPosition += 50;
        kuhinjaLabel.setBounds(xLabelDefaultPosition, yLabelDefaultPosition, labelDefaultWidth, labelDefaultHight);
        kuhinjeList.setBounds(xTextFieldDefaultPosition, yTextFieldDefaultPosition, textFieldDefaultWidth, textFieldDefaultHight);
        dodajReceptiFrame.add(kuhinjaLabel);
        dodajReceptiFrame.add(kuhinjeList);

        // Vrsta jela
        JLabel vrstaJelaLabel = new JLabel();
        vrstaJelaLabel.setText("<html><p><b><font size = \"5\" color = \"white\">Vrsta jela</p></html>");
        yLabelDefaultPosition += 50;
        yTextFieldDefaultPosition += 50;
        vrstaJelaLabel.setBounds(xLabelDefaultPosition, yLabelDefaultPosition, labelDefaultWidth, labelDefaultHight);
        vrstaJelaList.setBounds(xTextFieldDefaultPosition, yTextFieldDefaultPosition, textFieldDefaultWidth, textFieldDefaultHight);
        dodajReceptiFrame.add(vrstaJelaLabel);
        dodajReceptiFrame.add(vrstaJelaList);

        // Tezina pripreme
        JLabel tezinaPripremeLabel = new JLabel();
        tezinaPripremeLabel.setText("<html><p><b><font size = \"5\" color = \"white\">Težina pripreme</p></html>");
        yLabelDefaultPosition += 50;
        yTextFieldDefaultPosition += 50;
        tezinaPripremeLabel.setBounds(xLabelDefaultPosition, yLabelDefaultPosition, labelDefaultWidth, labelDefaultHight);
        tezinaPripremeList.setBounds(xTextFieldDefaultPosition, yTextFieldDefaultPosition, textFieldDefaultWidth, textFieldDefaultHight);
        dodajReceptiFrame.add(tezinaPripremeLabel);
        dodajReceptiFrame.add(tezinaPripremeList);

        // Trajanje pripreme
        JLabel trajanjePripremeLabel = new JLabel();
        trajanjePripremeLabel.setText("<html><p><b><font size = \"5\" color = \"white\">Trajanje pripreme (hh:mm)</p></html>");
        JTextField trajanjePripremeTextField = new JTextField();
        yLabelDefaultPosition += 50;
        yTextFieldDefaultPosition += 50;
        trajanjePripremeLabel.setBounds(xLabelDefaultPosition, yLabelDefaultPosition, labelDefaultWidth, labelDefaultHight);
        trajanjePripremeTextField.setBounds(xTextFieldDefaultPosition, yTextFieldDefaultPosition, textFieldDefaultWidth, textFieldDefaultHight);
        dodajReceptiFrame.add(trajanjePripremeLabel);
        dodajReceptiFrame.add(trajanjePripremeTextField);

        // Broj osoba
        JLabel brojOsobaLabel = new JLabel();
        brojOsobaLabel.setText("<html><p><b><font size = \"5\" color = \"white\">Broj osoba</p></html>");
        JTextField brojOsobaTextField = new JTextField();
        yLabelDefaultPosition += 50;
        yTextFieldDefaultPosition += 50;
        brojOsobaLabel.setBounds(xLabelDefaultPosition, yLabelDefaultPosition, labelDefaultWidth, labelDefaultHight);
        brojOsobaTextField.setBounds(xTextFieldDefaultPosition, yTextFieldDefaultPosition, textFieldDefaultWidth, textFieldDefaultHight);
        dodajReceptiFrame.add(brojOsobaLabel);
        dodajReceptiFrame.add(brojOsobaTextField);

        // Opis pripreme
        JLabel opisPripremeLabel = new JLabel();
        opisPripremeLabel.setText("<html><p><b><font size = \"5\" color = \"white\">Opis pripreme</p></html>");
        JTextField opisPripremeTextField = new JTextField();
        //yLabelDefaultPosition += 50;
        //yTextFieldDefaultPosition += 50;
        opisPripremeLabel.setBounds(480, 150, labelDefaultWidth, labelDefaultHight);
        opisPripremeTextField.setBounds(480, 200, 520, 180);
        dodajReceptiFrame.add(opisPripremeLabel);
        dodajReceptiFrame.add(opisPripremeTextField);


        // Dodaj namirnicu sekcija
        JButton dodajSastojakButton = new JButton("Dodaj sastojak");
        yLabelDefaultPosition += 50;
        dodajSastojakButton.setBounds(xTextFieldDefaultPosition, yLabelDefaultPosition, 140, 30);
        dodajReceptiFrame.add(dodajSastojakButton);
        DefaultTableModel model = new DefaultTableModel();
        JTable dodajNamirnicuTabela = new JTable(model);
        dodajNamirnicuTabela.setBounds(480, yLabelDefaultPosition, 520, dodajNamirnicuTabelaHeight);
        model.addColumn("Ime namirnice");
        model.addColumn("Kolicina");
        model.addColumn("Mjerna jedinica");
        model.addColumn("Vrsta namirnice");
        model.addRow(new Object[]{
                "<html><p><b>Ime namirnice</p></html>",
                "<html><p><b>Količina</p></html>",
                "<html><p><b>Mjerna jedinica</p></html>",
                "<html><p><b>Vrsta namirnice</p></html>"
        });
        dodajReceptiFrame.add(dodajNamirnicuTabela);

        // Izbrisi namirnicu button
        JButton izbrisiNamirnicuButton = new JButton("Izbriši sastojak");
        izbrisiNamirnicuButton.setBounds(xTextFieldDefaultPosition, yLabelDefaultPosition + 50, 140, 30);
        dodajReceptiFrame.add(izbrisiNamirnicuButton);
        izbrisiNamirnicuButton.setVisible(false);

        // Snimi recept
        JButton snimiRecept = new JButton("Snimi recept");
        snimiRecept.setBounds(xTextFieldDefaultPosition, yLabelDefaultPosition + 100, 140, 30);
        dodajReceptiFrame.add(snimiRecept);
        snimiRecept.setVisible(false);


        int finalYLabelDefaultPosition = yLabelDefaultPosition;
        dodajSastojakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxBrojNamirnica = 21;
                if (model.getRowCount() <= maxBrojNamirnica) {
                    dodajNamirnicuTabelaHeight = dodajNamirnicuTabelaHeight + 16;
                    dodajNamirnicuTabela.setBounds(480, finalYLabelDefaultPosition, 520, dodajNamirnicuTabelaHeight);
                    model.addRow(new Object[]{"", "", "", ""});
                    dodajNamirnicuTabela.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(vrsteNamirnicaList));
                    dodajNamirnicuTabela.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(mjerneJediniceList));
                    izbrisiNamirnicuButton.setVisible(true);
                    snimiRecept.setVisible(true);
                }
            }
        });


        snimiRecept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String selectedBook = (String) kuhinjeList.getSelectedItem();
//                System.out.println("You seleted the book: " + selectedBook);
            }
        });

        izbrisiNamirnicuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = dodajNamirnicuTabela.getSelectedRow();
                if(selectedRow!= 0) {
                    try {
                        model.removeRow(selectedRow);
                        dodajNamirnicuTabelaHeight = dodajNamirnicuTabelaHeight - 16;
                        dodajNamirnicuTabela.setBounds(480, finalYLabelDefaultPosition, 520, dodajNamirnicuTabelaHeight);
                    } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                        ex.printStackTrace();
                    }
                }
                if (model.getRowCount() <= 1) {
                    izbrisiNamirnicuButton.setVisible(false);
                    snimiRecept.setVisible(false);
                }
            }
        });

        dodajReceptiFrame.setVisible(true);
    }

    public static void main(String args[]) throws IOException {
        new DodajReceptWindow();
    }
}
