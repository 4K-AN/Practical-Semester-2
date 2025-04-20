// Import library untuk formatting angka
import java.text.DecimalFormat;

// Kelas dasar yang merepresentasikan manusia
public class Manusia {
    // Deklarasi variabel instance
    private String nama;           // Menyimpan nama lengkap
    private boolean jenisKelamin;  // True: Laki-laki, False: Perempuan
    private String nik;            // Nomor Induk Kependudukan
    private boolean menikah;       // Status pernikahan
    
    // Konstruktor untuk inisialisasi objek Manusia
    public Manusia(String nama, String nik, boolean jenisKelamin, boolean menikah) {
        this.nama = nama;
        this.nik = nik;
        this.jenisKelamin = jenisKelamin;
        this.menikah = menikah;
    }
    
    /* 
    =============== GETTER & SETTER ===============
    Method untuk mengakses dan mengubah data secara terkontrol
    */
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    // 'is' digunakan karena return type boolean
    public boolean isJenisKelamin() {
        return jenisKelamin;
    }
    
    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    public String getNik() {
        return nik;
    }
    
    public void setNik(String nik) {
        this.nik = nik;
    }
    
    public boolean isMenikah() {
        return menikah;
    }
    
    public void setMenikah(boolean menikah) {
        this.menikah = menikah;
    }
    
    // Method menghitung tunjangan berdasarkan status
    public double getTunjangan() {
        if (menikah) {
            // Ternary operator: (kondisi) ? true : false
            return jenisKelamin ? 25 : 20;  // Laki-laki $25, Perempuan $20
        } else {
            return 15;  // Belum menikah $15
        }
    }
    
    // Method pendapatan total (di kelas turunan bisa ditambah komponen lain)
    public double getPendapatan() {
        return getTunjangan();  // Mengembalikan tunjangan sebagai pendapatan dasar
    }
    
    // Override method toString() untuk representasi string objek
    @Override
    public String toString() {
        // Konversi boolean jenis kelamin ke string
        String jk = jenisKelamin ? "Laki-laki" : "Perempuan";
        DecimalFormat df = new DecimalFormat("#.0");  // Format 1 desimal
        
        return "Nama: " + nama + 
               "\nNIK: " + nik + 
               "\nJenis Kelamin: " + jk + 
               "\nPendapatan: $" + df.format(getPendapatan());
    }
}

/*
KONSEP OOP YANG DIGUNAKAN:
1. Encapsulation: Data dibungkus dalam variabel private dengan akses melalui getter/setter
2. Inheritance: Kelas ini dirancang untuk diwariskan ke subclass (lihat MahasiswaFILKOM dan Manager)
3. Polymorphism: Method getPendapatan() dan toString() bisa di-override di subclass
4. Information Hiding: Detail implementasi tunjangan disembunyikan dari user
5. Code Reusability: Fungsi dasar manusia bisa digunakan kembali di kelas turunan
*/