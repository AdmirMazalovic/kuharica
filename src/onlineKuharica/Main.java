package onlineKuharica;

public class Main {
    public static void main(String[] args) {
        VrstaJela vrstaJela = new VrstaJela();

        vrstaJela = vrstaJela.getVrstaJelaById(3);
 //       vrstaJela = vrstaJela.getVrstaJelaByName("Deserti");
     //   vrstaJela = vrstaJela.getVrstaJelaById(1);
        System.out.println(vrstaJela.getVrsta_jela());
//        System.out.println(vrstaJela.getVrsta_jela_id());
//        VrstaJela dodanaVrstaJela = vrstaJela.addVrstaJela("X");
//        System.out.println(dodanaVrstaJela.getVrsta_jela());
//        System.out.println(dodanaVrstaJela.getVrsta_jela_id());
 //        vrstaJela.setVrsta_jela("testtest");
  //       vrstaJela.addVrstaJela(vrstaJela);
//            vrstaJela = vrstaJela.getVrstaJelaById(8);
//            System.out.println(vrstaJela.getVrsta_jela());
    }
}
