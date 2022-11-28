package lambdapractice01;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        hepsiniYazdir(list);
        System.out.println("\n***************");
        negatifOlanlar(list);
        System.out.println("\n***************");
        pozitifOlanlar(list);
        System.out.println("\n***************");
        pozVeCift(list);
        System.out.println("\n***************");
        pozVeyaCift(list);
        System.out.println("\n***************");
        hepsininKareleriniYazdir(list);
        System.out.println("\n***************");
        hepsininCiftKupleriniYazdir(list);
        System.out.println("\n***************");
        kareTekrarsiz(list);
        System.out.println("\n***************");
        elemanlariSirala(list);
        System.out.println("\n***************");
        elemanlariSiralaBuyuktenKucuge(list);
        System.out.println("\n***************");
        System.out.println("pozKup5list(list) = " + pozKup5list(list));
        System.out.println("\n***************");
        pozKup5list2(list);
        System.out.println("\n***************");
        System.out.println("pozKup5list(list) = " + pozKup5list1(list));
        System.out.println("\n***************");
        System.out.println("elemanToplami(list) = " + elemanToplami(list));
        System.out.println("\n***************");

        pozElemanToplami(list);


    }
    //S1:Listi aralarinda bosluk birakarak yazdiriniz.
    public static void hepsiniYazdir(List<Integer> l){
        l.stream().forEach(t -> System.out.print(t+" "));
    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifOlanlar(List<Integer> l){
        l.stream().filter(t-> t<0).forEach(t -> System.out.print(t+" "));
    }

    //S3: cift olanlardan yeni bir liste olustur
    public static void pozitifOlanlar(List<Integer> l){
        List<Integer> newList=new ArrayList<>();
        l.stream().filter(t-> t%2==0).forEach(newList::add);
        System.out.println(newList);
    }
    //S4:pozitif ve çift olanları yazdırın

    public static void pozVeCift(List<Integer>l){

        l.stream().filter(t->t%2==0 && t>0).forEach(t-> System.out.print(t+" "));
    }

    //S5:pozitif veya çift olanları yazdırın
    public static void pozVeyaCift(List<Integer>l){

        l.stream().filter(t->t%2==0 || t>0).forEach(t-> System.out.print(t+" "));
    }

    // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
    public static void hepsininKareleriniYazdir(List<Integer> l){
        l.stream().map(t->t*t).forEach(t -> System.out.print(t+" "));
    }

    //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
    public static void hepsininCiftKupleriniYazdir(List<Integer> l){
        l.stream().filter(t->t%2==0).map(t->t*t*t).forEach(t -> System.out.print(t+" "));
    }

    //S8 : list in elemanlarin karelerini tekrarsiz yazdıralım
    public static void kareTekrarsiz(List<Integer> l){
        l.stream().map(t-> t*t).distinct().forEach(t -> System.out.print(t+" "));
        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }
    //S9: listin elemanlarini kucukten buyuge siralayalim
    public static void elemanlariSirala(List<Integer> l){
        l.stream().sorted().forEach(t -> System.out.print(t+" "));
    }

    //S10: listin elemanlarini buyukten kucuge siralayalim
    public static void elemanlariSiralaBuyuktenKucuge(List<Integer> l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t+" "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> pozKup5list(List<Integer> l){
        return l.stream().filter(t -> t>0).map(t -> t*t*t).filter(t ->t%10==5).collect(Collectors.toList());
    }
    public static void  pozKup5list2(List<Integer> l){
        List<Integer>list=l.stream().filter(t -> t>0).map(t -> t*t*t).filter(t ->t%10==5).collect(Collectors.toList());
        System.out.println(list);
    }
    //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozKup5list1(List<Integer> l){
        List<Integer>list=l.stream().filter(t -> t>0).map(t ->t*t).filter(t -> t%10!=5).collect(Collectors.toList());
    return list;
    }

    // S13 :list elemanlarini toplamini bulalim
    public static int elemanToplami(List<Integer> l){
       int i= l.stream().reduce(0,(a,b)->a+b);
       return i;
    }
    //S14 : Listin pozitif elemanları toplamını bulalım
    public static void pozElemanToplami(List<Integer> l){
       Optional<Integer> a= l.stream().filter(t -> t>0).reduce(Integer::sum);
        System.out.println(a);
    }

}
