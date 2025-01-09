import java.util.*;

public class Zestaw6 {
    public static void main(String[] args) {
        Produkt bulki = new Produkt("bulka", 2);
        Produkt piw00 = new Produkt("piw00", 2137);
        bulki.setNazwa("buleczki");
        System.out.println(bulki.toString());

        Magazyn magazyn = new Magazyn();
        magazyn.dodajProdukt(bulki, 50);
        magazyn.dodajProdukt(piw00, 10);

        KoszykZakupowy koszyk = new KoszykZakupowy();
        koszyk.dodajProdukt(bulki, 2, magazyn);

        KoszykZakupowy koszyk2 = new KoszykZakupowy();
        koszyk2.dodajProdukt(piw00, 1, magazyn);

        Zamowienie zamowienie = new Zamowienie(koszyk, "zlozone");
        Zamowienie zamowienie2 = new Zamowienie(koszyk2, "wyslane");

        Adres adres = new Adres("Sosnowa", "66", "Lodz", "10-100");
        Adres adres2 = new Adres("Sosnowa", "66", "Lodz", "10-101");
        System.out.println(adres2.przed(adres));
        Klient klient = new Klient("Adam", "Kowalski", adres);

        Sklep sklep = new Sklep(magazyn, "sklep", new Date(124, 0, 4));
        System.out.println(getClassIn.getClassInfo(adres));

        Jablko jablko = new Jablko("Jabłko Gala", 3);
        Marchewka marchewka = new Marchewka("Marchewka Bio", 2);

        // Testowanie owoców i warzyw
        System.out.println("Produkty spożywcze:");
        jablko.umyj();
        jablko.smak();
        jablko.zjedz();

        System.out.println();

        marchewka.umyj();
        marchewka.smak();
        marchewka.zjedz();

        System.out.println();

        // Produkty przemysłowe
        Telefon telefon = new Telefon("Smartfon XYZ", 1500);
        Kurtka kurtka = new Kurtka("Kurtka zimowa", 300);

        // Testowanie urządzeń elektronicznych i ubrań
        System.out.println("Produkty przemysłowe:");
        telefon.wlacz();
        telefon.uzyj();
        telefon.zepsuj();
        telefon.napraw();
        telefon.wylacz();

        System.out.println();

        kurtka.wypierz();
        kurtka.wysusz();
        kurtka.wyprasuj();
        kurtka.zaloz();
        kurtka.zniszcz();
    }
}

interface IProdukt{
    String getNazwa();
    void setNazwa(String nazwa);
    int getCena();
    void setCena(int cena);
}
class Produkt implements IProdukt {
    private String nazwa;
    private int cena;

    public Produkt(String nazwa, int cena) {
        setNazwa(nazwa);
        setCena(cena);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        if (nazwa == null || nazwa.isEmpty()) {
            throw new IllegalArgumentException("Nazwa produktu nie może być pusta.");
        }
        this.nazwa = nazwa;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        if (cena <= 0) {
            throw new IllegalArgumentException("Cena produktu musi być dodatnia.");
        }
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Nazwa: " + nazwa + " Cena: " + cena;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, cena);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Produkt)) return false;

        Produkt produkt = (Produkt) obj;
        return cena == produkt.cena && Objects.equals(nazwa, produkt.nazwa);
    }
}

interface IMagazyn{
    Map<Produkt, Integer> getProduktyMagazyn();
    void setProduktyMagazyn(Map<Produkt, Integer> produktyMagazyn);
    void dodajProdukt(Produkt produkt, int ilosc);
    void usunProdukt(Produkt produkt, int ilosc);
    int sprawdzIlosc(Produkt produkt);
}

class Magazyn implements IMagazyn {
    private Map<Produkt, Integer> produktyMagazyn;

    public Magazyn() {
        this.produktyMagazyn = new HashMap<>();
    }

    public Map<Produkt, Integer> getProduktyMagazyn() {
        return produktyMagazyn;
    }

