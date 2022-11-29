package lambdapractice01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda03 {
    public static void main(String[] args) {


        Apartman daire1 = new Apartman("dogu", 4000, 3);
        Apartman daire2 = new Apartman("bati", 2500, 2);
        Apartman daire3 = new Apartman("guney", 3500, 1);
        Apartman daire4 = new Apartman("dogu", 3000, 5);

        List<Apartman> kiralikDaireler = new ArrayList<>(Arrays.asList(daire1, daire2, daire3, daire4));
        doguKirayiSirala(kiralikDaireler);
        System.out.println("ikidenFazlaOlanDaireler(kiralikDaireler) = " + ikidenFazlaOlanDaireler(kiralikDaireler));
    }
    //dogu cephesindeki kiralık daireleri kiralarına göre sıralayın
    public static void doguKirayiSirala( List<Apartman>l){
        l.stream().
                filter(t -> t.getCephe().equalsIgnoreCase("dogu")).
                sorted(Comparator.comparing(Apartman::getKira)).forEach(System.out::println);
    }
    //kat sayısı 2den cok olan dairelerin kiralarını listeleyın
    public static List<Integer> ikidenFazlaOlanDaireler( List<Apartman>l){
       return l.stream().filter(t -> t.getKatSayisi()>2).map(t ->t.getKira()).collect(Collectors.toList());
    }
}
