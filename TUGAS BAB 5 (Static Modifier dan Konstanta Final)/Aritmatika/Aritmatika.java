public class Aritmatika {
    // Static methods untuk operasi yang tidak membutuhkan objek
    
    /* Method statis untuk melakukan penjumlahan dua bilangan */
    public static int penjumlahan(int a, int b) {
        return a + b;
    }

    /* Method statis untuk melakukan pengurangan dua bilangan */
    public static int pengurangan(int a, int b) {
        return a - b;
    }

    // Non-static methods untuk operasi yang membutuhkan objek
    
    /* Method non-statis untuk melakukan perkalian dua bilangan */
    public int perkalian(int a, int b) {
        return a * b;
    }

    /* Method non-statis untuk melakukan pembagian dua bilangan */
    public double pembagian(int a, int b) {
        if (b == 0) { // Validasi agar tidak terjadi pembagian dengan nol
            System.out.println("Error: Pembagian dengan nol tidak diperbolehkan!");
            return 0;
        }
        return (double) a / b;
    }

    // Method untuk menyederhanakan pecahan
    public void sederhana(int pembilang, int penyebut) {
        if (penyebut == 0) { // Validasi agar tidak terjadi pembagian dengan nol
            System.out.println("Error: Penyebut tidak boleh nol!");
            return;
        }
        
        int gcd = hitungGCD(pembilang, penyebut); // Mencari FPB (Faktor Persekutuan Terbesar)
        int sederhanaPembilang = pembilang / gcd;
        int sederhanaPenyebut = penyebut / gcd;
        
        System.out.printf("Pecahan sederhana: %d/%d\n", 
                         sederhanaPembilang, sederhanaPenyebut);
    }

    // Helper method untuk menghitung GCD (FPB) menggunakan rekursi
    private int hitungGCD(int a, int b) {
        if (b == 0) return a;
        return hitungGCD(b, a % b);
    }
}
