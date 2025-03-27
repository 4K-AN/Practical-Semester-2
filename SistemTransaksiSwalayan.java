import java.util.Scanner;

/**
 * Kelas untuk mendefinsikan tipe pelanggan
 */
class TipePelanggan {
    // Konstanta untuk tipe pelanggan
    public static final String SILVER = "38";
    public static final String GOLD = "56";
    public static final String PLATINUM = "74";

    // Metode untuk menghitung cashback pelanggan silver
    public static double hitungCashbackSilver(double jumlah) {
        // Silver dapat cashback 5% jika pembelian di atas 1 juta
        return jumlah > 1000000 ? jumlah * 0.05 : 0;
    }

    // Metode untuk menghitung cashback pelanggan gold
    public static double hitungCashbackGold(double jumlah) {
        // Gold dapat cashback 7% jika pembelian di atas 1 juta
        // Jika di bawah 1 juta, cashback 2%
        if (jumlah > 1000000) {
            return jumlah * 0.07;
        } else {
            return jumlah * 0.02;
        }
    }

    // Metode untuk menghitung cashback pelanggan platinum
    public static double hitungCashbackPlatinum(double jumlah) {
        // Platinum dapat cashback 10% jika pembelian di atas 1 juta
        // Jika di bawah 1 juta, cashback 5%
        if (jumlah > 1000000) {
            return jumlah * 0.10;
        } else {
            return jumlah * 0.05;
        }
    }
}

/**
 * Kelas AkunPelanggan dengan implementasi enkapsulasi
 */
class AkunPelanggan {
    // Variabel private untuk melindungi data pelanggan
    private String nomorPelanggan;     // Nomor pelanggan unik
    private String namaPelanggan;      // Nama pelanggan
    private double saldo;              // Saldo akun
    private String pin;                // PIN rahasia
    private String tipePelanggan;      // Tipe keanggotaan pelanggan
    private int percobaan;             // Jumlah percobaan autentikasi
    private boolean dikunci;           // Status penguncian akun

    /**
     * Konstruktor AkunPelanggan
     * @param nomorPelanggan Nomor pelanggan 10 digit
     * @param namaPelanggan Nama pelanggan
     * @param saldoAwal Saldo awal
     * @param pin PIN akun
     */
    public AkunPelanggan(String nomorPelanggan, String namaPelanggan, 
                         double saldoAwal, String pin) {
        // Validasi nomor pelanggan
        if (!validasiNomorPelanggan(nomorPelanggan)) {
            throw new IllegalArgumentException("Format nomor pelanggan tidak valid");
        }

        this.nomorPelanggan = nomorPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.saldo = saldoAwal;
        this.pin = pin;
        this.tipePelanggan = tentukanTipePelanggan(nomorPelanggan);
        this.percobaan = 0;
        this.dikunci = false;
    }

    // Mutator method untuk mengubah saldo dengan kontrol ketat
    private void ubahSaldo(double jumlah) {
        // Pastikan saldo tidak negatif
        if (this.saldo + jumlah >= 10000) {
            this.saldo += jumlah;
        } else {
            throw new IllegalArgumentException("Saldo minimal Rp 10.000");
        }
    }

    /**
     * Method autentikasi dengan logika penguncian akun
     * param pinMasukan PIN yang dimasukkan
     * return Boolean keberhasilan autentikasi
     */
    public boolean autentikasi(String pinMasukan) {
        // Cek apakah akun sudah dikunci
        if (dikunci) {
            System.out.println("Akun dikunci. Transaksi tidak dapat dilakukan.");
            return false;
        }

        // Bandingkan PIN
        if (pinMasukan.equals(this.pin)) {
            // Reset percobaan jika berhasil
            percobaan = 0;
            return true;
        } else {
            // Tambah percobaan
            percobaan++;
            if (percobaan >= 3) {
                dikunci = true;
                System.out.println("Akun diblokir karena 3x salah PIN.");
            }
            return false;
        }
    }

    /**
     * Method transaksi pembelian dengan perhitungan cashback
     * param jumlah Nominal pembelian
     * return Status keberhasilan pembelian
     */
    public boolean beliProduk(double jumlah) {
        // Validasi saldo dan jumlah pembelian
        if (saldo < 10000 || saldo < jumlah) {
            System.out.println("Saldo tidak mencukupi.");
            return false;
        }

        // Hitung cashback berdasarkan tipe pelanggan
        double cashback = hitungCashback(jumlah);
        
        // Kurangi saldo dan tambah cashback
        saldo -= jumlah;
        saldo += cashback;

        System.out.printf("Pembelian berhasil. Cashback: Rp%.2f\n", cashback);
        return true;
    }

