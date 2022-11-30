import java.util.Arrays;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println(topla(5));
        System.out.println("*************");
        System.out.println(toplaCincix(5));
        System.out.println("*************");
        System.out.println(toplaCincix1(5));
        System.out.println("*************");
        System.out.println(ilkciftsayiToplami(4));
        System.out.println("*************");
        System.out.println(ilkTeksayiToplami(3));
        ikininKuvvetsayiToplami(4);
        System.out.println("*************");
        istenenSayininKuvvetsayiToplami(3,2);
        System.out.println("\n*************");
        istenenSayininFaktoriyeli(5);


    }
    //TASK 01 --> Structured Programming ve Functional Programming ile
    // 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam = toplam + i;
        }
        return toplam;
    }

    //Functional
    public static int toplaCincix(int x) {//List<Integer> x
        return IntStream.
                range(1, x + 1).//range(a,b) --> a dan b ye kadar(b dahil degil) int degerler akisa alindi
                        sum();
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCincix1(int x) {
        return IntStream.rangeClosed(1, x).filter(t -> t % 2 == 0).sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilkciftsayiToplami(int x) {
        return IntStream.iterate(2, t -> t + 2).limit(x).sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkTeksayiToplami(int x) {
       return IntStream.iterate(1,t->t+2).limit(x).sum();
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininKuvvetsayiToplami(int x) {
        IntStream a= IntStream.iterate(2,t->t*2).limit(x);
        System.out.println(Arrays.toString(a.toArray()));
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayininKuvvetsayiToplami(int istenenSayi,int y) {
        IntStream.iterate(istenenSayi,t ->t*istenenSayi).limit(y).forEach(Lambda01::yazdir);
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static void istenenSayininFaktoriyeli(int x) {
        System.out.println(IntStream.rangeClosed(1, x).reduce(1, (a, b) -> a * b));
    }
}

