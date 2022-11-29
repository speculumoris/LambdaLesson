package lambdapractice01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda02 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println("ilkHarfBykSnraKucuk(list) = " + ilkHarfBykSnraKucuk(list));
        System.out.println("ilkHarfEvyaColnlar(list) = " + ilkHarfEvyaColnlar(list));
        System.out.println();
        basaSonaYildiz(list);
        System.out.println();
        System.out.println("icindeEolanlar(list) = " + icindeEolanlar(list));
        System.out.println();
        LleriSil(list);
        System.out.println();
        iknciHrfgroilk5(list);
    }
    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim
    public static  List<String> ilkHarfBykSnraKucuk( List<String> l){
       return l.
               stream().
               map(t -> t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
               collect(Collectors.toList());

    }
    // S2: ilk harfi e ve ya c olanlari listeleyelim
    public static  List<String> ilkHarfEvyaColnlar( List<String> l){
        return l.
                stream().
                filter(t->t.substring(0,1).equalsIgnoreCase("e")
                        ||t.substring(0,1).equalsIgnoreCase("c")).
                collect(Collectors.toList());
    }
    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static  void basaSonaYildiz( List<String> l){
        l.stream().map(t-> "*"+t+"*").forEach(Utils::yazString);
    }
    //S4 : icinde e olanlardan yeni bir list olusturunuz
    public static  List<String> icindeEolanlar( List<String> l){
       return l.stream().filter(t -> t.contains("e")).collect(Collectors.toList());
    }
    //S5: tum 'l' leri silelim yazdiralim
    public static  void LleriSil( List<String> l){
        l.stream().filter(t->t.contains("l")).map(t->t.replace("l","")).forEach(Utils::yazString);
    }
    //S6: List elemanarını 2.harfe gore sıralayıp
    //ilk 5 elemandan char sayısı en buyuk elemanı print
    public static  void iknciHrfgroilk5( List<String> l){
        System.out.println(l.
                stream().
                sorted(Comparator.comparing(t -> t.substring(1, 2))).
                limit(5).
                sorted(Comparator.comparing(String::length).reversed()).
                findFirst());

    }
}
