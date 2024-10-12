import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zestaw1 {
    public static void main(String[] args) {
        //cw1
        String txt = "Gabriela Ostrowska";
        System.out.println(txt);

        //cw2
        System.out.println(txt.length());

        //cw3
        String Ala = "Ala ";
        String ma = "ma ";
        String kota = "kota ";

        String dodanie = Ala.concat(ma.concat(kota));
        System.out.println(dodanie);

        //cw4
        System.out.println("                     *     ");
        System.out.println("                     * *    ");
        System.out.println("                     * * *  ");
        System.out.println("* * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * *");
        System.out.println("                     * * *  ");
        System.out.println("                     * *    ");
        System.out.println("                     *     ");

        System.out.println("     *");
        System.out.println("    * *");
        System.out.println("   * * *");
        System.out.println("  * * * *");
        System.out.println(" * * * * *");
        System.out.println("* * * * * *");
        System.out.println(" * * * * *");
        System.out.println("  * * * *");
        System.out.println("   * * *");
        System.out.println("    * *");
        System.out.println("     *");

        //cw5
        String zdanie = "Ala ma kota";
        String zdanie_rep = zdanie.replace("a","e");
        System.out.println(zdanie_rep);

        //cw6
        String wielkie = zdanie.toUpperCase();
        System.out.println(wielkie);
        String male = zdanie.toLowerCase();
        System.out.println(male);

        //cw7
        int A = 'A';
        int wyk = '!';
        int malpa = '@';
        int wieksze = '>';
        int tylda = '~';
        int nowa = '\n';
        int b = '\b';

        System.out.println("Duże A: " + A);
        System.out.println(wyk);
        System.out.println(malpa);
        System.out.println(wieksze);
        System.out.println(tylda);
        System.out.println(nowa);
        System.out.println(b);

        //cw8
        //male litery przedzial od 97 do 122, duze litery od 65 do 90, cyfry od 48 do 57

        //cw9
        String grzesiek = "Grzesiek nie wiedział dlaczego %s jest tak drapieżnym %s mimo, że jego %s na to nie wskazuje.";
        String grzesiek1 = String.format(grzesiek, "ryś", "kotem", "futerko.");
        System.out.println(grzesiek1);

        //cw10
        String autor = "%s to najlepsza książka napisana przez %s";
        String autor1 = String.format(autor, "Portret Doriana Graya", "Oscara Wilde.");
        System.out.println(autor1);

        //cw11
        String wodrze = "wodrze";
        String powtorz = wodrze.repeat(5);
        System.out.println(powtorz);

        //cw12
        Date mojadata = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Dzisiaj jest dzień " + format1.format(mojadata) + " godzina " + format2.format(mojadata));

        //cw13
        char liczba54 = 54;
        char liczba102 = 103;
        char liczba241 = 241;
        char liczba67 = 67;
        char liczba9999 = 9999;
        char dlugosc = 18;
        char indeks = 17597;

        System.out.println(liczba54);
        System.out.println(liczba102);
        System.out.println(liczba241);
        System.out.println(liczba67);
        System.out.println(liczba9999);
        System.out.println(dlugosc);
        System.out.println(indeks);


    }
}
