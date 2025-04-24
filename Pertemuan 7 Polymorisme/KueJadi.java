/**
 * KueJadi.java
 * 
 * Kelas KueJadi merupakan subclass dari kelas abstrak Kue.
 * Kelas ini merepresentasikan kue yang sudah jadi dan siap dijual,
 * di mana harga totalnya dihitung berdasarkan harga dasar dikalikan dengan jumlah kue
 * dan dikalikan lagi dengan faktor 2 (sebagai profit margin).
 * 
 * Contoh kue jadi: donat, brownies, cookies, dll yang biasanya dihitung per buah/potong.
 * 
 * Atribut tambahan:
 * - jumlah: menyimpan jumlah kue (dalam buah/potong)
 */
public class KueJadi extends Kue {
    private double jumlah; // dalam buah/potong
    
    /**
     * Constructor untuk kelas KueJadi
     * 
     * Parameter:
     * nama   - Nama kue jadi
     * harga  - Harga dasar per buah/potong
     * jumlah - Jumlah kue dalam buah/potong
     */
    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga); // Memanggil constructor dari superclass (Kue)
        this.jumlah = jumlah;
    }
    
    /**
     * Method untuk mendapatkan jumlah kue
     * 
     * Return:
     * Jumlah kue dalam buah/potong
     */
    public double getJumlah() {
        return jumlah;
    }
    
    /**
     * Implementasi method abstrak hitungHarga() dari kelas Kue
     * Untuk kue jadi, harga total dihitung dengan: harga dasar × jumlah × 2
     * Faktor pengali 2 bisa diinterpretasikan sebagai profit margin
     * 
     * Return:
     * Harga total kue jadi
     */
    public double hitungHarga() {
        return harga * jumlah * 2;
    }
    
    /**
     * Override method toString() untuk menampilkan informasi lengkap tentang kue jadi
     * 
     * Return:
     * String berisi informasi lengkap kue jadi termasuk jumlah dan total harga
     */
    public String toString() {
        return super.toString() + ", Jumlah: " + jumlah + ", Jenis: KueJadi, Total Harga: " + hitungHarga();
    }
}