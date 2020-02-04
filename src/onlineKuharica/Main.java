package onlineKuharica;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VrstaJela vrstaJela = new VrstaJela();
        Kuhar kuhar = new Kuhar();
//
////        kuhar = kuhar.getKuharById(3);
////        kuhar.setIme("PERO");
////        kuhar = kuhar.updateKuharInfo(kuhar);
////        kuhar.setPassword("11111");
////        kuhar = kuhar.updateKuharPassword(kuhar);
//        kuhar.setDrzava("BiH");
//        kuhar.setIme("TestIme");
//        kuhar.setPrezime("TesetPrezime");
//        kuhar.setEmail("e@mail");
//        kuhar = kuhar.addKuhar(kuhar);
//        System.out.println(kuhar);
//        LocalDate locald = LocalDate.of(1967, 06, 22);
//        Date date = Date.valueOf(locald);
        Kuhar kuhar1 = new Kuhar("ime",
                "Prezime",
                "emailemail@email.com",
                "111aaaa",
                'M',
                Date.valueOf(LocalDate.now()),
                "USA",
                "New York",
                11111,
                "address",
                "00000000",
                "this is about me");
        kuhar1.addKuhar(kuhar1);
        kuhar = kuhar.getKuharById(5);
//        Kuhar kuhar2 = new Kuhar();
//        kuhar2.setKuharId(2);
 //       System.out.println(kuhar2.deleteKuhar(kuhar2));
        ArrayList<Kuhar> kuhari = kuhar.getAllKuhar();
        System.out.println(kuhari);

        Jelo jelo = new Jelo();
        ArrayList<Jelo> jela = jelo.getAllJelaByKuharId(4);
        System.out.println(jela);
    }
}
