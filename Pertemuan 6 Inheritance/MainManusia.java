import java.util.Scanner; // Import Scanner untuk input dari user
import java.time.LocalDate; // Import LocalDate untuk menangani tanggal masuk kerja

public class MainManusia {
    public static void main(String[] args) {
        /* =======================
           BAGIAN 1: TEST CASE
           Menampilkan hasil dari objek-objek
           yang dibuat secara hardcoded (tetap)
        ========================== */

        System.out.println("=== TEST CASE OTOMATIS DARI SISTEM ===");

        // Membuat objek Manusia (dengan data tetap)
        Manusia test1 = new Manusia("Akhmad", "123456789", true, true);
        System.out.println(test1); // Menampilkan data objek test1

        // Membuat objek MahasiswaFILKOM
        MahasiswaFILKOM test2 = new MahasiswaFILKOM("Dian", "987654321", false, false, "225150700111023", 3.9);
        System.out.println(test2);

        // Membuat objek Pekerja
        Pekerja test3 = new Pekerja("Budi", "111222333", true, true, 5000, LocalDate.of(2020, 4, 10), 2);
        System.out.println(test3);

        // Membuat objek Manager
        Manager test4 = new Manager("Sari", "444555666", false, true, 8000, LocalDate.of(2018, 2, 15), 1, "IT");
        System.out.println(test4);

        System.out.println("\n=== SELESAI TEST CASE ===\n");

        /* =======================
           BAGIAN 2: INPUT USER
           Meminta user memasukkan data,
           lalu membuat objek dari data tersebut
        ========================== */

        Scanner input = new Scanner(System.in); // Scanner untuk input user

        System.out.println("=== INPUT DATA DARI USER ===");

        // ====== Input Data Manusia ======
        System.out.println("\n-- Input Data Manusia --");
        System.out.print("Nama: ");
        String nama = input.nextLine(); // Input nama
        System.out.print("NIK: ");
        String nik = input.nextLine(); // Input NIK
        System.out.print("Jenis Kelamin (true = Laki-laki, false = Perempuan): ");
        boolean jk = input.nextBoolean(); // Input jenis kelamin
        System.out.print("Sudah menikah? (true/false): ");
        boolean menikah = input.nextBoolean(); // Input status pernikahan

        // Membuat objek manusia dari input user
        Manusia manusiaInput = new Manusia(nama, nik, jk, menikah);
        System.out.println("\nData Manusia dari User:");
        System.out.println(manusiaInput); // Menampilkan hasil input manusia

        // ====== Input Data Mahasiswa FILKOM ======
        input.nextLine(); // Menghapus newline tersisa
        System.out.println("\n-- Input Data Mahasiswa FILKOM --");
        System.out.print("Nama: ");
        nama = input.nextLine();
        System.out.print("NIK: ");
        nik = input.nextLine();
        System.out.print("Jenis Kelamin (true = Laki-laki, false = Perempuan): ");
        jk = input.nextBoolean();
        System.out.print("Sudah menikah? (true/false): ");
        menikah = input.nextBoolean();
        input.nextLine(); // Hapus newline
        System.out.print("NIM: ");
        String nim = input.nextLine();
        System.out.print("IPK: ");
        double ipk = input.nextDouble(); // Input IPK mahasiswa

        MahasiswaFILKOM mhsInput = new MahasiswaFILKOM(nama, nik, jk, menikah, nim, ipk);
        System.out.println("\nData Mahasiswa dari User:");
        System.out.println(mhsInput); // Menampilkan hasil input mahasiswa

        // ====== Input Data Pekerja ======
        input.nextLine(); // Bersihkan buffer
        System.out.println("\n-- Input Data Pekerja --");
        System.out.print("Nama: ");
        nama = input.nextLine();
        System.out.print("NIK: ");
        nik = input.nextLine();
        System.out.print("Jenis Kelamin (true = Laki-laki, false = Perempuan): ");
        jk = input.nextBoolean();
        System.out.print("Sudah menikah? (true/false): ");
        menikah = input.nextBoolean();
        System.out.print("Gaji: ");
        int gaji = input.nextInt(); // Input gaji per bulan
        input.nextLine(); // Bersihkan newline
        System.out.print("Tanggal Masuk (YYYY-MM-DD): ");
        String tgl = input.nextLine(); // Input string tanggal
        LocalDate tanggalMasuk = LocalDate.parse(tgl); // Konversi ke LocalDate
        System.out.print("Jumlah anak: ");
        int anak = input.nextInt(); // Input jumlah anak

        Pekerja pekerjaInput = new Pekerja(nama, nik, jk, menikah, gaji, tanggalMasuk, anak);
        System.out.println("\nData Pekerja dari User:");
        System.out.println(pekerjaInput);

        // ====== Input Data Manager ======
        input.nextLine(); // Bersihkan buffer
        System.out.println("\n-- Input Data Manager --");
        System.out.print("Nama: ");
        nama = input.nextLine();
        System.out.print("NIK: ");
        nik = input.nextLine();
        System.out.print("Jenis Kelamin (true = Laki-laki, false = Perempuan): ");
        jk = input.nextBoolean();
        System.out.print("Sudah menikah? (true/false): ");
        menikah = input.nextBoolean();
        System.out.print("Gaji: ");
        gaji = input.nextInt();
        input.nextLine(); // Bersihkan newline
        System.out.print("Tanggal Masuk (YYYY-MM-DD): ");
        tgl = input.nextLine();
        tanggalMasuk = LocalDate.parse(tgl); // Parse tanggal masuk
        System.out.print("Jumlah anak: ");
        anak = input.nextInt();
        input.nextLine(); // Bersihkan newline
        System.out.print("Departemen: ");
        String dept = input.nextLine(); // Input departemen

        Manager managerInput = new Manager(nama, nik, jk, menikah, gaji, tanggalMasuk, anak, dept);
        System.out.println("\nData Manager dari User:");
        System.out.println(managerInput);

        input.close(); // Menutup Scanner
    }
}
