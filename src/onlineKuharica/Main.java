package onlineKuharica;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        VrstaJela vrstaJela = new VrstaJela();
        Kuhar kuhar = new Kuhar();

        //       vrstaJela = vrstaJela.getVrstaJelaById(3);
        //       vrstaJela = vrstaJela.getVrstaJelaByName("Deserti");
        //   vrstaJela = vrstaJela.getVrstaJelaById(1);
//        System.out.println(vrstaJela.getVrsta_jela());
//        System.out.println(vrstaJela.getVrsta_jela_id());
//        VrstaJela dodanaVrstaJela = vrstaJela.addVrstaJela("X");
//        System.out.println(dodanaVrstaJela.getVrsta_jela());
//        System.out.println(dodanaVrstaJela.getVrsta_jela_id());
//         vrstaJela.setVrsta_jela("testtest");
//         vrstaJela.addVrstaJela(vrstaJela);
//            vrstaJela = vrstaJela.getVrstaJelaById(8);
//            System.out.println(vrstaJela.getVrsta_jela());
        kuhar = kuhar.getKuharForLogin("Ana", "Anić", "ana0000");
        //kuhar = kuhar.getKuharByName("Pero");
       // System.out.println(kuhar.getBrojTelefona());
        kuhar.setIme("AnaUpdated");
        kuhar.updateKuharInfo(kuhar);
//        kuhar.setDrzava("BiH");
//        kuhar.setIme("TestIme");
//        kuhar.setPrezime("TesetPrezime");
//        kuhar.setEmail("e@mail");
//        kuhar = kuhar.addKuhar(kuhar);
//        System.out.println(kuhar);
//        LocalDate locald = LocalDate.of(1967, 06, 22);
//        Date date = Date.valueOf(locald);
//        Kuhar kuhar1 = new Kuhar("ime",
//                "Prezime",
//                "emailemail@email.com",
//                "111aaaa",
//                'M',
//                date,
//                "USA",
//                "New York",
//                11111,
//                "address",
//                "00000000",
//                "this is about me");
//        kuhar1.addKuhar(kuhar1);
    }
}
