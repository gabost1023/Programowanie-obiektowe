import java.util.Scanner;

public class cwiczenia {

    public static boolean czyPalindrom(int n){
        int start = n;
        int odwrotna = 0;
        while(n>0){
            odwrotna = odwrotna * 10 + n % 10;
            System.out.println("Odwrotna: " + odwrotna);
            n = n / 10;
            System.out.println("n: " + n);
        }
        int pierwsza_cyfra = odwrotna % 10;
        System.out.println("Odwrocona liczba: " + odwrotna);
        System.out.println("Pierwsza cyfra: " + pierwsza_cyfra);
        return start == odwrotna;
    }
    static int silnia(int n){
        int sil = 1;
        for (int i = 1; i<=n; i++){
            sil *= i;
        }
        return sil;
    }

    static int dwumianNewtona(int n, int k){
        int newton = silnia(n)/(silnia(k)*silnia(n-k));
        return newton;
    }

    public static void trojkatPascala(int n){
        for (int i = 0; i < n; i++){
            for (int k = 0; k < n - i; k++){
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++){
                System.out.print(dwumianNewtona(i,j)+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj n: ");
        int n = sc.nextInt();
//        System.out.println(czyPalindrom(n));
        trojkatPascala(n);
    }
}
