import java.util.Scanner; // Mengimpor kelas Scanner untuk input dari pengguna

public class MainAritmatika {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Membuat objek Scanner untuk input
        Aritmatika arit = new Aritmatika(); // Membuat objek dari class Aritmatika

        // Input untuk operasi dasar
        System.out.print("Masukkan bilangan pertama: ");
        int num1 = input.nextInt();
        System.out.print("Masukkan bilangan kedua: ");
        int num2 = input.nextInt();

        // Memanggil method statis tanpa perlu objek
        System.out.println("Hasil penjumlahan: " + Aritmatika.penjumlahan(num1, num2));
        System.out.println("Hasil pengurangan: " + Aritmatika.pengurangan(num1, num2));

        // Memanggil method non-statis menggunakan objek
        System.out.println("Hasil perkalian: " + arit.perkalian(num1, num2));
        System.out.printf("Hasil pembagian: %.2f\n", arit.pembagian(num1, num2));

        // Input untuk penyederhanaan pecahan
        System.out.print("\nMasukkan pembilang: ");
        int pembilang = input.nextInt();
        System.out.print("Masukkan penyebut: ");
        int penyebut = input.nextInt();
        
        arit.sederhana(pembilang, penyebut); // Memanggil method untuk menyederhanakan pecahan
    }
}
