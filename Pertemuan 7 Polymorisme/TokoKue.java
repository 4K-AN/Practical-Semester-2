/**
 * TokoKue.java
 * 
 * Kelas utama yang berisi method main() untuk menjalankan program toko kue.
 * Kelas ini berisi implementasi untuk:
 * 1. Membuat array berisi 20 objek kue (campuran KuePesanan dan KueJadi)
 * 2. Menampilkan seluruh data kue beserta jenisnya
 * 3. Menghitung total harga dari semua jenis kue
 * 4. Menghitung total harga dan total berat dari KuePesanan
 * 5. Menghitung total harga dan total jumlah dari KueJadi
 * 6. Menampilkan informasi kue dengan harga terbesar
 * 
 * Kelas ini mendemonstrasikan konsep polimorfisme, di mana objek dari kelas turunan
 * (KuePesanan dan KueJadi) dapat diperlakukan sebagai objek dari kelas dasar (Kue).
 */
public class TokoKue {
    public static void main(String[] args) {
        // Membuat array 20 kue
        Kue[] daftarKue = new Kue[20];
        
        // Mengisi array dengan berbagai jenis kue (10 KuePesanan dan 10 KueJadi)
        // Contoh polimorfisme: array bertipe Kue dapat menyimpan objek dari subclassnya
        daftarKue[0] = new KuePesanan("Bolu Coklat", 15000, 0.5);
        daftarKue[1] = new KueJadi("Donat", 3500, 10);
        daftarKue[2] = new KuePesanan("Kue Lapis", 20000, 0.3);
        daftarKue[3] = new KueJadi("Croissant", 8000, 5);
        daftarKue[4] = new KuePesanan("Black Forest", 25000, 1.0);
        daftarKue[5] = new KueJadi("Roti Tawar", 10000, 2);
        daftarKue[6] = new KuePesanan("Kue Tart", 50000, 1.5);
        daftarKue[7] = new KueJadi("Brownies", 7000, 8);
        daftarKue[8] = new KuePesanan("Cheese Cake", 35000, 0.8);
        daftarKue[9] = new KueJadi("Cookies", 2000, 20);
        daftarKue[10] = new KuePesanan("Tiramisu", 40000, 0.6);
        daftarKue[11] = new KueJadi("Muffin", 5000, 12);
        daftarKue[12] = new KuePesanan("Red Velvet", 30000, 1.2);
        daftarKue[13] = new KueJadi("Kue Cubit", 1000, 25);
        daftarKue[14] = new KuePesanan("Rainbow Cake", 45000, 0.7);
        daftarKue[15] = new KueJadi("Kue Putu", 2500, 15);
        daftarKue[16] = new KuePesanan("Pavlova", 60000, 0.4);
        daftarKue[17] = new KueJadi("Pancake", 6000, 6);
        daftarKue[18] = new KuePesanan("Opera Cake", 55000, 0.5);
        daftarKue[19] = new KueJadi("Kue Lumpur", 3000, 18);
        
        // a. Menampilkan semua kue beserta jenisnya
        // Contoh polimorfisme: method toString() dipanggil sesuai dengan implementasi di masing-masing kelas
        System.out.println("=== DAFTAR SEMUA KUE ===");
        for (Kue kue : daftarKue) {
            System.out.println(kue.toString());
        }
        System.out.println();
        
        // b. Menghitung total harga dari semua jenis kue
        // Contoh polimorfisme: method hitungHarga() dipanggil sesuai dengan implementasi di masing-masing kelas
        double totalHargaSemuaKue = 0;
        for (Kue kue : daftarKue) {
            totalHargaSemuaKue += kue.hitungHarga();
        }
        System.out.println("Total Harga Semua Kue: Rp " + totalHargaSemuaKue);
        System.out.println();
        
        // c. Menghitung total harga dan total berat dari KuePesanan
        // Penggunaan instanceof untuk identifikasi tipe objek sebenarnya
        double totalHargaKuePesanan = 0;
        double totalBeratKuePesanan = 0;
        for (Kue kue : daftarKue) {
            if (kue instanceof KuePesanan) {
                // Type casting dari Kue ke KuePesanan untuk mengakses method getBerat()
                KuePesanan kuePesanan = (KuePesanan) kue;
                totalHargaKuePesanan += kuePesanan.hitungHarga();
                totalBeratKuePesanan += kuePesanan.getBerat();
            }
        }
        System.out.println("Total Harga KuePesanan: Rp " + totalHargaKuePesanan);
        System.out.println("Total Berat KuePesanan: " + totalBeratKuePesanan + " kg");
        System.out.println();
        
        // d. Menghitung total harga dan total jumlah dari KueJadi
        // Penggunaan instanceof untuk identifikasi tipe objek sebenarnya
        double totalHargaKueJadi = 0;
        double totalJumlahKueJadi = 0;
        for (Kue kue : daftarKue) {
            if (kue instanceof KueJadi) {
                // Type casting dari Kue ke KueJadi untuk mengakses method getJumlah()
                KueJadi kueJadi = (KueJadi) kue;
                totalHargaKueJadi += kueJadi.hitungHarga();
                totalJumlahKueJadi += kueJadi.getJumlah();
            }
        }
        System.out.println("Total Harga KueJadi: Rp " + totalHargaKueJadi);
        System.out.println("Total Jumlah KueJadi: " + totalJumlahKueJadi);
        System.out.println();
        
        // e. Mencari kue dengan harga akhir terbesar
        double hargaTerbesar = 0;
        Kue kueTermahal = null;
        for (Kue kue : daftarKue) {
            if (kue.hitungHarga() > hargaTerbesar) {
                hargaTerbesar = kue.hitungHarga();
                kueTermahal = kue;
            }
        }
        System.out.println("=== KUE DENGAN HARGA TERBESAR ===");
        System.out.println(kueTermahal.toString());
    }
}