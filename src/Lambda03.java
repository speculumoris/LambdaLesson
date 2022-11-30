import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trilece","havucDilim","guvec","kokorec",
                "kusleme","arabAsı","waffle","kunefe","guvec"));

        alfBykTekrsz(menu);
        System.out.println("\n=====================");
        chrSayisiByksirali(menu);
        System.out.println("\n=====================");
        tersSrlTkrrsizCNum(menu);
        System.out.println("\n=====================");
        harfSayisi7denAzkontrol(menu);
        System.out.println("\n=====================");
        wIleBaslayanElKontrol(menu);
        System.out.println("\n=====================");
        xIleBitenElemanKontrol(menu);
        System.out.println("\n=====================");
        charSayisiEnbykElPrint(menu);
        System.out.println("\n=====================");
        ilkElHrcSonHrfSrla(menu);
    }
    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrsz(List<String> yemek){
        yemek.
                    stream().
                    map(String::toUpperCase).
                    sorted().
                    distinct().
                    forEach(t -> System.out.print(t+" "));
    }
    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static  void tersSrlTkrrsizCNum(List<String> yemek){
        yemek.
                stream().
                map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(Lambda01::yazdir);
    }
    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiByksirali(List<String>ikram){
        ikram.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t-> System.out.print(t+" "));
    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzkontrol(List<String>ikram){
        System.out.println(ikram.
                stream().
                allMatch(t -> (t.length() <= 7)) ? ("list elemanlari 7 ve daha az harfden olusuyor") :
                ("list elemanlarinin uzunlugu 7 harfden buyuk"));

    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String>ikram){
        System.out.println(ikram.
                stream().
                noneMatch(t -> (t.startsWith("w"))) ? "w ile yemek ismi mi olur " :
                        "w ile yemek icat ettik");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenElemanKontrol(List<String>ikram){
        System.out.println(ikram.stream().anyMatch(t -> t.endsWith("x")) ? "maşallah" : "x ile yemek ismi mi biter");
    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiEnbykElPrint(List<String>ikram){
        Stream<String> sonIsim=ikram.
                stream().
                sorted(Comparator.comparing(t->t.toString().length()).reversed()).//karakter sayisina göre tersten siralandi
                limit(1);//Limit methodu kullanilarak sadece ilk eleman cagrildi
                                //limit methodunun donen degeri Stream<String> yapidadir
        System.out.println(Arrays.toString(sonIsim.toArray()));
        //sonisim.ToAraay() --> Stream olan akis array'e cevrildi
        // Arrays.toString(sonIsim.toArray()) __> Array'i String yapiya ceviriyor

    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHrcSonHrfSrla(List<String>ikram){
        ikram.stream().sorted(Comparator.comparing(t -> t.charAt(t.length()-1))).skip(1).forEach(t -> System.out.print(t+" "));
    }
}
