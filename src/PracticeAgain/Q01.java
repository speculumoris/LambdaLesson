package PracticeAgain;

import lambdapractice01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q01 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trilecex","havucDilim","guvec","kokorec",
                "kusleme","arabAsı","waffle","kunefe","guvecx"));

        alfBuyHrfTkrrsiz(menu);
        System.out.println("\n************");
        alfBuyHrfTrsTkrrsiz(menu);
        System.out.println("\n************");
        listElTkrrszz(menu);
        System.out.println("\n************");
        listEl7v7denKucuk(menu);
        System.out.println("\n************");
        listElStarW(menu);
        System.out.println("\n************");
        listElEndX(menu);
        System.out.println("\n************");
        listElEnBuyukKrktrSayisi(menu);
        System.out.println("\n************");
    }
    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBuyHrfTkrrsiz( List<String>l){
        l.
                stream().
                map(String::toUpperCase).
                sorted().
                distinct().
                forEach(t -> System.out.print(t+" "));
    }
    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void alfBuyHrfTrsTkrrsiz( List<String>l){
        l.stream().sorted(Comparator.reverseOrder()).distinct().forEach(t -> System.out.print(t+" "));
    }
    //// Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void listElTkrrszz(List<String>l){
        l.stream().sorted(Comparator.comparing(String::length)).forEach(t -> System.out.print(t+" "));

    }

    //anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void listEl7v7denKucuk(List<String>l){
        System.out.println(l.stream().allMatch(t -> t.length() <= 7) ? "karakterler yedi veya yediden azdir" : "karakterler yediden coktur");
    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void listElStarW(List<String>l){
        System.out.println(l.stream().noneMatch(t -> t.startsWith("w")) ? "bak olmazmis nasil olsun w ile isim" : "w ile baslyana kelime mi olur la");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void listElEndX(List<String>l){
        System.out.println(l.stream().anyMatch(t -> t.endsWith("x")) ? "x ile bitermis dediler" : "x ile biter mi hic");
    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void listElEnBuyukKrktrSayisi(List<String>l){
        Stream<String>ss=l.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(1);
        System.out.println(Arrays.toString(ss.toArray()));
    }
}
