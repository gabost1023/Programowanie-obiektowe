import java.util.Scanner;

public class Main {
//cw1
    public static void trojkiPitagorejskie(int n){

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


//cw7
    static int silnia(int n){
        int sil = 1;
        for (int i = 1; i<=n; i++){
            sil *= i;
        }
        return sil;
    }

//cw10
    static int dwumianNewtona(int n, int k){
        int newton = silnia(n)/(silnia(k)*silnia(n-k));
        return newton;
    }

//cw15
//    static boolean czyPalindrom(int n){
//        int start = n;
//        int odwrocona = 0;
//        while (n != 0) {
//            int cyfra = n % 10;
//            odwrocona = odwrocona * 10 + cyfra;
//            n /= 10;
//        }
//
//            return odwrocona == start;
//        }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj n: ") ;
        int n = sc.nextInt();
//        System.out.println("Podaj k: ") ;
//        int k = sc.nextInt();
//        System.out.println(czyPalindrom(n));
//        System.out.println(silnia(n));
//        System.out.println(dwumianNewtona(n, k))
          trojkiPitagorejskie(n);
    }
}

