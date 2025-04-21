/*
 * Kelas utama untuk testing sistem Manusia-Pekerja-Manager
 * Mengimplementasikan input user dan test case tanpa menggunakan import statement
 */
public class MainManusia {
    public static void main(String[] args) {
        // =======================
        // BAGIAN 1: TEST CASE
        // =======================
        System.out.println("=== TEST CASE OTOMATIS DARI SISTEM ===");

        // Membuat objek dengan data tetap menggunakan full package name untuk LocalDate
        Manusia test1 = new Manusia("Akhmad", "123456789", true, true);
        System.out.println(test1);

        MahasiswaFILKOM test2 = new MahasiswaFILKOM("Dian", "987654321", false, false, 
                                                   "225150700111023", 3.9);
        System.out.println(test2);

        // Menggunakan java.time.LocalDate secara langsung
        Pekerja test3 = new Pekerja("Budi", "111222333", true, true, 5000, 
                                   java.time.LocalDate.of(2020, 4, 10), 2);
        System.out.println(test3);

        Manager test4 = new Manager("Sari", "444555666", false, true, 8000, 
                                    java.time.LocalDate.of(2018, 2, 15), 1, "IT");
        System.out.println(test4);

        System.out.println("\n=== SELESAI TEST CASE ===\n");

        // =======================
        // BAGIAN 2: INPUT USER
        // =======================
        // Menggunakan full package name untuk Scanner
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("=== INPUT DATA DARI USER ===");

        // Input data manusia
        System.out.println("\n-- Input Data Manusia --");
        System.out.print("Nama: ");
        String nama = input.nextLine();
        System.out.print("NIK: ");
        String nik = input.nextLine();
        System.out.print("Jenis Kelamin (true = Laki-laki, false = Perempuan): ");
        boolean jk = input.nextBoolean();
        System.out.print("Sudah menikah? (true/false): ");
        boolean menikah = input.nextBoolean();

        Manusia manusiaInput = new Manusia(nama, nik, jk, menikah);
        System.out.println("\nData Manusia dari User:");
        System.out.println(manusiaInput);

        // Input data mahasiswa
        input.nextLine(); // Membersihkan buffer
        System.out.println("\n-- Input Data Mahasiswa FILKOM --");
        System.out.print("Nama: ");
        nama = input.nextLine();
        System.out.print("NIK: ");
        nik = input.nextLine();
        System.out.print("Jenis Kelamin: ");
        jk = input.nextBoolean();
        System.out.print("Sudah menikah? ");
        menikah = input.nextBoolean();
        input.nextLine();
        System.out.print("NIM: ");
        String nim = input.nextLine();
        System.out.print("IPK: ");
        double ipk = input.nextDouble();

        MahasiswaFILKOM mhsInput = new MahasiswaFILKOM(nama, nik, jk, menikah, nim, ipk);
        System.out.println("\nData Mahasiswa dari User:");
        System.out.println(mhsInput);

        // Input data pekerja
        input.nextLine();
        System.out.println("\n-- Input Data Pekerja --");
        System.out.print("Nama: ");
        nama = input.nextLine();
        System.out.print("NIK: ");
        nik = input.nextLine();
        System.out.print("Jenis Kelamin: ");
        jk = input.nextBoolean();
        System.out.print("Sudah menikah? ");
        menikah = input.nextBoolean();
        System.out.print("Gaji: ");
        int gaji = input.nextInt();
        input.nextLine();
        System.out.print("Tanggal Masuk (YYYY-MM-DD): ");
        String tgl = input.nextLine();
        // Menggunakan full package name untuk parse tanggal
        java.time.LocalDate tanggalMasuk = java.time.LocalDate.parse(tgl);
        System.out.print("Jumlah anak: ");
        int anak = input.nextInt();

        Pekerja pekerjaInput = new Pekerja(nama, nik, jk, menikah, gaji, tanggalMasuk, anak);
        System.out.println("\nData Pekerja dari User:");
        System.out.println(pekerjaInput);

        // Input data manager
        input.nextLine();
        System.out.println("\n-- Input Data Manager --");
        System.out.print("Nama: ");
        nama = input.nextLine();
        System.out.print("NIK: ");
        nik = input.nextLine();
        System.out.print("Jenis Kelamin: ");
        jk = input.nextBoolean();
        System.out.print("Sudah menikah? ");
        menikah = input.nextBoolean();
        System.out.print("Gaji: ");
        gaji = input.nextInt();
        input.nextLine();
        System.out.print("Tanggal Masuk (YYYY-MM-DD): ");
        tgl = input.nextLine();
        tanggalMasuk = java.time.LocalDate.parse(tgl);
        System.out.print("Jumlah anak: ");
        anak = input.nextInt();
        input.nextLine();
        System.out.print("Departemen: ");
        String dept = input.nextLine();

        Manager managerInput = new Manager(nama, nik, jk, menikah, gaji, tanggalMasuk, anak, dept);
        System.out.println("\nData Manager dari User:");
        System.out.println(managerInput);

        input.close();
    }
}

