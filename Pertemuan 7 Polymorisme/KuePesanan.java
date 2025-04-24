/**
 * KuePesanan.java
 * 
 * Kelas KuePesanan merupakan subclass dari kelas abstrak Kue.
 * Kelas ini merepresentasikan kue yang dibuat berdasarkan pesanan,
 * di mana harga totalnya dihitung berdasarkan harga dasar dikalikan dengan berat kue.
 * 
 * Contoh kue pesanan: kue ulang tahun, kue pernikahan, dll yang biasanya dihitung per kilogram.
 * 
 * Atribut tambahan:
 * - berat: menyimpan berat kue dalam kilogram
 */
public class KuePesanan extends Kue {
    private double berat; // dalam kilogram
    
    /**
     * Constructor untuk kelas KuePesanan
     * 
     * Parameter:
     * nama  - Nama kue pesanan
     * harga - Harga dasar kue per kilogram
     * berat - Berat kue dalam kilogram
     */
    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga); // Memanggil constructor dari superclass (Kue)
        this.berat = berat;
    }
    
    /**
     * Method untuk mendapatkan berat kue
     * 
     * Return:
     * Berat kue dalam kilogram
     */
    public double getBerat() {
        return berat;
    }
    
    /**
     * Implementasi method abstrak hitungHarga() dari kelas Kue
     * Untuk kue pesanan, harga total dihitung dengan: harga dasar × berat
     * 
     * Return:
     * Harga total kue pesanan
     */
    public double hitungHarga() {
        return harga * berat;
    }
    
    /**
     * Override method toString() untuk menampilkan informasi lengkap tentang kue pesanan
     * 
     * Return:
     * String berisi informasi lengkap kue pesanan termasuk berat dan total harga
     */
    public String toString() {
        return super.toString() + ", Berat: " + berat + " kg, Jenis: KuePesanan, Total Harga: " + hitungHarga();
    }
}