    public void setProduktyMagazyn(Map<Produkt, Integer> produktyMagazyn) {
        if (produktyMagazyn == null) {
            throw new IllegalArgumentException("Lista produktów nie może być null.");
        }
        this.produktyMagazyn = produktyMagazyn;
    }

    public void dodajProdukt(Produkt produkt, int ilosc) {
        if (ilosc <= 0) {
            throw new IllegalArgumentException("Ilość musi być większa od zera.");
        }
        produktyMagazyn.put(produkt, produktyMagazyn.getOrDefault(produkt, 0) + ilosc);
    }

    public void usunProdukt(Produkt produkt, int ilosc) {
        if (produktyMagazyn.containsKey(produkt)) {
            int obecnaIlosc = produktyMagazyn.get(produkt);
            if (ilosc <= obecnaIlosc) {
                produktyMagazyn.put(produkt, obecnaIlosc - ilosc);
            } else {
                System.out.println("Za mało produktów w magazynie.");
            }
        } else {
            System.out.println("Produktu nie ma w magazynie.");
        }
    }

    public int sprawdzIlosc(Produkt produkt) {
        return produktyMagazyn.getOrDefault(produkt, 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asortyment magazynu:\n");
        for (Produkt produkt : produktyMagazyn.keySet()) {
            int ilosc = produktyMagazyn.get(produkt);
            sb.append("Produkt: ").append(produkt.getNazwa()).append(", Ilość: ").append(ilosc).append("\n");
        }
        return sb.toString();
    }
}

interface IKoszykZakupowy {
    Map<Produkt, Integer> getListaProduktow();
    void setListaProduktow(Map<Produkt, Integer> listaProduktow);
    void dodajProdukt(Produkt produkt, int ilosc, Magazyn magazyn);
    int obliczCalkowitaWartosc();
}

class KoszykZakupowy implements IKoszykZakupowy{
    private Map<Produkt, Integer> listaProduktow;

    public KoszykZakupowy() {
        this.listaProduktow = new HashMap<>();
    }

    public Map<Produkt, Integer> getListaProduktow() {
        return listaProduktow;
    }

    public void setListaProduktow(Map<Produkt, Integer> listaProduktow) {
        if (listaProduktow == null) {
            throw new IllegalArgumentException("Lista produktów w koszyku nie może być null.");
        }
        this.listaProduktow = listaProduktow;
    }

    public void dodajProdukt(Produkt produkt, int ilosc, Magazyn magazyn) {
        if (ilosc <= 0) {
            throw new IllegalArgumentException("Ilość musi być większa od zera.");
        }
        if (magazyn.sprawdzIlosc(produkt) >= ilosc) {
            listaProduktow.put(produkt, listaProduktow.getOrDefault(produkt, 0) + ilosc);
            magazyn.usunProdukt(produkt, ilosc); // Odejmij produkty z magazynu
        } else {
            System.out.println("Za mało produktów w magazynie.");
        }
    }

    public int obliczCalkowitaWartosc() {
        int suma = 0;
        for (Produkt produkt : listaProduktow.keySet()) {
            int ilosc = listaProduktow.get(produkt);
            suma += ilosc * produkt.getCena();
        }
        return suma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Zawartość koszyka:\n");
        for (Produkt produkt : listaProduktow.keySet()) {
            int ilosc = listaProduktow.get(produkt);
            sb.append("Produkt: ").append(produkt.getNazwa()).append(", Ilość: ").append(ilosc).append("\n");
        }
        return sb.toString();
    }
}

interface IZamowienie{
    KoszykZakupowy getKoszykZakupowy();
    void setKoszykZakupowy(KoszykZakupowy koszykZakupowy);
    String getStatusZamowienia();
    void setStatusZamowienia(String statusZamowienia);
    Platnosc getPlatnosc();
    void setPlatnosc(Platnosc platnosc);
    void finalizujZamowienie(Magazyn magazyn);
}

class Zamowienie implements IZamowienie{
    private KoszykZakupowy koszykZakupowy;
    private String statusZamowienia;
    private Platnosc platnosc;

