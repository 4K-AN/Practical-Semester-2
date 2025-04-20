// Import library untuk formatting angka
import java.text.DecimalFormat;

// Kelas MahasiswaFILKOM mewarisi dari kelas Manusia
public class MahasiswaFILKOM extends Manusia {
    // Variabel instance private
    private String nim;    // Menyimpan NIM mahasiswa
    private double ipk;    // Menyimpan IPK mahasiswa
    
    // Konstruktor untuk inisialisasi objek MahasiswaFILKOM
    public MahasiswaFILKOM(String nama, String nik, boolean jenisKelamin, boolean menikah, String nim, double ipk) {
        super(nama, nik, jenisKelamin, menikah);  // Memanggil konstruktor parent class
        this.nim = nim;
        this.ipk = ipk;
    }
    
    // Getter dan Setter untuk NIM
    public String getNim() {
        return nim;
    }
    
    public void setNim(String nim) {
        this.nim = nim;
    }
    
    // Getter dan Setter untuk IPK
    public double getIpk() {
        return ipk;
    }
    
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }
    
    // Method untuk mendapatkan status prodi dan angkatan
    public String getStatus() {
        String angkatan = "20" + nim.substring(0, 2);  // Ekstrak tahun angkatan dari NIM
        char kodeProdi = nim.charAt(6);  // Ambil karakter ke-7 untuk kode prodi
        
        String prodi;
        // Switch case untuk menentukan nama prodi berdasarkan kode
        switch (kodeProdi) {
            case '2':
                prodi = "Teknik Informatika";
                break;
            case '3':
                prodi = "Teknik Komputer";
                break;
            case '4':
                prodi = "Sistem Informasi";
                break;
            case '6':
                prodi = "Pendidikan Teknologi Informasi";
                break;
            case '7':
                prodi = "Teknologi Informasi";
                break;
            default:
                prodi = "Unknown";  // Default jika kode tidak dikenali
        }
        
        return prodi + ", " + angkatan;  // Format output: Prodi, Tahun Angkatan
    }
    
    // Method untuk menghitung besaran beasiswa berdasarkan IPK
    public double getBeasiswa() {
        if (ipk >= 3.0 && ipk < 3.5) {
            return 50;  // Beasiswa 50 untuk IPK 3.0-3.49
        } else if (ipk >= 3.5 && ipk <= 4.0) {
            return 75;  // Beasiswa 75 untuk IPK 3.5-4.0
        } else {
            return 0;   // Tidak dapat beasiswa jika IPK < 3.0
        }
    }
    
    // Override method getPendapatan dari parent class
    @Override
    public double getPendapatan() {
        // Total pendapatan = pendapatan manusia + beasiswa
        return super.getPendapatan() + getBeasiswa();
    }
    
    // Override method toString untuk representasi string objek
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0");  // Format IPK 1 desimal
        return super.toString() + 
               "\nNIM: " + nim +          // Menampilkan NIM
               "\nIPK: " + df.format(ipk) +  // Menampilkan IPK diformat
               "\nStatus: " + getStatus();  // Menampilkan status prodi & angkatan
    }
}