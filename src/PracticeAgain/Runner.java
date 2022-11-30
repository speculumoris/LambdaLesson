package PracticeAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Q01 name=new Q01();
        List<String> menu = new ArrayList<>(Arrays.asList("trilece","havuc","guvec","kokorec",
                "kusleme","arabAsı","waffle","kunefe","guvec"));
        University u01=new University("bogazici","matematik",571,93);
        University u02=new University("istanbul tk","matematik",600,81);
        University u03=new University("istanbul ","huku",1400,71);
        University u04=new University("marmara","bilg muh",1080,77);
        University u05=new University("odtu","gemi muh",333,74);
        List<University> unv=new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

      // Q01.ciftToplam(6);
      // Q01.ilkCiftToplam(4);
      // Q01.herhangiKuvvet(3,3);
      // System.out.println();
      // Q01.printerTekrrsz(menu);
      // System.out.println();
      // Q01.printerTekrrszTersElmik(menu);
      // System.out.println();
      // Q01.kcktenBuyukTekrrszTersElmik(menu);
      // System.out.println();
      // Q01.kcktenBuyuk7veyadegil(menu);
      // System.out.println();
      // Q01.wileBaslayanLar(menu);
      // System.out.println();
      // Q01.xileBitenEleman(menu);

        Q01.MatBolumleri(unv);

    }
}