    public Zamowienie(KoszykZakupowy koszykZakupowy, String statusZamowienia) {
        setKoszykZakupowy(koszykZakupowy);
        setStatusZamowienia(statusZamowienia);
        this.platnosc = new Platnosc(koszykZakupowy.obliczCalkowitaWartosc(), "Nieopłacone");
    }

    public KoszykZakupowy getKoszykZakupowy() {
        return koszykZakupowy;
    }

    public void setKoszykZakupowy(KoszykZakupowy koszykZakupowy) {
        if (koszykZakupowy == null) {
            throw new IllegalArgumentException("Koszyk zakupowy nie może być null.");
        }
        this.koszykZakupowy = koszykZakupowy;
    }

    public String getStatusZamowienia() {
        return statusZamowienia;
    }

    public void setStatusZamowienia(String statusZamowienia) {
        if (statusZamowienia == null || statusZamowienia.isEmpty()) {
            throw new IllegalArgumentException("Status zamówienia nie może być pusty.");
        }
        this.statusZamowienia = statusZamowienia;
    }

    public Platnosc getPlatnosc() {
        return platnosc;
    }

    public void setPlatnosc(Platnosc platnosc) {
        if (platnosc == null) {
            throw new IllegalArgumentException("Płatność nie może być null.");
        }
        this.platnosc = platnosc;
    }

    public void finalizujZamowienie(Magazyn magazyn) {
        if (platnosc.czyOplacone()) {
            this.statusZamowienia = "Gotowe do wysyłki";
            for (Map.Entry<Produkt, Integer> entry : koszykZakupowy.getListaProduktow().entrySet()) {
                magazyn.usunProdukt(entry.getKey(), entry.getValue());
            }
        } else {
            System.out.println("Płatność nie została dokonana. Nie można sfinalizować zamówienia.");
        }
    }

    @Override
    public String toString() {
        return koszykZakupowy.toString() + "Status zamówienia: " + this.statusZamowienia + "\n";
    }
}

interface IKlient{
    String getImie();
    void setImie(String imie);
    String getNazwisko();
    void setNazwisko(String nazwisko);
    ArrayList<Zamowienie> getListaZamowien();
    void setListaZamowien(ArrayList<Zamowienie> listaZamowien);
    Adres getAdres();
    void setAdres(Adres adres);
    void dodajZamowienie(Zamowienie zamowienie);

    default void witaj() {
        System.out.println("Witaj nowy kliencie!");
    }
}

class Klient extends Osoba implements IKlient{
    private ArrayList<Zamowienie> listaZamowien;
    private Adres adres;

    public Klient(String imie, String nazwisko, Adres adres) {
        super(imie, nazwisko);
        setAdres(adres);
        this.listaZamowien = new ArrayList<>();
    }

    public ArrayList<Zamowienie> getListaZamowien() {
        return listaZamowien;
    }

    public void setListaZamowien(ArrayList<Zamowienie> listaZamowien) {
        if (listaZamowien == null) {
            throw new IllegalArgumentException("Lista zamówień nie może być null.");
        }
        this.listaZamowien = listaZamowien;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        if (adres == null) {
            throw new IllegalArgumentException("Adres nie może być null.");
        }
        this.adres = adres;
    }

    public void dodajZamowienie(Zamowienie zamowienie) {
        if (zamowienie == null) {
            throw new IllegalArgumentException("Zamówienie nie może być null.");
        }
        this.listaZamowien.add(zamowienie);
    }

    @Override
    public String toString() {
        return "Klient: " + getImie() + " " + getNazwisko() + ", Adres: " + adres.toString() + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImie(), getNazwisko(), adres);
    }

