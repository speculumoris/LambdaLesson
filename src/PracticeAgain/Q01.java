package PracticeAgain;

import lambdapractice01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.ZipInputStream;

public class Q01 {
    List<Integer>intList=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    List<String> menu = new ArrayList<>(Arrays.asList("trilece","havucD","guvec","kokorec",
            "kusleme","arabAsı","waffle","kunefe","guvec"));
    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // Task 2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz
    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // Task-4 : list'in en buyuk elemanini yazdiriniz
    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    //*****************************
    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void printerTekrrsz( List<String> l){
        l.stream().sorted().distinct().forEach(t-> System.out.print(t+" "));
    }
    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void printerTekrrszTersElmik( List<String> l){
        l.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(t-> System.out.print(t+" "));
    }
    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void kcktenBuyukTekrrszTersElmik( List<String> l){
        l.stream().sorted(Comparator.comparing(String::length)).forEach(t-> System.out.print(t+" "));
    }
    // Task-4 : List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void kcktenBuyuk7veyadegil( List<String> l){
        System.out.println(l.stream().allMatch(t -> t.length() <= 7) ? "7'den kucuk veya esittir hepsi" : "arada bir tane yamuk var veya hepsi yamuk");
    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wileBaslayanLar( List<String> l){
        System.out.println(l.stream().noneMatch(t -> t.startsWith("w")) ? "bak yokmus" : "arada bir tane yamuk var");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xileBitenEleman( List<String> l){
        System.out.println(l.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten bir eleman var" : "helal hic x ile biten yok");
    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiEnBuyuk( List<String> l){
        l.stream().sorted(Comparator.comparing(String::length).reversed()).limit(1);
    }
    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGoreSiralam( List<String> l){
        l.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).skip(1).forEach(t-> System.out.println(t+" "));

    }
    //***************************
    //task 01--> butun univ'lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<University> unv){
        return unv.stream().allMatch(t-> t.getNotOrt()>74);
    }
    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean MatBolumSayisi(List<University> unv){
        return unv.stream().anyMatch(t->t.getBolum().contains("mat"));
    }
    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static void MatBolumleri(List<University> unv){
        unv.stream().filter(t->t.getBolum().equalsIgnoreCase("matematik")).
                forEach(t-> System.out.println(t+" "));
    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static void ogrSayisi550Dnfazla(List<University> unv){
        unv.stream().filter(t->t.getOgrSayisi()>550).mapToInt(University::getNotOrt).max();
    }
    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static void ogrSayisi1050denAz(List<University> unv){
        unv.stream().filter(t->t.getOgrSayisi()<1050).mapToInt(University::getNotOrt).min();
    }
    //***************************
    // 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.
    public static void printer(int i){
        IntStream.rangeClosed(1,i).sum();
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static void ciftToplam(int i){
        System.out.println(IntStream.rangeClosed(1, i).filter(t -> t % 2 == 0).sum());
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static void ilkCiftToplam(int i){
        System.out.println(IntStream.iterate(2, t -> t + 2).limit(i).sum());
    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static void ilkTekToplam(int i){
        System.out.println(IntStream.iterate(1, t -> t + 2).limit(i).sum());
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ilkCiftKuvet(int i){
        System.out.println(IntStream.iterate(2, t -> t * 2).limit(i).sum());
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void herhangiKuvvet(int istenen,int a){
       IntStream.iterate(istenen, t -> t*istenen).limit(a).forEach(t-> System.out.print(t+" "));
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static void herhangiKuvvetFakt(int a){
        IntStream.rangeClosed(1,a).reduce(1,(c,b)->(c*b));
    }
}
