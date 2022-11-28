import lambdapractice01.University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */
    public static void main(String[] args) {
        University u01=new University("bogazici","matematik",571,93);
        University u02=new University("istanbul tk","matematik",600,81);
        University u03=new University("istanbul ","huku",1400,71);
        University u04=new University("marmara","bilg muh",1080,77);
        University u05=new University("odtu","gemi muh",333,74);
        List<University> unv=new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(ogrenciSayilaribuyuktenKucuge(unv));

    }
    //task 01--> butun univ'lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<University> unv){

        return unv.
                stream().
                allMatch(t -> t.getNotOrt()>74);
    }
    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarMi(List<University> unv){
       return unv.stream().anyMatch(t -> t.getBolum().toLowerCase().contains("mat"));

    }
    public static List<University> ogrenciSayilaribuyuktenKucuge(List<University> unv){
       return unv.
                stream().
                sorted(Comparator.comparing(University::getOgrSayisi).reversed()).
                collect(Collectors.toList());

    }
}