    @Override
    public boolean equals (Object obj){
        if (this == obj) return true;
        if(!(obj instanceof Klient)) return false;
        Klient klient = (Klient) obj;

        return Objects.equals(getImie(),klient.getImie()) && Objects.equals(getNazwisko(), klient.getNazwisko()) && Objects.equals(adres,klient.adres);
    }
}

interface ISklep{
    Magazyn getMagazyn();
    void setMagazyn(Magazyn magazyn);
    String getNazwaSklepu();
    void setNazwaSklepu(String nazwaSklepu);
    Date getDataPowstania();
    void setDataPowstania(Date dataPowstania);
    void wyswietlOferty();
    void zakup(Klient klient, Produkt produkt, int ilosc);
}

class Sklep implements ISklep{
    private Magazyn magazyn;
    private String nazwaSklepu;
    private Date dataPowstania;

    public Sklep(Magazyn magazyn, String nazwaSklepu, Date dataPowstania) {
        setMagazyn(magazyn);
        setNazwaSklepu(nazwaSklepu);
        setDataPowstania(dataPowstania);
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        if (magazyn == null) {
            throw new IllegalArgumentException("Magazyn nie może być null.");
        }
        this.magazyn = magazyn;
    }

    public String getNazwaSklepu() {
        return nazwaSklepu;
    }

    public void setNazwaSklepu(String nazwaSklepu) {
        if (nazwaSklepu == null || nazwaSklepu.isEmpty()) {
            throw new IllegalArgumentException("Nazwa sklepu nie może być pusta.");
        }
        this.nazwaSklepu = nazwaSklepu;
    }

    public Date getDataPowstania() {
        return dataPowstania;
    }

    public void setDataPowstania(Date dataPowstania) {
        if (dataPowstania == null || dataPowstania.after(new Date())) {
            throw new IllegalArgumentException("Data powstania nie może być null ani z przyszłości.");
        }
        this.dataPowstania = dataPowstania;
    }

    public void wyswietlOferty() {
        System.out.println(magazyn.toString());
    }

    public void zakup(Klient klient, Produkt produkt, int ilosc) {
        if (klient == null || produkt == null) {
            throw new IllegalArgumentException("Klient i produkt nie mogą być null.");
        }
        if (ilosc <= 0) {
            throw new IllegalArgumentException("Ilość musi być większa od zera.");
        }
        if (magazyn.sprawdzIlosc(produkt) >= ilosc) {
            KoszykZakupowy koszykZakupowy = new KoszykZakupowy();
            koszykZakupowy.dodajProdukt(produkt, ilosc, magazyn);

            Zamowienie noweZamowienie = new Zamowienie(koszykZakupowy, "zlozone");
            klient.dodajZamowienie(noweZamowienie);
        } else {
            System.out.println("Za mało produktów w magazynie.");
        }
    }

    @Override
    public String toString() {
        return "Sklep: " + nazwaSklepu + ", Data powstania: " + dataPowstania.toString() + "\n";
    }
}

interface IPlatnosc {
    int getKwota();
    void setKwota(int kwota);
    String getStatusPlatnosci();
    void setStatusPlatnosci(String statusPlatnosci);
    void zaplac();
    boolean czyOplacone();
}

class Platnosc implements IPlatnosc{
    private int kwota;
    private String statusPlatnosci;

    public Platnosc(int kwota, String statusPlatnosci) {
        setKwota(kwota);
        setStatusPlatnosci(statusPlatnosci);
    }

    public int getKwota() {
        return kwota;
    }

    public void setKwota(int kwota) {
        if (kwota <= 0) {
            throw new IllegalArgumentException("Kwota musi być większa od zera.");
        }
        this.kwota = kwota;
    }

    public String getStatusPlatnosci() {
        return statusPlatnosci;
    }

    public void setStatusPlatnosci(String statusPlatnosci) {
        if (statusPlatnosci == null || statusPlatnosci.isEmpty()) {
            throw new IllegalArgumentException("Status płatności nie może być pusty.");
        }
        this.statusPlatnosci = statusPlatnosci;
    }

