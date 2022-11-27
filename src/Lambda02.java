import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi=new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);
        System.out.println();
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n ********");
        maxElPrintStructured(sayi);
        System.out.println("\n ********");
        maxElPrint(sayi);
        System.out.println("\n ********");
        ciftElKareEnBuyukPrint(sayi);
        System.out.println("\n ********");
        elTopla(sayi);


    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t*t).
                forEach(Lambda01::yazdir); //16,4,36 --- Stream icerisindeki elemanlari baska degerlere donus;
    }

    // Task 2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz
    public static boolean tekBul(int a){
        return a%2 != 0;
    }
    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda02::tekBul).
                map(t -> (t*t*t)+1).
                forEach(Lambda01::yazdir); //16,4,36 --- Stream icerisindeki elemanlari baska degerlere donus;
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKareKokPrint(List<Integer> sayi){
        sayi.stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t -> System.out.println(t+" "));
    }
    // Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void maxElPrint(List<Integer> sayi){
        Optional<Integer>maxSayi= sayi.
                stream().
                reduce(Math::max); //eger benim resultım tek bir deger ise o zaman reduce terminal opr. kullanilir.
        System.out.println(maxSayi);
    }
    //Structured yapi ile cozelim
    public static void maxElPrintStructured(List<Integer> sayi){
        int max=Integer.MIN_VALUE;
        for (Integer w:sayi) {
            max=Math.max(max,w);
        }
        System.out.println(max);
    }
    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftElKareEnBuyukPrint(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));   // "Integer::max" methodu Math::max 'a göre daha hızlı çalıştığı için Integer daha iyi olur.
                                        // Math:: max yapsak da doğru olur normalde,daha geniş olduğu için Integer den yavas çalışır.

    }
    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void elTopla(List<Integer> sayi){
        int toplam =sayi.stream().reduce(0,(a,b) -> a+b);
        System.out.println("toplam = " + toplam);
    }
}
