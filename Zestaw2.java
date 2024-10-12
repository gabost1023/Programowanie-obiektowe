import java.util.Scanner;

public class Zestaw2 {

    public static void main(String[] args) {

        //cw1
        double liczba1 = 0.23 + 76;
        System.out.println(liczba1);
        double liczba2 = 41*2.0 + 3;
        System.out.println(liczba2);
        int liczba3 = 5 - 33;
        System.out.println(liczba3);
        int liczba4 = 109%3;
        System.out.println(liczba4);
        int liczba5 = 50/2;
        System.out.println(liczba5);
        int liczba6 = 4|2;
        System.out.println(liczba6);
        double liczba7 = Math.pow(3, 5);
        System.out.println(liczba7);
        int liczba8 = 7 & 9;
        System.out.println(liczba8);

        //cw2
        // a)
        double gora = Math.pow(7,(1.0/2)) - 1;
        double calosc = (gora/2) + (Math.pow(3,3)%2);
        System.out.println(calosc);
        int zrzutuj = (int)calosc;
        System.out.println(zrzutuj);
        // b)
        double rok = 2003;
        double miesiac = 12;
        double dzien = 10;
        double calosc2 = rok / (dzien * miesiac);
        System.out.println(calosc2);
        int zrzutuj2 = (int)calosc2;
        System.out.println(zrzutuj2);
        // c)
        double trzy = 3 + Math.sqrt(3);
        double ulamek = (Math.sqrt(5)/2) / 3;
        System.out.println((trzy / ulamek) + 1);
        System.out.println((int) ((trzy / ulamek) + 1));
        // d)
        double modulo = 10%7%2;
        System.out.println(modulo);
        System.out.println((int) modulo);
        // e)

        double nazw = ((9%8) + 1) / Math.pow(2, 1.0/4.0);
        System.out.println(nazw);

        //cw3
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj slowo 1:");
        String slowo1 = sc.nextLine();
        System.out.println("Podaj slowo 2:");
        String slowo2 = sc.nextLine();
        System.out.println(slowo1 + " " + slowo2);

        //cw4
        System.out.println("Podaj a: ") ;
        int a = sc.nextInt();
        System.out.println("Podaj b: ") ;
        int b = sc.nextInt();
        int suma = a + b;
        int roznica = a - b;
        int iloczyn = a * b;
        int iloraz = a / b;
        System.out.println("Suma: " + suma + " Różnica: " + roznica + " Iloczyn: " + iloczyn + " Iloraz: " + iloraz) ;

        //cw5
        System.out.println("Podaj x:");
        double x = sc.nextDouble();
        double powiekszona140 = x + 140;
        System.out.println("Powiekszona o 140: " + powiekszona140);
        double pomniejszona31 = x - 31;
        System.out.println("Pomniejszona o 31: " + pomniejszona31);
        double powiekszona7 = x * 7;
        System.out.println("Powiekszona 7 razy: " + powiekszona7);
        double pomniejszona13 = x /13;
        System.out.println("Pomniejszona 13 razy: " + pomniejszona13);
        double modulo7 = x%7;
        System.out.println("Modulo 7: " + modulo7);
        int calkowita = (int) x / 4;
        System.out.println("Czesc calkowita z dzielenia przez 4: " + calkowita);
        long potega = (long) Math.pow(x,45);
        System.out.println("Do potegi 45: " + potega);
        int ilbit = (int) x & 67;
        System.out.println("Iloraz bitowy z 67: " + ilbit);
        int sumbit = (int) x | 59;
        System.out.println("Suma bitowa z 59: " + sumbit);
        int xor = (int) x ^ 23;
        System.out.println("XOR z 23: " + xor);
        int lewo = (int) x << 5;
        System.out.println("5 bitow w lewo: " + lewo);
        int prawo = (int) x >> 6;
        System.out.println("6 bitow w prawo: " + prawo);
    }
}