    public void zaplac() {
        this.statusPlatnosci = "Opłacone";
    }

    public boolean czyOplacone() {
        return this.statusPlatnosci.equals("Opłacone");
    }

    @Override
    public int hashCode() {
        return Objects.hash(kwota, statusPlatnosci);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Platnosc)) return false;

        Platnosc platnosc = (Platnosc) obj;
        return kwota == platnosc.kwota && Objects.equals(statusPlatnosci, platnosc.statusPlatnosci);
    }
}

interface IAdres {
    String getUlica();
    void setUlica(String ulica);
    String getNumerDomu();
    void setNumerDomu(String numerDomu);
    String getNumerMieszkania();
    void setNumerMieszkania(String numerMieszkania);
    String getMiasto();
    void setMiasto(String miasto);
    String getKodPocztowy();
    void setKodPocztowy(String kodPocztowy);
    boolean przed(Adres innyAdres);
}

class Adres implements IAdres{
    private String ulica;
    private String numerDomu;
    private String numerMieszkania;
    private String miasto;
    private String kodPocztowy;

    public Adres(String ulica, String numerDomu, String numerMieszkania, String miasto, String kodPocztowy) {
        setUlica(ulica);
        setNumerDomu(numerDomu);
        setNumerMieszkania(numerMieszkania);
        setMiasto(miasto);
        setKodPocztowy(kodPocztowy);
    }

    public Adres(String ulica, String numerDomu, String miasto, String kodPocztowy) {
        this(ulica, numerDomu, null, miasto, kodPocztowy);
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        if (ulica == null || ulica.isEmpty()) {
            throw new IllegalArgumentException("Ulica nie może być pusta.");
        }
        this.ulica = ulica;
    }

    public String getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(String numerDomu) {
        if (numerDomu == null || numerDomu.isEmpty()) {
            throw new IllegalArgumentException("Numer domu nie może być pusty.");
        }
        this.numerDomu = numerDomu;
    }

    public String getNumerMieszkania() {
        return numerMieszkania;
    }

    public void setNumerMieszkania(String numerMieszkania) {
        this.numerMieszkania = numerMieszkania; // numerMieszkania może być null
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        if (miasto == null || miasto.isEmpty()) {
            throw new IllegalArgumentException("Miasto nie może być puste.");
        }
        this.miasto = miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        if (kodPocztowy == null || kodPocztowy.isEmpty()) {
            throw new IllegalArgumentException("Kod pocztowy nie może być pusty.");
        }
        this.kodPocztowy = kodPocztowy;
    }

    public boolean przed(Adres innyAdres) {
        return this.kodPocztowy.compareTo(innyAdres.getKodPocztowy()) < 0;
    }

    @Override
    public String toString() {
        if (this.numerMieszkania == null) {
            return "Ulica: " + this.ulica + " Numer domu: " + this.numerDomu + " Miasto: " + this.miasto + " KodPocztowy: " + this.kodPocztowy;
        }
        return "Ulica: " + this.ulica + " Numer domu: " + this.numerDomu + " Numer mieszkania: " + this.numerMieszkania + " Miasto: " + this.miasto + " KodPocztowy: " + this.kodPocztowy;
    }
}
class getClassIn{
    public static String getClassInfo(Object object) {
        return "Cześć! Jestem klasą " + object.getClass().getName() + "\n";
    }
}

class Osoba{
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        setImie(imie);
        setNazwisko(nazwisko);
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}

class KlientFirmowy extends Klient{
    String NIP;
    String REGON;

    public KlientFirmowy(String imie, String nazwisko, Adres adres, String NIP, String REGON) {
        super(imie,nazwisko,adres);
        setNIP(NIP);
        setREGON(REGON);
    }

    public String getNIP(){
        return NIP;
    }

    public void setNIP(String NIP){
        this.NIP = NIP;
    }

    public String getREGON(){
        return REGON;
    }

