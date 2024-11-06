import java.util.Random;
import java.util.Scanner;

public class Zestaw4 {

    public static int[] generujTablice (int n, int minWartosc, int maxWartosc){
        int[] tab = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++){
            tab[i] = rand.nextInt(maxWartosc - minWartosc + 1) + minWartosc;
        }
        return tab;
    }

    public static void wypiszTablice(int[] tab, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i*m+j < tab.length) System.out.print(tab[i*m+j] + " ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }

    public static int ileNieparzystych (int[] tab){
        int nieparzyste = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 != 0) nieparzyste++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return nieparzyste;
    }

    public static int ileParzystych (int[] tab){
        int parzyste = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0) parzyste++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return parzyste;
    }

    public static int ileDodatnich (int[] tab){
        int dodatnie = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > 0) dodatnie++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return dodatnie;
    }

    public static int ileUjemnych (int[] tab){
        int ujemne = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] < 0) ujemne++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return ujemne;
    }

    public static int ileZerowych (int[] tab){
        int zerowe = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 0) zerowe++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return zerowe;
    }

    public static int ileMaksymalnych (int[] tab){
        int m_count = 0;
        int max = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] > max) max = tab[i];
        }
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == max) m_count++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return m_count;
    }

    public static int ileMinimalnych (int[] tab){
        int min_count = 0;
        int min = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] < min) min = tab[i];
        }
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == min) min_count++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return min_count;
    }

    public static int ileUnikalnych (int[] tab) {
        int temp = 0;
        int count = 0;
        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab.length - 1; j++) {
                if (tab[j] > tab[j + 1]) {
                    temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
                }
            }
        }
        if (tab.length > 1 && tab[0] != tab[1]) count ++;
        if (tab[tab.length - 1] != tab[tab.length - 2]) count ++;
        for (int i = 1; i < tab.length-1; i++) {
            if (tab[i] != tab[i + 1] && tab[i] != tab[i-1]) count++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return count;
    }

    public static int sumaDodatnich (int[] tab){
        int suma_dodatnich = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] > 0) suma_dodatnich+=tab[i];
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return suma_dodatnich;
    }

    public static int sumaUjemnych (int[] tab){
        int suma_ujemnych = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] < 0) suma_ujemnych+=tab[i];
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return suma_ujemnych;
    }

    public static int sredniaArytmetyczna (int[] tab){
        int suma_sr = 0;
        for (int i = 0; i < tab.length; i++) {
            suma_sr += tab[i];
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return suma_sr/tab.length;
    }

    public static double sredniaGeometyczna (int[] tab){
        int iloczyn = 1;
        int dl = tab.length;
        for (int i = 0; i < tab.length; i++) {
            iloczyn *= tab[i];
        }
        double wynik = Math.pow(iloczyn, (double) 1 /dl );
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return wynik;
    }

    public static double sredniaHarmoniczna (int[] tab){
        double dl = tab.length;
        double suma = 0;
        for (int i = 0; i<tab.length; i++){
            suma += Math.pow(tab[i], -1);
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return dl/suma;
    }

    public static int[] funkcjaLiniowa (int[] tab, int a, int b){
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            tab[i] = a*tab[i] + b;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return tab;
    }

    public static int[] funkcjaKwadratowa (int[] tab, int a, int b, int c){
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            tab[i] = a * ((int) Math.pow(tab[i], 2)) + b * tab[i] + c;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return tab;
    }

    public static int[] funkcjaWykladnicza (int[] tab, int a){
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int) Math.pow(a, tab[i]);
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return tab;
    }

    public static int najdluzszyCiagDodatnich (int[] tab){
        int max = 0;
        int teraz = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] > 0){
                teraz++;
                max = Math.max(max, teraz);
            }
            else teraz = 0;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return max;
    }

    public static int najdluzszyCiagUjemnych (int[] tab){
        int max = 0;
        int teraz = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] < 0){
                teraz++;
                max = Math.max(max, teraz);
            }
            else teraz = 0;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        return max;
    }

    public static void odwrocTablice (int[] tab){
        int[] tab_odwroc = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        int j = 0;
        for (int i = tab.length - 1; i >= 0; i--) {
            tab_odwroc[j] = tab[i];
            j++;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab_odwroc[i] + " ");
        }
    }

    public static void odwrocTabliceIndeks (int[] tab, int start, int stop) {
        int[] tab_odwroc = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < tab.length; i++) {
            if (i<start || i>stop){
                tab_odwroc[i] = tab[i];
            }
        }
        int j = start;
        for (int i = stop; i >= start; i--) {
            tab_odwroc[j] = tab[i];
            j++;
        }

            for (int i = 0; i < tab.length; i++) {
                System.out.print(tab_odwroc[i] + " ");
            }
        }


    public static int[] generujTablicemod (int n, int minWartosc, int maxWartosc){
        int[] tab = new int[n];
        int krok = (maxWartosc - minWartosc) / (n-1);

        for (int i = 0; i < n; i++){
            tab[i] = minWartosc + i * krok;
        }
        for (int i = 0; i < n; i++){
            System.out.print(tab[i] + " ");
        }
        return tab;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj n: ");
        int n = sc.nextInt();
//        System.out.print("Podaj m: ");
//        int m = sc.nextInt();
//        int[] tab = {1,2,3,4,5,6,7,8,9,10};
        System.out.print("Podaj min: ");
        int minWartosc = sc.nextInt();
        System.out.print("Podaj max: ");
        int maxWartosc = sc.nextInt();
//        System.out.println("Podaj a: ");
//        int a = sc.nextInt();
//        System.out.println("Podaj b: ");
//        int b = sc.nextInt();
//        System.out.println("Podaj c: ");
//        int c = sc.nextInt();
        System.out.print("Podaj start indeks: ");
        int start = sc.nextInt();
        System.out.print("Podaj stop indeks: ");
        int stop = sc.nextInt();
//        generujTablice(n, minWartosc, maxWartosc);
//        wypiszTablice(tab, n, m);
//        double zwroc = sredniaHarmoniczna(generujTablice(n,minWartosc,maxWartosc));
//        System.out.println("Zwroc: " + zwroc);
//        generujTablicemod(n, minWartosc, maxWartosc);
//        int[] zwroc1 = funkcjaWykladnicza(generujTablice(n,minWartosc,maxWartosc),a);
//        System.out.println("Zwroc: " + zwroc1);
//        int zwroc2 = najdluzszyCiagDodatnich(generujTablice(n,minWartosc,maxWartosc));
//        System.out.print("Zwroc: " + zwroc2);
        odwrocTabliceIndeks(generujTablice(n,minWartosc,maxWartosc),start,stop);
    }
}

