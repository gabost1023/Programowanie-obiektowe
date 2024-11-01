import java.util.Scanner;

public class Zestaw3 {
//cw1
    static void trojkiPitagorejskie(int n){

        for (int i = 0; i<=n; i++){
            for (int j = 0 ; j<=n; j++){
                for (int k = 0; k<=n; k++){
                    if (i * i + j * j == k * k && i<j && j<k){
                        System.out.println(i + " " + j + " "+ k);
                    }
                }
            }
        }
    }

//cw2
    static void funKwaRozwiazania (int n){
        for (int i = 1; i<=n; i++){
            for (int j = 0; j<=n; j++){
                for (int k = 0; k<=n; k++){
                    int delta = j*j - 4 * i * k;
                    if (delta >= 0){
                        System.out.println("a: " + i + " b: " + j + " c: " + k);
                    }
                }
            }
        }
    }


//cw3
static void funKwaDelta (int n){
    for (int i = 1; i<=n; i++){
        for (int j = 0; j<=n; j++){
            for (int k = 0; k<=n; k++){
                int delta = j*j - 4 * i * k;
                double delta_pierw = Math.sqrt(delta);
                if (delta >= 0 && delta_pierw == (int) delta_pierw) {
                    System.out.println("a: " + i + " b: " + j + " c: " + k);
                }
            }
        }
    }
}

//cw4
    static void liczbyPierwsze (int n){
        for(int i=2; i<=n; i++){
            boolean czy_pierwsza = true;
            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    czy_pierwsza = false;
                }
            }
            if (czy_pierwsza){System.out.println(i + " ");}
        }
    }

//cw5
    static void liczbyPodzielne (int m, int n) {
        int najmniejsza = (int) Math.pow(10, (m-1));
        System.out.println("Najmniejsza: " + najmniejsza);
        int najwieksza = (int) (Math.pow(10,m) - 1);
        System.out.println("Najwieksza: " + najwieksza);

        for (int i = najmniejsza; i <= najwieksza; i++) {
            if (i % n == 0){
                System.out.println(i);
            }
        }
    }

