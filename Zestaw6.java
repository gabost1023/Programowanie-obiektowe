//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Zestaw6 {
    public static void main(String[] args) {
        Product produkt1 = new Product("bulki", 5, 10);
        produkt1.wyswietlInformacje();
        produkt1.dodajDoMagazynu(5);
        produkt1.wyswietlInformacje();
        produkt1.usunZMagazynu(4);
        produkt1.wyswietlInformacje();

    }
}
class Product{
    public String nazwa;
    public int cena;
    public int iloscNaMagazynie;

    public Product(String nazwa, int cena, int iloscNaMagazynie) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.iloscNaMagazynie = iloscNaMagazynie;
    }

    public void wyswietlInformacje() {
        System.out.println("nazwa: " + nazwa + " cena: " + cena + " iloscNaMagazynie: " + iloscNaMagazynie);
    }

    public void dodajDoMagazynu(int ilosc){
        this.iloscNaMagazynie += ilosc;
    }

    public void usunZMagazynu(int ilosc){
        if(this.iloscNaMagazynie >= ilosc){
            this.iloscNaMagazynie-=ilosc;
        }

    }
}
