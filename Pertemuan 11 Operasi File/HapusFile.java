import java.io.File;

public class HapusFile {
    public static void main(String[] args) {
        File file = new File("test.txt"); // Ganti dengan path lengkap jika perlu
        
        if (file.exists() && file.isFile()) {
            boolean berhasil = file.delete();
            if (berhasil) {
                System.out.println("File test.txt berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus file test.txt.");
            }
        } else {
            System.out.println("File test.txt tidak ditemukan atau bukan file.");
        }
    }
}