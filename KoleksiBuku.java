import java.util.List;

public class KoleksiBuku {
    private String namaBuku;
    private List<String> pengarang;
    private int tahun;
    private String sinopsis;

    // Konstruktor
    public KoleksiBuku(String namaBuku, List<String> pengarang, int tahun, String sinopsis) {
        this.namaBuku = namaBuku;
        this.pengarang = pengarang;
        this.tahun = tahun;
        this.sinopsis = sinopsis;
    }

    // Getter untuk mengakses atribut
    public String getNamaBuku() {
        return namaBuku;
    }

    public List<String> getPengarang() {
        return pengarang;
    }

    public int getTahun() {
        return tahun;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    // Method untuk menampilkan informasi buku
    public void tampil() {
        System.out.println("Judul: " + namaBuku);
        System.out.println("Penulis: " + String.join(", ", pengarang));
        System.out.println("Tahun Terbit: " + tahun);
        System.out.println("Sinopsis: " + sinopsis);
    }
    public double cekTingkatKesamaan(KoleksiBuku bukuLain) {
        if (bukuLain == null) return 0.0;
    
        // Perhitungan sederhana berdasarkan jumlah kata yang sama dalam nama buku
        String[] kataBuku1 = namaBuku.toLowerCase().split(" ");
        String[] kataBuku2 = bukuLain.getNamaBuku().toLowerCase().split(" ");
    
        int kesamaan = 0;
        for (String kata : kataBuku1) {
            for (String kataLain : kataBuku2) {
                if (kata.equals(kataLain)) {
                    kesamaan++;
                }
            }
        }
    
        return (double) kesamaan / Math.max(kataBuku1.length, kataBuku2.length);
    }
    
}
