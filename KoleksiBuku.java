import java.util.List;

// Kelas KoleksiBuku merepresentasikan sebuah buku dengan atributnya
public class KoleksiBuku {
    private String namaBuku; // Nama buku
    private List<String> pengarang; // Daftar pengarang buku
    private int tahun; // Tahun terbit buku
    private String sinopsis; // Sinopsis buku

    // Konstruktor untuk inisialisasi objek KoleksiBuku
    public KoleksiBuku(String namaBuku, List<String> pengarang, int tahun, String sinopsis) {
        this.namaBuku = namaBuku;
        this.pengarang = pengarang;
        this.tahun = tahun;
        this.sinopsis = sinopsis;
    }

    // Getter untuk mendapatkan nama buku
    public String getNamaBuku() {
        return namaBuku;
    }

    // Getter untuk mendapatkan daftar pengarang
    public List<String> getPengarang() {
        return pengarang;
    }

    // Getter untuk mendapatkan tahun terbit
    public int getTahun() {
        return tahun;
    }

    // Getter untuk mendapatkan sinopsis buku
    public String getSinopsis() {
        return sinopsis;
    }

    // Method untuk menampilkan informasi buku ke layar
    public void tampil() {
        System.out.println("Judul: " + namaBuku);
        System.out.println("Penulis: " + String.join(", ", pengarang));
        System.out.println("Tahun Terbit: " + tahun);
        System.out.println("Sinopsis: " + sinopsis);
    }

    // Method untuk mengecek tingkat kesamaan judul buku berdasarkan jumlah kata yang sama
    public double cekTingkatKesamaan(KoleksiBuku bukuLain) {
        if (bukuLain == null) return 0.0; // Jika buku yang dibandingkan null, langsung kembalikan 0
    
        // Memisahkan kata dalam judul buku menjadi array kata-kata
        String[] kataBuku1 = namaBuku.toLowerCase().split(" ");
        String[] kataBuku2 = bukuLain.getNamaBuku().toLowerCase().split(" ");
    
        int kesamaan = 0; // Variabel untuk menghitung jumlah kata yang sama
        for (String kata : kataBuku1) {
            for (String kataLain : kataBuku2) {
                if (kata.equals(kataLain)) {
                    kesamaan++; // Tambahkan jika ada kata yang sama
                }
            }
        }
    
        // Menghitung persentase kesamaan berdasarkan jumlah kata yang sama dibandingkan dengan jumlah kata terbanyak
        return (double) kesamaan / Math.max(kataBuku1.length, kataBuku2.length);
    }
}