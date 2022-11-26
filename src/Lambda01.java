import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda01 {
    /*
          1)  Lambda --> method create  etme değil mevcut method'ları(library)secip kullanmaktır...
              Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
          2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
              "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
          3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
              ve hatasiz code yazma acilarindan cok faydalidir.
          4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

    */
    public static void main(String[] args) {
        //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        printElStructured(sayi);
        System.out.println("\n **********************1");
        printElFunctional(sayi);
        System.out.println("\n **********************2");
        printElFunctional1(sayi);
        System.out.println("\n **********************3");
        printElFunctional2(sayi);
        System.out.println("\n **********************4");
        printCiftElFunctional(sayi);
        System.out.println("\n **********************5");
        printCiftOtKucukOlanlar(sayi);
        System.out.println("\n **********************6");
        printCiftOtzBykFunctional(sayi);

    }

    public static void printElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }

    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctional(List<Integer> sayi) {
        sayi.
                stream().
                forEach((t) -> System.out.print(t + " "));// Lambda expression
    }


    public static void printElFunctional1(List<Integer> sayi) {
        sayi.
                stream().
                forEach(System.out::print);//method reference
        //Bir Class'in icinden hangi methodu cagirmak istiyorsaniz :: kullanmaniz gerekiyor

    }


    // ---> kendimi< bir method olusturalim
    public static void yazdir(int a) {
        System.out.print(a + " ");
    }


    public static void printElFunctional2(List<Integer> sayi) {
        sayi.
                stream().
                forEach(Lambda01::yazdir);

    }

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0).
                forEach(Lambda01::yazdir);
    }

    //TASK  : structural Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.println(w + " ");
            }
        }
    }

    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtKucukOlanlar(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0 ).
                filter( t -> t < 34).
                forEach(Lambda01::yazdir);

    }
    public static void printCiftOtStructured(List<Integer> sayi) {

        for (Integer w : sayi) {
            if (w%2==0&& w<34){
                System.out.println(w+" ");
            }

        }

    }
    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtzBykFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t -> t%2==0 || t>34).
                forEach(Lambda01::yazdir);
    }
}
