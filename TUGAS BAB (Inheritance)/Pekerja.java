// Pekerja.java
import java.text.DecimalFormat;       // Import untuk menggunakan kelas LocalDate
import java.time.LocalDate;          // Import untuk menghitung periode waktu
import java.time.Period;   // Import untuk memformat angka desimal

// Kelas Pekerja sebagai turunan dari kelas Manusia
public class Pekerja extends Manusia {
    // Deklarasi atribut private
    private double gaji;          // Gaji dasar pekerja
    private LocalDate tahunMasuk; // Tanggal mulai bekerja
    private int jumlahAnak;       // Jumlah anak
    
    /* 
     * Constructor kelas Pekerja
     * Menerima parameter nama, nik, jenisKelamin, status menikah,
     * gaji, tahun masuk kerja, dan jumlah anak
     */
    public Pekerja(String nama, String nik, boolean jenisKelamin, boolean menikah, 
                   double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, nik, jenisKelamin, menikah);  // Memanggil constructor kelas induk
        this.gaji = gaji;                         // Inisialisasi gaji
        this.tahunMasuk = tahunMasuk;             // Inisialisasi tahun masuk
        this.jumlahAnak = jumlahAnak;             // Inisialisasi jumlah anak
    }
    
    // Getter untuk mendapatkan nilai gaji
    public double getGaji() {
        return gaji;
    }
    
    // Setter untuk mengubah nilai gaji
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    
    // Getter untuk mendapatkan tahun masuk
    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }
    
    // Setter untuk mengubah tahun masuk
    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }
    
    // Getter untuk mendapatkan jumlah anak
    public int getJumlahAnak() {
        return jumlahAnak;
    }
    
    // Setter untuk mengubah jumlah anak
    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }
    
    /*
     * Method untuk menghitung lama bekerja dalam tahun
     * Menggunakan Period.between() untuk menghitung selisih waktu
     * antara tahun masuk dengan waktu sekarang
     */
    public int getLamaBekerja() {
        return Period.between(tahunMasuk, LocalDate.now()).getYears();
    }
    
    /*
     * Method untuk menghitung bonus berdasarkan lama bekerja:
     * - 0-5 tahun: 5% dari gaji
     * - 5-10 tahun: 10% dari gaji
     * - >10 tahun: 15% dari gaji
     */
    public double getBonus() {
        int lamaBekerja = getLamaBekerja();
        
        if (lamaBekerja >= 0 && lamaBekerja < 5) {
            return 0.05 * gaji;
        } else if (lamaBekerja >= 5 && lamaBekerja < 10) {
            return 0.1 * gaji;
        } else {
            return 0.15 * gaji;
        }
    }
    
    /*
     * Override method getTunjangan() dari kelas induk
     * Menambahkan tunjangan anak sebesar $20 per anak
     * ke tunjangan dasar dari kelas Manusia
     */
    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20);
    }
    
    /*
     * Override method getPendapatan() dari kelas induk
     * Total pendapatan = tunjangan dasar + gaji + bonus
     */
    @Override
    public double getPendapatan() {
        return super.getTunjangan() + gaji + getBonus();
    }
    
    /*
     * Override method toString() untuk menampilkan informasi Pekerja
     * Memanggil toString() dari kelas induk (Manusia)
     * Menambahkan informasi tahun masuk, jumlah anak, dan gaji
     * Menggunakan DecimalFormat untuk memformat tampilan angka gaji
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0");
        return super.toString() + "\nTahun Masuk: " + tahunMasuk + 
               "\nJumlah Anak: " + jumlahAnak + "\nGaji: $" + df.format(gaji);
    }
}