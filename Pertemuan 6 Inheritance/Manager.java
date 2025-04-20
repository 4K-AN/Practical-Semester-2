// Import library yang diperlukan
import java.text.DecimalFormat;    // Untuk menangani tanggal masuk
import java.time.LocalDate; // Untuk formatting angka

// Kelas Manager mewarisi dari Pekerja
public class Manager extends Pekerja {
    // Variabel instance private
    private String departemen; // Menyimpan nama departemen yang dikelola
    
    // Konstruktor untuk inisialisasi objek Manager
    public Manager(String nama, String nik, boolean jenisKelamin, boolean menikah, 
                  double gaji, LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, nik, jenisKelamin, menikah, gaji, tahunMasuk, jumlahAnak); // Memanggil konstruktor parent class
        this.departemen = departemen;
    }
    
    // Getter untuk departemen
    public String getDepartemen() {
        return departemen;
    }
    
    // Setter untuk departemen
    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }
    
    // Override method tunjangan untuk menambahkan bonus manager
    @Override
    public double getTunjangan() {
        // Tunjangan manager = tunjangan pekerja biasa + 10% dari gaji
        return super.getTunjangan() + (0.1 * getGaji());
    }
    
    // Override method toString untuk representasi string objek
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0"); // Format untuk angka
        return super.toString() + // Memanggil toString() dari parent class
               "\nDepartemen: " + departemen; // Menambahkan info departemen
    }
}

/* PENJELASAN TAMBAHAN:
1. Inheritance: Manager mewarisi semua fitur dari kelas Pekerja
2. Komposisi Tanggal: Menggunakan LocalDate untuk menyimpan tahun masuk secara presisi (tahun-bulan-tanggal)
3. Polimorfisme: Override method getTunjangan() dan toString() untuk menyesuaikan dengan kebutuhan kelas anak
4. Bonus Manager: Tambahan 10% dari gaji sebagai tunjangan khusus manager
5. Encapsulation: Variabel departemen diakses melalui getter/setter
6. Code Reuse: Memanfaatkan method dari parent class (super.getTunjangan() dan super.toString())
*/