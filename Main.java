import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;


interface IComparable{


    List<String> CompareTo();


}
class Ingredient implements IComparable{
    List<String> lista_nazw = new ArrayList<>();

    public List<String> CompareTo(){
        Collections.sort(lista_nazw);
        return lista_nazw;
    }
    String nazwaIngredienta;
    String ilosc;
    double cenaIngredienta;

    Ingredient(String nazwa,String ilosc,double cenaIngredienta){
        this.nazwaIngredienta = nazwa;
        this.ilosc = ilosc;
        this.cenaIngredienta = cenaIngredienta;
        lista_nazw.add(nazwa);

    }



    @Override
    public String toString() {
        return "Ingredient{" +
                "nazwaIngredienta='" + nazwaIngredienta + '\'' +
                ", ilosc='" + ilosc + '\'' +
                ", cenaIngredienta=" + cenaIngredienta +
                '}';
    }
    public double zwrocCena(){
        return cenaIngredienta;
    }

}
class Przepis{
    String nazwa;
    double suma = 0;
    List<Ingredient> ingredienci = new ArrayList<>();
    int czasPrzygotowania;
    void DodajIngredient(Ingredient a,int cenaIngredienta){
        ingredienci.add(a);
        suma += cenaIngredienta;
    }
    void UstawNazweICzas(String nazwa, int czas){
        this.nazwa = nazwa;
        this.czasPrzygotowania = czas;
    }
    boolean czyCzas(){
        boolean a = false;
        if(this.czasPrzygotowania>0){
            a= true;
        }
        else if (this.czasPrzygotowania<0){
            a= false;
        }
        return a;
    }
    int ileIngredientow(){
       return this.ingredienci.size();
    }
    @Override
    public String toString() {
        for(int i = 0; i<ingredienci.size(); i++) {
            return "Przepis{" +
                    "nazwa='" + nazwa + '\'' +
                    ", ingredienci=" + ingredienci +
                    ", czasPrzygotowania=" + czasPrzygotowania +
                    ", suma=" + suma +
                    '}';
        }
        return "Pusta";
    }
}
abstract class Zamowienie{
   protected LocalDateTime czasDostawy;
   boolean poprawnyCzas(){
        boolean a = false;
       if(czasDostawy.isAfter(LocalDateTime.now())){
           a = true;

       }
       return a;
   }
   void ustawCzasDostawy(LocalDateTime czasDostawy){
       this.czasDostawy = czasDostawy;
   }
}
class NaMiejscu extends Zamowienie{

}
class NaWynos extends Zamowienie{
    boolean czas = false;
    int a = czasDostawy.getHour() - LocalDateTime.now().getHour();
    boolean poprawnyCzas(){
        if(a>2){
            czas = true;
        }
        return czas;
    }
}
public class Main {
    public static void main(String[] args) {
        Ingredient test1 = new Ingredient("Test1","test",15);
        Ingredient test2 = new Ingredient("Test2","test1",1);
        Ingredient test3 = new Ingredient("Test3","test2",15);
        Ingredient test4 = new Ingredient("Test4","test3",1);
        Ingredient test5 = new Ingredient("Test5","test4",15);

        Przepis przepis = new Przepis();
        przepis.DodajIngredient(test1,15);
        przepis.DodajIngredient(test2,1);
        przepis.DodajIngredient(test3,15);
        przepis.DodajIngredient(test4,1);
        przepis.DodajIngredient(test5,15);
        System.out.println(przepis.toString());
        System.out.println(test2.zwrocCena());
        System.out.println(test5.zwrocCena());
        przepis.UstawNazweICzas("Przepis1",15);
        przepis.czyCzas();
        System.out.println(przepis.ileIngredientow());
        System.out.println();






    }
}
