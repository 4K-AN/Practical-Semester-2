/*
 * Kelas MahasiswaFILKOM yang mewarisi dari Manusia
 * Mengimplementasikan sistem beasiswa dan status mahasiswa
 */
public class MahasiswaFILKOM extends Manusia {
    private String nim;    // NIM mahasiswa format: 225150700111023
    private double ipk;    // IPK dalam skala 4.0

    // Konstruktor dengan parameter lengkap
    public MahasiswaFILKOM(String nama, String nik, boolean jenisKelamin, 
                          boolean menikah, String nim, double ipk) {
        super(nama, nik, jenisKelamin, menikah);  // Memanggil konstruktor parent
        this.nim = nim;
        this.ipk = ipk;
    }

    // Getter dan setter untuk NIM
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Getter dan setter untuk IPK
    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    /*
     * Method untuk menentukan status prodi dan angkatan
     * Menggunakan logika substring dan switch case
     */
    public String getStatus() {
        String angkatan = "20" + nim.substring(0, 2);  // Ekstrak tahun angkatan
        char kodeProdi = nim.charAt(6);  // Ambil kode prodi dari NIM

        // Switch case untuk konversi kode prodi ke nama jurusan
        String prodi = switch (kodeProdi) {
            case '2' -> "Teknik Informatika";
            case '3' -> "Teknik Komputer";
            case '4' -> "Sistem Informasi";
            case '6' -> "Pendidikan Teknologi Informasi";
            case '7' -> "Teknologi Informasi";
            default -> "Unknown";
        };

        return prodi + ", " + angkatan;
    }

    /*
     * Method untuk menghitung beasiswa berdasarkan IPK
     * Menggunakan range IPK dengan batasan tertentu
     */
    public double getBeasiswa() {
        if (ipk >= 3.0 && ipk < 3.5) return 50;
        else if (ipk >= 3.5 && ipk <= 4.0) return 75;
        return 0;
    }

    /*
     * Override method pendapatan dari parent class
     * Menambahkan beasiswa ke total pendapatan
     */
    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getBeasiswa();
    }

    /*
     * Override method toString untuk menampilkan data lengkap
     * Menggunakan java.text.DecimalFormat secara langsung tanpa import
     */
    @Override
    public String toString() {
        // Menggunakan fully qualified name untuk DecimalFormat
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
        return super.toString() + 
               "\nNIM: " + nim +
               "\nIPK: " + df.format(ipk) +  // Format IPK 1 desimal
               "\nStatus: " + getStatus();
    }
}