    /**
     * Metode untuk menghitung cashback sesuai tipe pelanggan
     * @param jumlah Nominal pembelian
     * @return Nominal cashback
     */
    private double hitungCashback(double jumlah) {
        switch (tipePelanggan) {
            case TipePelanggan.SILVER:
                return TipePelanggan.hitungCashbackSilver(jumlah);
            case TipePelanggan.GOLD:
                return TipePelanggan.hitungCashbackGold(jumlah);
            case TipePelanggan.PLATINUM:
                return TipePelanggan.hitungCashbackPlatinum(jumlah);
            default:
                return 0;
        }
    }

    /**
     * Method top up saldo
     * @param jumlah Nominal top up
     * @return Status keberhasilan top up
     */
    public boolean topUp(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah top up tidak valid.");
            return false;
        }
        
        // Gunakan mutator method untuk mengubah saldo
        ubahSaldo(jumlah);
        System.out.printf("Top up berhasil. Saldo baru: Rp%.2f\n", saldo);
        return true;
    }

    // Accessor methods (getter) untuk mengakses informasi akun
    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipePelanggan() {
        return tipePelanggan;
    }

    public boolean isDikunci() {
        return dikunci;
    }

    // Method private untuk validasi dan penentuan tipe pelanggan
    private boolean validasiNomorPelanggan(String nomorPelanggan) {
        return nomorPelanggan != null && 
               nomorPelanggan.length() == 10 && 
               (nomorPelanggan.startsWith("38") || 
                nomorPelanggan.startsWith("56") || 
                nomorPelanggan.startsWith("74"));
    }

    private String tentukanTipePelanggan(String nomorPelanggan) {
        if (nomorPelanggan.startsWith("38")) {
            return TipePelanggan.SILVER;
        } else if (nomorPelanggan.startsWith("56")) {
            return TipePelanggan.GOLD;
        } else if (nomorPelanggan.startsWith("74")) {
            return TipePelanggan.PLATINUM;
        }
        throw new IllegalArgumentException("Tipe pelanggan tidak valid");
    }
}

/**
 * Kelas utama untuk menjalankan sistem transaksi
 */
public class SistemTransaksiSwalayan {
    public static void main(String[] args) {
        // Inisialisasi akun pelanggan
        AkunPelanggan[] daftarPelanggan = {
            new AkunPelanggan("3812345678", "Ponimin", 50000, "1234"),
            new AkunPelanggan("5687654321", "Budi Setiawan", 100000, "5678"),
            new AkunPelanggan("7423456789", "Koh Liam", 200000, "9012")
        };

        Scanner scanner = new Scanner(System.in);
        
        // Meminta input nomor pelanggan
        System.out.print("Masukkan Nomor Pelanggan: ");
        String nomorPelanggan = scanner.next();
        
        // Mencari akun yang sesuai
        AkunPelanggan pelangganAktif = null;
        for (AkunPelanggan p : daftarPelanggan) {
            if (p.getNomorPelanggan().equals(nomorPelanggan)) {
                pelangganAktif = p;
                break;
            }
        }
        
        if (pelangganAktif == null) {
            System.out.println("Nomor pelanggan tidak valid!");
            return;
        }

        // Menjalankan sistem transaksi untuk akun yang dipilih
        sistemTransaksi(scanner, pelangganAktif);
    }

    /**
     * Method untuk menjalankan simulasi transaksi
     * param scanner Input dari pengguna
     * param pelanggan Akun pelanggan yang melakukan transaksi
     */
    private static void sistemTransaksi(Scanner scanner, AkunPelanggan pelanggan) {
        while (true) {
            System.out.println("\n--- Sistem Transaksi Swalayan ---");
            System.out.println("1. Beli Produk");
            System.out.println("2. Top Up");
            System.out.println("3. Cek Saldo");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            
            if (pelanggan.isDikunci()) {
                System.out.println("Akun dikunci. Transaksi tidak dapat dilakukan.");
                break;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan PIN: ");
                    String pin = scanner.next();
                    if (pelanggan.autentikasi(pin)) {
                        System.out.print("Masukkan jumlah pembelian: ");
                        double jumlahBeli = scanner.nextDouble();
                        pelanggan.beliProduk(jumlahBeli);
                    }
                    break;
                case 2:
                    System.out.print("Masukkan PIN: ");
                    String pinTopUp = scanner.next();
                    if (pelanggan.autentikasi(pinTopUp)) {
                        System.out.print("Masukkan jumlah top up: ");
                        double jumlahTopUp = scanner.nextDouble();
                        pelanggan.topUp(jumlahTopUp);
                    }
                    break;
                case 3:
                    System.out.printf("Saldo Saat Ini: Rp%.2f\n", pelanggan.getSaldo());
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan Sistem Transaksi Swalayan.");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }
}