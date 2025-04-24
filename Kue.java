/**
 * Kue.java
 * 
 * Kelas abstrak yang merepresentasikan kue secara umum.
 * Kelas ini berfungsi sebagai kelas dasar (parent class) untuk jenis-jenis kue yang lebih spesifik.
 * Sebagai kelas abstrak, kelas ini tidak dapat diinstansiasi secara langsung.
 * 
 * Atribut:
 * - nama: menyimpan nama dari kue
 * - harga: menyimpan harga dasar kue per satuan (belum dihitung total)
 * 
 * Method:
 * - hitungHarga(): method abstrak yang akan diimplementasikan oleh subclass
 * - toString(): method untuk menampilkan informasi kue (override dari Object)
 */
public abstract class Kue {
    // Atribut protected agar dapat diakses langsung oleh subclass
    protected String nama;
    protected double harga;
    
    /**
     * Constructor untuk kelas Kue
     * 
     * Parameter:
     * nama  - Nama kue
     * harga - Harga dasar kue (per satuan)
     */
    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    /**
     * Method abstrak untuk menghitung harga total kue.
     * Setiap subclass harus mengimplementasikan method ini sesuai dengan
     * cara perhitungan harga yang berbeda-beda.
     * 
     * Return:
     * Harga total dari kue
     */
    public abstract double hitungHarga();
    
    /**
     * Method untuk menampilkan informasi kue
     * 
     * Return:
     * String berisi informasi nama dan harga dasar kue
     */
    public String toString() {
        return "Nama: " + nama + ", Harga: " + harga;
    }
}