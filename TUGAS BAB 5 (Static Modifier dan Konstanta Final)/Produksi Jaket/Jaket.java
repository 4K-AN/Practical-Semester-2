import java.util.Scanner; // Mengimpor kelas Scanner untuk input pengguna

// Deklarasi kelas Jaket
public class Jaket {
    // Deklarasi konstanta harga untuk masing-masing jenis jaket
    public static final int HARGA_A = 100000;
    public static final int HARGA_B = 125000;
    public static final int HARGA_C = 175000;

    // Deklarasi konstanta harga diskon untuk pembelian lebih dari 100 unit
    public static final int DISKON_A = 95000;
    public static final int DISKON_B = 120000;
    public static final int DISKON_C = 160000;

    /**
     * Method untuk menghitung total harga berdasarkan jenis jaket dan jumlah pembelian.
     *
     * param jenis  Jenis jaket yang dipilih (A, B, atau C)
     * param jumlah Jumlah jaket yang dibeli
     * return Total harga yang harus dibayar
     */
    public static int hitungHarga(String jenis, int jumlah) {
        int hargaPerUnit; // Variabel untuk menyimpan harga per unit

        // Menggunakan switch-case untuk menentukan harga berdasarkan jenis jaket
        switch (jenis.toUpperCase()) { // Mengubah input menjadi huruf besar agar case-insensitive
            case "A":
                hargaPerUnit = (jumlah > 100) ? DISKON_A : HARGA_A; // Diskon jika >100 unit
                break;
            case "B":
                hargaPerUnit = (jumlah > 100) ? DISKON_B : HARGA_B;
                break;
            case "C":
                hargaPerUnit = (jumlah > 100) ? DISKON_C : HARGA_C;
                break;
            default:
                // Jika jenis jaket tidak valid, lempar exception
                throw new IllegalArgumentException("Jenis jaket tidak valid! Pilih A, B, atau C.");
        }

        return hargaPerUnit * jumlah; // Mengembalikan total harga
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Membuat objek Scanner untuk input dari pengguna

        // Menampilkan daftar harga jaket
        System.out.println("Tipe Jaket dan Harga:");
        System.out.println("A - Rp100,000 (Diskon: Rp95,000 jika >100)");
        System.out.println("B - Rp125,000 (Diskon: Rp120,000 jika >100)");
        System.out.println("C - Rp175,000 (Diskon: Rp160,000 jika >100)");

        // Validasi input jenis jaket
        String jenis;
        while (true) {
            System.out.print("\nPilih jenis jaket (A/B/C): ");
            jenis = input.next().toUpperCase();
            if (jenis.equals("A") || jenis.equals("B") || jenis.equals("C")) {
                break;
            } else {
                System.out.println("Jenis jaket tidak valid! Harap pilih A, B, atau C.");
            }
        }

        // Validasi input jumlah pembelian
        int jumlah;
        while (true) {
            System.out.print("Masukkan jumlah pembelian: ");
            if (input.hasNextInt()) {
                jumlah = input.nextInt();
                if (jumlah > 0) {
                    break;
                } else {
                    System.out.println("Jumlah harus lebih dari 0! Silakan masukkan angka yang valid.");
                }
            } else {
                System.out.println("Input tidak valid! Masukkan angka.");
                input.next(); // Membersihkan Isi
            }
        }

        // Menghitung total harga berdasarkan input pengguna
        int total = hitungHarga(jenis, jumlah);

        // Menampilkan hasil perhitungan harga
        System.out.printf("\nTotal harga untuk %d jaket %s: Rp%,d\n",
                          jumlah, jenis, total);
    }
}
