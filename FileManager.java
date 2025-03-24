import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    // Method untuk membaca buku dari file
    public static KoleksiBuku bacaFile(String namaFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            // Membaca setiap baris dari file sesuai dengan format yang diharapkan
            String namaBuku = reader.readLine(); // Membaca judul buku
            String pengarangStr = reader.readLine(); // Membaca nama pengarang dalam satu string
            String tahunStr = reader.readLine(); // Membaca tahun terbit dalam bentuk string
            String sinopsis = reader.readLine(); // Membaca sinopsis buku
    
            // Cek apakah ada baris yang null (file tidak lengkap)
            if (namaBuku == null || pengarangStr == null || tahunStr == null || sinopsis == null) {
                System.out.println("Terjadi kesalahan: File tidak memiliki data yang cukup.");
                return null; // Mengembalikan null jika ada data yang hilang
            }
    
            int tahun;
            try {
                tahun = Integer.parseInt(tahunStr); // Mengonversi string tahun ke integer
            } catch (NumberFormatException e) {
                System.out.println("Terjadi kesalahan: Format tahun tidak valid.");
                return null; // Mengembalikan null jika format tahun tidak valid
            }
    
            // Memisahkan nama pengarang jika terdapat lebih dari satu
            List<String> pengarang = Arrays.asList(pengarangStr.split(", "));
    
            // Mengembalikan objek KoleksiBuku yang telah diinisialisasi dengan data dari file
            return new KoleksiBuku(namaBuku, pengarang, tahun, sinopsis);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
            return null; // Mengembalikan null jika terjadi error saat membaca file
        }
    }
    
    // Method untuk menyimpan buku ke file
    public static void simpanFile(String namaFile, KoleksiBuku buku) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            // Menulis setiap atribut buku ke dalam file, dipisahkan oleh baris baru
            writer.write(buku.getNamaBuku() + "\n"); // Menyimpan judul buku
            writer.write(String.join(", ", buku.getPengarang()) + "\n"); // Menyimpan daftar pengarang
            writer.write(buku.getTahun() + "\n"); // Menyimpan tahun terbit
            writer.write(buku.getSinopsis() + "\n"); // Menyimpan sinopsis buku
    
            System.out.println("Data berhasil disimpan ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }
}
