/*
 * Kelas Manager yang mewarisi sifat dari kelas Pekerja.
 * Mengimplementasikan konsep inheritance dan method overriding.
 */
public class Manager extends Pekerja {
    private String departemen; // Menyimpan nama departemen yang dikelola

    /*
     * Konstruktor untuk inisialisasi objek Manager
     * @param tahunMasuk menggunakan tipe data java.time.LocalDate (full qualified name)
     * untuk menghindari import statement
     */
    public Manager(String nama, String nik, boolean jenisKelamin, boolean menikah, 
                  double gaji, java.time.LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, nik, jenisKelamin, menikah, gaji, tahunMasuk, jumlahAnak); // Memanggil konstruktor parent
        this.departemen = departemen;
    }

    // Getter untuk mengakses nilai departemen
    public String getDepartemen() {
        return departemen;
    }

    // Setter untuk mengubah nilai departemen
    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    /*
     * Override method tunjangan dari parent class
     * Menambahkan bonus manager sebesar 10% dari gaji ke tunjangan dasar pekerja
     */
    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (0.1 * getGaji()); // Tunjangan dasar + 10% gaji
    }

    /*
     * Override method toString untuk representasi string objek
     * Menggunakan java.text.DecimalFormat secara langsung tanpa import
     */
    @Override
    public String toString() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0"); // Format angka
        return super.toString() + // Memanggil toString() parent class
               "\nDepartemen: " + departemen; // Menambahkan info departemen
    }
}

/* KONSEP OOP YANG DIGUNAKAN:
1. Inheritance - Manager mewarisi Pekerja menggunakan 'extends'
2. Encapsulation - Variabel departemen diproteksi dan diakses via getter/setter
3. Polymorphism - Override method getTunjangan() dan toString()
4. Code Reusability - Memanfaatkan method superclass dengan super.getTunjangan() dan super.toString()
5. Tanpa Import Statement - Menggunakan full package path untuk LocalDate dan DecimalFormat
*/