    public void setREGON(String REGON){
        this.REGON = REGON;
    }
}

class KlientIndywidualny extends Klient{
    String PESEL;

    public KlientIndywidualny(String imie, String nazwisko, Adres adres, String PESEL) {
        super(imie,nazwisko,adres);
        setPESEL(PESEL);
    }

    public String getPESEL(){
        return PESEL;
    }

    public void setPESEL(String PESEL){
        this.PESEL = PESEL;
    }
}

class ProduktSpozywczy extends Produkt{
    public ProduktSpozywczy(String nazwa, int cena){
        super(nazwa,cena);
    }
}

class ProduktPrzemyslowy extends Produkt{
    public ProduktPrzemyslowy(String nazwa, int cena){
        super(nazwa,cena);
    }
}

abstract class Owoc extends ProduktSpozywczy{
    public Owoc(String nazwa, int cena){
        super(nazwa,cena);
    }
    public abstract String smak();
    public abstract void umyj();
    public abstract void zjedz();
}

abstract class Warzywo extends ProduktSpozywczy{
    public Warzywo(String nazwa, int cena){
        super(nazwa,cena);
    }
    public abstract String smak();
    public abstract void umyj();
    public abstract void zjedz();
}

abstract class UrzadzenieElektroniczne extends ProduktPrzemyslowy {
    public UrzadzenieElektroniczne(String nazwa, int cena){
        super(nazwa,cena);
    }
    public abstract void napraw();
    public abstract void uzyj();
    public abstract void zepsuj();
    public abstract void wlacz();
    public abstract void wylacz();
}

abstract class Ubranie extends ProduktPrzemyslowy {
    public Ubranie(String nazwa, int cena){
        super(nazwa,cena);
    }
    public abstract void wypierz();
    public abstract void zaloz();
    public abstract void wyprasuj();
    public abstract void wysusz();
    public abstract void zniszcz();
}

class Jablko extends Owoc{
    public Jablko(String nazwa, int cena){
        super(nazwa,cena);
    }

    @Override
    public String smak() {
        return getNazwa() + "ma słodki smak";
    }

    @Override
    public void umyj() {
        System.out.println(getNazwa() + "zostalo umyte");
    }

    @Override
    public void zjedz() {
        System.out.println(getNazwa() + "zostalo zjedzone");
    }
}

class Marchewka extends Warzywo {
    public Marchewka(String nazwa, int cena) {
        super(nazwa, cena);
    }

    @Override
    public String smak() {
        return getNazwa() + " ma delikatnie słodki smak.";
    }

    @Override
    public void umyj() {
        System.out.println(getNazwa() + "została umyta");
    }

    @Override
    public void zjedz() {
        System.out.println(getNazwa() + "została zjedzona");
    }
}

class Telefon extends UrzadzenieElektroniczne {
    public Telefon(String nazwa, int cena) {
        super(nazwa, cena);
    }

    @Override
    public void napraw() {
        System.out.println("Naprawa telefonu");
    }

    @Override
    public void uzyj() {
        System.out.println("Używanie telefonu");
    }

    @Override
    public void zepsuj() {
        System.out.println("Telefon został uszkodzony");
    }

    @Override
    public void wlacz() {
        System.out.println("Telefon włączony.");
    }

    @Override
    public void wylacz() {
        System.out.println("Telefon wyłączony.");
    }
}

class Kurtka extends Ubranie {
    public Kurtka(String nazwa, int cena) {
        super(nazwa, cena);
    }

    @Override
    public void wypierz() {
        System.out.println("Pranie kurtki");
    }

    @Override
    public void zaloz() {
        System.out.println("Zakładanie kurtki.");
    }

    @Override
    public void wyprasuj() {
        System.out.println("Prasowanie kurtki");
    }

    @Override
    public void wysusz() {
        System.out.println("Suszenie kurtki");
    }

    @Override
    public void zniszcz() {
        System.out.println("Kurtka została zniszczona");
    }
}