//cw6
    static void piramida (int n, int variant){
        if (variant == 1){
            for (int i = 0; i < n; i++){
                for (int j = 0; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
        else if (variant == 2){
            for (int i = 0; i < n; i++){
                for(int k = 0; k < (n - i - 1); k++) {
                    System.out.print(" ");
                }
                    for (int j = 0; j <= 2 * i; j++) {
                        System.out.print("*");
                    }
                System.out.println("");
            }
        }
    }

    //cw7
    static int silnia(int n){
        int sil = 1;
        for (int i = 1; i<=n; i++){
            sil *= i;
        }
        return sil;
    }

    //cw8
    static int silniaPodwojna(int n){
        int sil2 = 1;
        for (int i = 1; i<=n; i += 2){
            sil2 *= i;
            System.out.println(i);
        }
        return sil2;
    }

//cw9
    static int silniam(int n, int m){
        int silm = 1;
        for (int i = 1; i<=n; i += m){
            silm *= i;
            System.out.println(i);
        }
        return silm;
    }

//cw10
    static int dwumianNewtona(int n, int k){
        int newton = silnia(n)/(silnia(k)*silnia(n-k));
        return newton;
    }

//cw11
    static int fibbonacci(int n){
        if(n<=1){
            return n;
        }
        return fibbonacci(n-1) + fibbonacci(n-2);
    }

    static void ciagiFibbonacciego(int n){
        for (int i=0; i<n; i++){
            System.out.println(fibbonacci(i));
        }
    }

//cw12
    static int sumaNaturalnych(int n){
        int suma = 0;
        for (int i = 1; i<=n; i++){
            suma += i;
        }
        return suma;
    }

    static int sumaParzystych(int n){
        int suma = 0;
        for (int i = 1; i<=n; i++){
            if(i % 2 == 0){
                suma += i;
            }
        }
        return suma;
    }

    static int sumaNieparzystych(int n){
        int suma = 0;
        for (int i = 1; i<=n; i++){
            if(i % 2 != 0){
                suma += i;
            }
        }
        return suma;
    }

    static int sumaKwaNaturalnych(int n){
        int suma = 0;
        for (int i = 1; i<=n; i++){
            suma += i*i;
        }
        return suma;
    }

    static int sumaSzeNaturalnych(int n){
        int suma = 0;
        for (int i = 1; i<=n; i++){
            suma += i*i*i;
        }
        return suma;
    }

    static double sumaOdwNaturalnych(int n){
        double suma = 0;
        for (int i = 1; i<=n; i++){
            suma += Math.pow(i,-1);
        }
        return suma;
    }

//cw13

    static boolean czyPalindr(String wyraz){
        String odwrocony = new StringBuilder(wyraz).reverse().toString();
        return odwrocony.equals(wyraz);
    }

//cw15
    static boolean czyPalindrom(int n){
        int start = n;
        int odwrocona = 0;
        while (n != 0) {
            int cyfra = n % 10;
            odwrocona = odwrocona * 10 + cyfra;
            n /= 10;
        }

            return odwrocona == start;
        }

//cw16
    static boolean czyDoskonala(int n){
        int suma = 0;
        for (int i = 1; i<n; i++){
            if(n % i == 0){
                suma += i;
            }
        }
        return suma == n;
    }

//cw17
    static boolean czyPierwsza(int n){
        boolean czy_pierwsza = true;
        for (int i = 2; i<n; i++){
            if (n % i == 0){
                czy_pierwsza = false;
            }
        }
        return czy_pierwsza;
    }

//cw18
    static int NWD(int n, int m){
        while (n != m){
            if (n > m){
                n = n - m;
            }
            else m = m - n;
        }
        return n;
    }

//cw19
    static void wczytajTablice(int n){
        int[] tablica = new int[n];
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj n liczb:");
        for (int i = 0; i < n; i++){
            tablica[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            System.out.print(tablica[i] + " ");
        }
    }

//cw20
    static void podzbiory(int[] tab){
        generuj(tab, 0, "");
    }

    static void generuj(int[] tab, int i, String klamerki){
        if (i == tab.length){
            System.out.println("{" + klamerki.trim() + "}");
            return;
        }

        generuj(tab, i + 1, klamerki);
        generuj(tab, i + 1, klamerki + tab[i] + " ");
    }



    public static void main(String[] args)
    {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Podaj n: ") ;
//        int n = sc.nextInt();
//        System.out.println("Podaj wyraz: ");
//        String wyraz = sc.nextLine();
//        System.out.println("Podaj m: ") ;
//        int m = sc.nextInt();
//        System.out.println("Podaj variant: ") ;
//        int variant = sc.nextInt();
//        System.out.println("Podaj k: ") ;
//        int k = sc.nextInt();
//        int[] tab = {10,1,3,5,6,8,0};
//        System.out.println(czyPalindrom(n));
//        System.out.println(silnia(n));
//        System.out.println(dwumianNewtona(n, k))
//        trojkiPitagorejskie(n);
//        funKwaRozwiazania(n);
//        funKwaDelta(n);
//        liczbyPierwsze(n);
//        liczbyPodzielne(m, n);
//        piramida(n,variant);
//        System.out.println(silniaPodwojna(n)) ;
//        System.out.println(silniam(n,m)) ;
//        ciagiFibbonacciego(n);
//        System.out.println(sumaNaturalnych(n)) ;
//        System.out.println(sumaParzystych(n)) ;
//        System.out.println(sumaNieparzystych(n)) ;
//        System.out.println(sumaKwaNaturalnych(n)) ;
//        System.out.println(sumaSzeNaturalnych(n)) ;
//        System.out.println(sumaOdwNaturalnych(n)) ;
//        System.out.println(czyPalindr(wyraz)) ;
//        System.out.println(czyDoskonala(n)) ;
//        System.out.println(czyPierwsza(n)) ;
//        System.out.println(NWD(n,m)) ;
//        wczytajTablice(n);
//        podzbiory(tab);
    }
}

