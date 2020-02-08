package onlineKuharica;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        VrstaJela vrstaJela = new VrstaJela();
//        Kuhar kuhar = new Kuhar();
//        ReceptPage receptPage= new ReceptPage();
//        receptPage = receptPage.getRecetById(2);
//        System.out.println(receptPage);
//        ArrayList<Namirnica> namirnice = new ArrayList<>();
//        Namirnica namirnica = new Namirnica();
//        namirnice = namirnica.getNamirniceByJeloIdDB(1);
//        System.out.println(namirnice);

        Recept recept = new Recept();
        recept = recept.getReceptByJeloId(1);
        System.out.println(recept.getOpisPipreme());
    }
}
