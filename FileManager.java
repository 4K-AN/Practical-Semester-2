import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    // Method untuk membaca buku dari file
    public static KoleksiBuku bacaFile(String namaFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String namaBuku = reader.readLine();
            String pengarangStr = reader.readLine();
            int tahun = Integer.parseInt(reader.readLine());
            String sinopsis = reader.readLine();

            List<String> pengarang = Arrays.asList(pengarangStr.split(", "));

            return new KoleksiBuku(namaBuku, pengarang, tahun, sinopsis);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
            return null;
        }
    }

    // Method untuk menyimpan buku ke file
    public static void simpanFile(String namaFile, KoleksiBuku buku) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            writer.write(buku.getNamaBuku() + "\n");
            writer.write(String.join(", ", buku.getPengarang()) + "\n");
            writer.write(buku.getTahun() + "\n");
            writer.write(buku.getSinopsis() + "\n");


            System.out.println("Data berhasil disimpan ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }
}
