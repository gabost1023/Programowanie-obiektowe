import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int[] generujTablice(int n, int minWartosc, int maxWartosc){
        Random rand = new Random();
        int[] tab = new int[n];
        for (int i = 0; i < n; i++){
            tab[i] = (int) (Math.random() * (maxWartosc-minWartosc+1)) + minWartosc;
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        return tab;
    }

    public static double[] generujZakres(int n, double minWartosc, double maxWartosc){
        double[] tab = new double[n];
        double krok = (maxWartosc-minWartosc)/ (n-1);
        System.out.println("Krok: " + krok);
        for(int i = 0; i < n; i++){
            tab[i] = minWartosc + i * krok;
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        return tab;
    }

    public static int najdluzszyCiagDodatnich(int[] tab){
        int suma = 0;
        int aktualnyciag = 0;

        for(int i = 0; i< tab.length; i++){
            if(tab[i] > 0){
                aktualnyciag++;
                suma = Math.max(suma,aktualnyciag);
            }
            else{
                aktualnyciag = 0;
            }
        }
        System.out.println("NajdluzszyCiagDodatnich: ");
        return suma;
    }

    public static int[] odwrocTablice(int[] tab){
        int j = 0;
        int[] tab_odwroc = new int[tab.length];
        for (int i = tab.length-1; i>=0; i--){
            tab_odwroc[j] = tab[i];
            j++;
            System.out.print(tab[i] + " ");
        }
        return tab_odwroc;
    }
    public static int[] odwrocTabliceIndeks(int[] tab, int start, int stop){
        int[] tab_odwroc = new int[tab.length];
        for(int i = 0; i<start; i++){
            tab_odwroc[i] = tab[i];
        }
        int j = stop;
        for(int i = start; i <= stop; i++){
            tab_odwroc[j] = tab[i];
            j--;
        }
        for(int i = stop + 1; i<tab.length; i++){
            tab_odwroc[i] = tab[i];
        }

        for(int i = 0; i<tab.length; i++){
            System.out.print(tab_odwroc[i] + " ");
        }
        System.out.println();
        return tab_odwroc;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj n: ") ;
        int n = sc.nextInt();
        System.out.println("Podaj min: ") ;
        int minWartosc = sc.nextInt();
        System.out.println("Podaj max: ") ;
        int maxWartosc = sc.nextInt();
//        System.out.println(generujTablice(n,minWartosc,maxWartosc));
//        System.out.println(generujZakres(n, minWartosc, maxWartosc));
//        System.out.println(najdluzszyCiagDodatnich(generujTablice(n,minWartosc,maxWartosc)));
        System.out.println(odwrocTabliceIndeks(generujTablice(n,minWartosc,maxWartosc), 3, 7));

    }
}

