
import java.io.File;

public class UkuranFile {

    public static void main(String[] args) {
        File file = new File("test.txt");
        long bytes = file.length();
        double ukuran;

        if (bytes < 1024 * 1024) { // Kurang dari 1 MB
            ukuran = bytes / 1024.0;
            System.out.printf("Ukuran file: %.2f KB", ukuran);
        } else {
            ukuran = bytes / (1024.0 * 1024.0);
            System.out.printf("Ukuran file: %.2f MB", ukuran);
        }
    }
}
