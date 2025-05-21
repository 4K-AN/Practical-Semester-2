
import java.io.File;

public class ListFile {

    public static void main(String[] args) {
        File dir = new File(".");
        String[] files = dir.list();

        System.out.println("Daftar file:");
        for (String file : files) {
            System.out.println(file);
        }
    }
}
