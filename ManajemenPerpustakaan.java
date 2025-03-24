
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class KelompokBuku {

    private String jenis;
    public List<KoleksiBuku> inventaris;

    public KelompokBuku(String jenis) {
        this.jenis = jenis;
        this.inventaris = new ArrayList<>();
    }

    public void tambah(KoleksiBuku buku) {
        if (!inventaris.contains(buku)) {
            inventaris.add(buku);
        }
    }

    public String getJenis() {
        return jenis;
    }

    public void tampilkanKoleksi() {
        System.out.println("\n════════════════════════════════");
        System.out.println(" KATEGORI: " + jenis.toUpperCase());
        System.out.println("════════════════════════════════");

        for (int i = 0; i < inventaris.size(); i++) {
            System.out.println("[" + (i + 1) + "]");
            inventaris.get(i).tampil();
            System.out.println("-----------------------------------");
        }
    }
}

public class ManajemenPerpustakaan {

    private static Scanner scanner = new Scanner(System.in);
    private static KelompokBuku[] rak = new KelompokBuku[5]; // Misal ada 5 kategori buku

    public static void main(String[] args) {
        initializeLibrary();

        while (true) {
            System.out.println("\n═══════════════════════════════════");
            System.out.println("    SISTEM PERPUSTAKAAN DIGITAL");
            System.out.println("═══════════════════════════════════");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Cek Tingkat Kesamaan Buku");
            System.out.println("3. Keluar");
            System.out.println("4. Baca Data Buku dari File"); // Tambahkan menu ini
            System.out.print("Pilih menu (1-4): ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    tampilkanSemuaBuku();
                    break;
                case 2:
                    cekKesamaanBuku();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan digital!");
                    System.exit(0);
                    break;
                case 4:
                    bacaDataDariFile();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void bacaDataDariFile() {
        System.out.println("Membaca data dari file...");
        KoleksiBuku buku = FileManager.bacaFile("data_buku.txt");

        if (buku != null) {
            System.out.println("\n=== Data Buku yang Dibaca ===");
            System.out.println("Judul: " + buku.getNamaBuku());
            System.out.println("Penulis: " + String.join(", ", buku.getPengarang()));
            System.out.println("Tahun Terbit: " + buku.getTahun());
            System.out.println("Sinopsis: " + buku.getSinopsis());

            // Menambahkan buku ke kategori pertama (misalnya kategori Teknologi)
            if (rak[0] == null) {
                rak[0] = new KelompokBuku("Teknologi");
            }
            rak[0].tambah(buku);

            // Menyimpan kembali ke file lain
            FileManager.simpanFile("data_buku_output.txt", buku);
            System.out.println("Buku telah disimpan kembali ke data_buku_output.txt.");
        } else {
            System.out.println("Gagal membaca file.");
        }
    }



    private static void initializeLibrary() {
        rak = new KelompokBuku[7];
        rak[0] = new KelompokBuku("Teknologi");
        rak[1] = new KelompokBuku("Filsafat");
        rak[2] = new KelompokBuku("Sejarah");
        rak[3] = new KelompokBuku("Agama");
        rak[4] = new KelompokBuku("Psikologi");
        rak[5] = new KelompokBuku("Politik");
        rak[6] = new KelompokBuku("Fiksi");

        // Teknologi
        rak[0].tambah(new KoleksiBuku("ChatGPT Buatkan Saya Kode Ini",
                Arrays.asList("Angilbert"), 2012, "ChatGPT Buatkan Saya Kode Ini adalah sebuah buku yang ditulis oleh Angilbert dan diterbitkan pada tahun 2012. Buku ini membahas bagaimana kecerdasan buatan dapat membantu programmer dalam menulis kode, memperbaiki kesalahan, dan meningkatkan efisiensi dalam pengembangan perangkat lunak."));
        rak[0].tambah(new KoleksiBuku("Jokowi Programming Pro",
                Arrays.asList("Joko Widodo", "Mahfud"), 2021, "Jokowi Programming Pro (2021) membahas keterkaitan antara prinsip pemrograman dengan kepemimpinan dan kebijakan publik. Buku ini menyoroti bagaimana konsep seperti algoritma, debugging, dan efisiensi dapat diterapkan dalam tata kelola pemerintahan. Dengan pendekatan inovatif, penulis menggambarkan peran teknologi dalam mendorong transformasi digital di Indonesia."));
        rak[0].tambah(new KoleksiBuku("Cybersecurity Asli Duri",
                Arrays.asList("Kelurga Besar TI Duri"), 2019, "Cybersecurity Asli Duri (2019) karya Kelurga Besar TI Duri membahas ancaman dunia maya serta strategi perlindungan data dengan pendekatan yang praktis dan realistis."));
        rak[0].tambah(new KoleksiBuku("DeepSeek vs ChatGPT",
                Arrays.asList("Raihan Sambalado"), 2010, "Deepseek vs ChatGPT karya Raihan Sambalado membahas perbandingan antara dua model AI, menyoroti keunggulan, keterbatasan, serta dampaknya dalam dunia teknologi dan komunikasi."));
        rak[0].tambah(new KoleksiBuku("Mobil Terbang IKN",
                Arrays.asList("Gibran Hebat"), 2025, "Mobil Terbang IKN (2015) karya Gibran Hebat membahas konsep futuristik mobil terbang di Ibu Kota Nusantara (IKN) dan potensinya dalam revolusi transportasi di Indonesia."));

// Filsafat
        rak[1].tambah(new KoleksiBuku("Filsafat Ngawi Modern",
                Arrays.asList("Rusdi Sang Pemberani"), 1945, "Filsafat Ngawi Modern (1945) karya Rusdi Sang Pemberani mengeksplorasi pemikiran filsafat yang berkembang di Ngawi dalam konteks perubahan sosial dan politik. Buku ini mengupas nilai-nilai tradisional yang bertahan serta adaptasinya terhadap modernitas di tengah pergolakan kemerdekaan Indonesia. Dengan gaya reflektif, penulis mengajak pembaca memahami bagaimana filsafat lokal dapat berperan dalam membentuk identitas dan pandangan hidup masyarakat."));
        rak[1].tambah(new KoleksiBuku("Wujud Aseli Bawang",
                Arrays.asList("Fulan"), -400, "Wujud Aseli Bawang karya Fulan adalah sebuah teks kuno yang diyakini berasal dari sekitar tahun 400 SM. Buku ini membahas asal-usul, karakteristik, dan makna filosofis bawang dalam berbagai budaya kuno. Dengan pendekatan historis dan observasi mendalam, penulis menggali peran bawang dalam kehidupan sehari-hari, pengobatan, serta simbolisme spiritual di masa lampau."));
        rak[1].tambah(new KoleksiBuku("Si Bisu Ahli BIjaksana", Arrays.asList("Hafiz"), 1883, "Si Bisu Ahli Bijaksana (1883) karya Hafiz mengisahkan perjalanan seorang tokoh yang, meskipun tidak bisa berbicara, memiliki kebijaksanaan luar biasa dalam memahami dunia di sekitarnya. Buku ini mengeksplorasi tema ketenangan, introspeksi, dan cara komunikasi non-verbal dalam menyampaikan kebijaksanaan. Dengan narasi yang mendalam, penulis menggambarkan bagaimana kebijaksanaan sejati tidak selalu berasal dari kata-kata, tetapi dari pemahaman dan tindakan."));
        rak[1].tambah(new KoleksiBuku("Meditasi Form Jember", Arrays.asList("Echa"), 180, "Meditasi Form Jember (180) karya Echa mengeksplorasi praktik meditasi kuno yang berkembang di wilayah Jember pada masa lampau. Buku ini membahas teknik pernapasan, konsentrasi, dan filosofi ketenangan batin yang diwariskan dari generasi ke generasi. Dengan pendekatan spiritual dan historis, penulis mengungkap bagaimana meditasi dapat membentuk keseimbangan hidup dan pemahaman diri."));
        rak[1].tambah(new KoleksiBuku("Kritik Untuk Omke gas", Arrays.asList("Dongo entertainment"), 1781, "Kritik Untuk Omke Gas (1781) karya Dongo Entertainment adalah sebuah tulisan satir yang mengupas kebijakan dan keputusan kontroversial seorang tokoh bernama Omke Gas. Buku ini menyajikan kritik tajam terhadap kepemimpinan dan dinamika sosial pada masanya dengan gaya humor yang cerdas. Melalui narasi yang menggelitik namun penuh makna, penulis mengajak pembaca untuk merenungkan dampak kekuasaan dan kebijakan terhadap kehidupan masyarakat."));

// Sejarah
        rak[2].tambah(new KoleksiBuku("Sejarah Nazi", Arrays.asList("Adolf Hitler"), 2011, "Buku Sejarah Nazi (2011) yang dikaitkan dengan Adolf Hitler menimbulkan pertanyaan mengenai keasliannya, karena Hitler sendiri telah wafat pada tahun 1945. Jika ini adalah buku sejarah yang membahas rezim Nazi, kemungkinan besar ditulis oleh sejarawan atau penulis lain yang mengulas peristiwa tersebut."));
        rak[2].tambah(new KoleksiBuku("1998 Indonesia Suram", Arrays.asList("Sutrisno"), 1997, "1998 Indonesia Suram (1997) karya Sutrisno merupakan sebuah refleksi dan prediksi terhadap kondisi sosial-politik Indonesia menjelang krisis tahun 1998. Buku ini membahas tanda-tanda ketidakstabilan ekonomi, ketegangan politik, serta gejolak sosial yang mengarah pada reformasi. Dengan gaya penulisan analitis, penulis mencoba menggambarkan kemungkinan perubahan besar yang akan terjadi di Indonesia."));
        rak[2].tambah(new KoleksiBuku("Makanan Sehari Jawir", Arrays.asList("Alvin Rujak "), 2005, "Makanan Sehari Jawir (2005) karya Alvin Rujak mengeksplorasi kebiasaan kuliner unik seorang tokoh bernama Jawir. Buku ini mengulas berbagai hidangan yang dikonsumsi dalam kehidupan sehari-hari, baik dari perspektif budaya, gizi, maupun pengalaman pribadi. Dengan gaya santai dan informatif, penulis mengajak pembaca memahami bagaimana makanan mencerminkan identitas dan kebiasaan seseorang."));
        rak[2].tambah(new KoleksiBuku("Jumlah Istri Soekarno", Arrays.asList("Azril Barber"), 2005, "Jumlah Istri Soekarno (2005) karya Azril Barber membahas kehidupan pribadi Presiden pertama Indonesia, Soekarno, khususnya mengenai pernikahannya dengan beberapa wanita. Buku ini mengulas latar belakang, dinamika hubungan, serta peran masing-masing istri dalam kehidupan Soekarno. Dengan pendekatan historis, penulis mencoba memberikan gambaran yang lebih dalam tentang aspek personal sang proklamator yang jarang dibahas dalam buku sejarah konvensional."));
        rak[2].tambah(new KoleksiBuku("Mahasiswa Naik Gedung DPR", Arrays.asList("Ahmad PEcel"), 2015, "Mahasiswa Naik Gedung DPR (2015) karya Ahmad Pecel membahas aksi demonstrasi mahasiswa yang mencapai puncaknya dengan pendudukan gedung DPR. Buku ini menggambarkan semangat perjuangan mahasiswa dalam menyuarakan aspirasi, menuntut perubahan, dan menghadapi dinamika politik. Dengan gaya penulisan yang menggugah, penulis mengajak pembaca memahami peran penting gerakan mahasiswa dalam sejarah demokrasi Indonesia."));

// Agama
        rak[3].tambah(new KoleksiBuku("Agama yang Indah", Arrays.asList("I Kadek Miko", "Ahmad Ahza"), 1964, "Agama yang Indah (1964) karya I Kadek Miko dan Ahmad Ahza membahas nilai-nilai universal dalam ajaran agama yang mengedepankan kedamaian, toleransi, dan keindahan spiritual. Buku ini mengeksplorasi bagaimana keberagaman keyakinan dapat menjadi sumber harmoni dalam kehidupan bermasyarakat. Dengan pendekatan reflektif dan inklusif, penulis mengajak pembaca untuk memahami agama sebagai jalan menuju kebijaksanaan dan kasih sayang."));
        rak[3].tambah(new KoleksiBuku("Cara Bertoleransi", Arrays.asList("Ramzy Pemburu Ta'jil"), 1980, "Cara Bertoleransi (1980) karya Ramzy Pemburu Ta'jil membahas pentingnya sikap saling menghormati dan memahami perbedaan dalam kehidupan bermasyarakat. Buku ini mengupas berbagai aspek toleransi, mulai dari agama, budaya, hingga pandangan politik, serta bagaimana menerapkannya dalam interaksi sehari-hari. Dengan pendekatan yang ringan namun mendalam, penulis mengajak pembaca untuk membangun kehidupan yang lebih harmonis dan inklusif."));
        rak[3].tambah(new KoleksiBuku("Tuhan yang Maha Esa", Arrays.asList("Joko Pranowo"), 1995, "Tuhan yang Maha Esa (1995) karya Joko Pranowo membahas konsep ketuhanan dari berbagai perspektif filosofis, spiritual, dan budaya. Buku ini mengeksplorasi bagaimana keyakinan terhadap Tuhan membentuk moralitas, kehidupan sosial, serta hubungan manusia dengan alam semesta. Dengan pendekatan reflektif, penulis mengajak pembaca untuk merenungkan makna keberadaan Tuhan dalam kehidupan sehari-hari."));
        rak[3].tambah(new KoleksiBuku("Agama yang Keren", Arrays.asList("Immanuel isaac"), 2003, "Agama yang Keren (2003) karya Immanuel Isaac mengeksplorasi bagaimana ajaran agama dapat tetap relevan dan menarik bagi generasi modern. Buku ini membahas cara memahami spiritualitas dengan sudut pandang yang lebih inklusif, terbuka, dan sesuai dengan perkembangan zaman. Dengan gaya penulisan yang santai namun mendalam, penulis mengajak pembaca untuk melihat agama sebagai sumber inspirasi dan harmoni dalam kehidupan."));
        rak[3].tambah(new KoleksiBuku("Pilih Agama yang Normal", Arrays.asList("Hasan 30 Juz"), 1988, "Pilih Agama yang Normal (1988) karya Hasan 30 Juz membahas pentingnya memahami agama dengan cara yang seimbang, rasional, dan tidak ekstrem. Buku ini mengeksplorasi berbagai pandangan mengenai keberagamaan yang moderat serta bagaimana memilih jalan spiritual yang membawa kedamaian dan toleransi. Dengan pendekatan analitis dan reflektif, penulis mengajak pembaca untuk melihat agama sebagai pedoman hidup yang menyejukkan, bukan sebagai alat perpecahan."));

// Psikologi
        rak[4].tambah(new KoleksiBuku("Mengendali Orang Melalui Kentut", Arrays.asList("GOPI"), 2011, "Mengendali Orang Melalui Kentut (2011) karya GOPI adalah sebuah buku unik yang menggabungkan humor dengan teori-teori aneh mengenai pengaruh kentut terhadap interaksi sosial. Dengan gaya penulisan yang nyeleneh, buku ini mengeksplorasi bagaimana fenomena alami ini dapat digunakan dalam berbagai situasi, dari mencairkan suasana hingga menciptakan dominasi sosial. Meskipun terdengar konyol, buku ini menyelipkan pesan tentang psikologi manusia dan reaksi sosial terhadap hal-hal yang dianggap tabu."));
        rak[4].tambah(new KoleksiBuku("Manipulator Yang Kuat", Arrays.asList("Agus Buntung"), 2012, "Manipulator Yang Kuat (2012) karya Agus Buntung membahas berbagai teknik manipulasi dalam interaksi sosial, politik, dan bisnis. Buku ini mengeksplorasi bagaimana seseorang dapat memengaruhi orang lain secara halus maupun terang-terangan untuk mencapai tujuan tertentu. Dengan pendekatan yang kritis, penulis mengajak pembaca untuk memahami, mengenali, dan mengantisipasi taktik manipulasi yang sering terjadi dalam kehidupan sehari-hari."));
        rak[4].tambah(new KoleksiBuku("Pura Pura Efisiensi Anggaran ", Arrays.asList("Omke gas community"), 1989, "Pura-Pura Efisiensi Anggaran (1989) adalah buku psikologi, isinya membahas bagaimana individu atau kelompok berpura-pura efisien dalam mengelola sumber daya, padahal sebenarnya hanya menciptakan ilusi produktivitas. Buku ini mengeksplorasi konsep self-deception, bias kognitif, dan mekanisme psikologis di balik kebiasaan manusia yang sering kali lebih mementingkan citra daripada hasil nyata. Dengan pendekatan psikologi sosial, penulis mengajak pembaca untuk mengenali pola-pola manipulasi mental ini dan bagaimana cara menghindarinya dalam kehidupan sehari-hari."));
        rak[4].tambah(new KoleksiBuku("Cara Menang Argumen Dari Orang Tuli", Arrays.asList("Raja Iblis", "Azka Plongo"), 2011, "Cara Menang Argumen dari Orang Tuli (2011) karya Raja Iblis dan Azka Plongo adalah buku satir yang mengupas berbagai strategi dalam berdebat, terutama ketika berhadapan dengan lawan yang tidak mau mendengar atau menerima pendapat lain. Dengan pendekatan humoris dan sedikit sarkastik, buku ini mengeksplorasi teknik komunikasi, logika argumen, serta psikologi dalam perdebatan. Di balik judulnya yang provokatif, buku ini mengajak pembaca untuk lebih memahami dinamika diskusi dan cara menyampaikan pendapat secara efektif."));
        rak[4].tambah(new KoleksiBuku("Cara Bayar Hutang Melalui Mimpi", Arrays.asList("JOKI TUGAS .id"), 2012, "Cara Bayar Hutang Melalui Mimpi (2012) karya JOKI TUGAS .id adalah buku psikologi yang membahas bagaimana beban finansial dapat memengaruhi alam bawah sadar seseorang. Buku ini mengeksplorasi hubungan antara stres akibat utang, mekanisme pertahanan psikologis, dan cara otak mencoba mencari solusi melalui mimpi. Dengan pendekatan ilmiah dan reflektif, penulis mengajak pembaca untuk memahami psikologi keuangan serta strategi mengatasi tekanan mental akibat masalah finansial."));

// Politik
        rak[5].tambah(new KoleksiBuku("Kabinet Korupsi", Arrays.asList("Anonym"), 1513, "Kabinet Korupsi (1513) karya Anonym adalah buku yang membahas praktik korupsi dalam pemerintahan sejak zaman dahulu. Dengan pendekatan historis dan analitis, buku ini mengeksplorasi bagaimana kekuasaan cenderung disalahgunakan untuk kepentingan pribadi atau kelompok. Meskipun ditulis berabad-abad lalu, isinya tetap relevan dalam memahami sifat dasar manusia dalam politik dan kekuasaan."));
        rak[5].tambah(new KoleksiBuku("Lembaga eksekutif atau pemimpin korupsi", Arrays.asList("Akhmad the thinkerer"), -500, "Lembaga Eksekutif atau Pemimpin Korupsi (-500) karya Akhmad the Thinkerer adalah buku politik kuno yang membahas hubungan antara kekuasaan dan moralitas. Buku ini mengeksplorasi bagaimana pemimpin cenderung terjerumus dalam korupsi serta bagaimana sistem pemerintahan dapat membentuk atau mencegah praktik tersebut. Dengan sudut pandang reflektif, penulis mengajak pembaca untuk merenungkan sifat dasar manusia dalam mengelola kekuasaan dan integritas."));
        rak[5].tambah(new KoleksiBuku("Indonesia Komunis is real?", Arrays.asList("Cucu DN. Aidit"), 1835, "Indonesia Komunis is Real? (1835) karya Cucu DN. Aidit adalah buku fiksi alternatif yang mencoba membayangkan bagaimana komunisme bisa berkembang di Indonesia jauh sebelum ideologi tersebut muncul di abad ke-20. Dengan pendekatan spekulatif, buku ini mengeksplorasi dinamika sosial, politik, dan ekonomi yang mungkin memicu kemunculan paham tersebut di Nusantara pada era kolonial. Meskipun ditulis dengan gaya historis, buku ini lebih merupakan refleksi terhadap ideologi dan pengaruhnya terhadap masyarakat."));
        rak[5].tambah(new KoleksiBuku("Gelar Jokowi", Arrays.asList("MOMON", "Alison sks", "AHMADTUKAM"), 1787, "JGelar Jokowi (1787) adalah buku politik yang membahas fenomena pemberian gelar kehormatan kepada pemimpin dalam konteks sejarah dan kekuasaan. Ditulis oleh MOMON, Alison SKS, dan AHMADTUKAM, buku ini mengeksplorasi bagaimana gelar digunakan sebagai alat legitimasi politik, baik untuk memperkuat citra pemimpin maupun sebagai bentuk diplomasi kekuasaan. Dengan analisis yang tajam, buku ini mengajak pembaca untuk memahami hubungan antara simbolisme, politik, dan persepsi masyarakat terhadap kepemimpinan."));
        rak[5].tambah(new KoleksiBuku("DPR orang yang kaya", Arrays.asList("Plato sang politikus"), -380, "ODPR Orang yang Kaya (-380) karya Plato Sang Politikus adalah buku filsafat politik yang mengupas hubungan antara kekayaan dan kekuasaan dalam sistem pemerintahan. Dengan pendekatan kritis, buku ini mengeksplorasi bagaimana para pemimpin sering kali berasal dari golongan kaya dan bagaimana hal tersebut memengaruhi kebijakan yang mereka buat. Sebagai refleksi terhadap oligarki dan demokrasi, buku ini mempertanyakan apakah kepemimpinan yang ideal harus didasarkan pada harta atau kebijaksanaan."));

// Fiksi
        rak[6].tambah(new KoleksiBuku("Raja Jawir penguasa Sumatra", Arrays.asList("Joko Susilo"), 1951, "Raja Jawir Penguasa Sumatra (1951) karya Joko Susilo adalah buku sejarah yang mengisahkan perjalanan seorang pemimpin legendaris yang berpengaruh di Sumatra. Buku ini menggali bagaimana Raja Jawir membangun kekuasaannya, menghadapi tantangan politik, serta strategi kepemimpinannya dalam mengelola wilayahnya. Dengan narasi yang kaya akan detail historis, buku ini memberikan wawasan tentang dinamika kekuasaan di Sumatra pada masanya."));
        rak[6].tambah(new KoleksiBuku("Madura Story ", Arrays.asList("Septian Parkir Samping"), 1960, "Madura Story (1960) karya Septian Parkir Samping adalah buku yang mengisahkan sejarah, budaya, dan kehidupan masyarakat Madura dalam berbagai aspek. Buku ini mengeksplorasi nilai-nilai khas Madura, seperti keberanian, kerja keras, dan solidaritas sosial yang kuat. Dengan gaya penceritaan yang menarik, karya ini memberikan wawasan mendalam tentang identitas dan perjalanan masyarakat Madura dalam menghadapi perubahan zaman."));
        rak[6].tambah(new KoleksiBuku("Legenda Maluku Merdeka", Arrays.asList("Dewok Edutech"), 1949, "Legenda Maluku Merdeka (1949) karya Dewok Edutech adalah buku yang mengisahkan perjuangan Maluku dalam konteks kemerdekaan dan dinamika politik pascakolonial. Buku ini mengeksplorasi tokoh-tokoh penting, perlawanan rakyat, serta faktor sosial dan budaya yang membentuk gerakan kemerdekaan di wilayah tersebut. Dengan pendekatan historis dan narasi yang kuat, buku ini memberikan wawasan mendalam tentang semangat perjuangan dan identitas Maluku di era perubahan."));
        rak[6].tambah(new KoleksiBuku("Sang Pemimpin Jawa", Arrays.asList("Anubis Anonym"), 1925, "Sang Pemimpin Jawa (1925) karya Anubis Anonym adalah buku yang membahas figur-figur kepemimpinan di tanah Jawa dari masa kerajaan hingga era kolonial. Buku ini mengeksplorasi gaya kepemimpinan, strategi politik, serta pengaruh budaya dan spiritual dalam membentuk karakter seorang pemimpin Jawa. Dengan pendekatan historis yang mendalam, karya ini menggambarkan bagaimana nilai-nilai tradisional tetap berperan dalam dinamika kepemimpinan di tengah perubahan zaman."));
        rak[6].tambah(new KoleksiBuku("Indonesia Emas 2045", Arrays.asList("Ghani Baskara"), 1813, "Indonesia Emas 2045 (1813) karya Ghani Baskara adalah novel fiksi yang membayangkan masa depan Indonesia di tahun 2045 sebagai negara maju dan sejahtera. Dengan latar dunia futuristik, buku ini menggambarkan bagaimana teknologi, politik, dan budaya berkembang dalam perjalanan menuju \"Indonesia Emas.\" Melalui tokoh-tokoh visioner dan tantangan yang mereka hadapi, novel ini menawarkan refleksi mendalam tentang harapan, inovasi, dan kemungkinan masa depan bangsa."));
    }

    private static void tampilkanSemuaBuku() {
        System.out.println("\n═══ DAFTAR KOLEKSI BUKU ═══");
        for (KelompokBuku kategori : rak) {
            kategori.tampilkanKoleksi();
        }
    }

    private static void cekKesamaanBuku() {
        System.out.println("\n═══ CEK TINGKAT KESAMAAN BUKU ═══");

        System.out.println("\nKategori Buku:");
        for (int i = 0; i < rak.length; i++) {
            System.out.println((i + 1) + ". " + rak[i].getJenis());
        }

        KoleksiBuku buku1 = pilihBuku("Pilih buku pertama");
        if (buku1 == null) {
            return;
        }

        KoleksiBuku buku2 = pilihBuku("Pilih buku kedua");
        if (buku2 == null) {
            return;
        }

        System.out.println("\n════════════════════════════════");
        System.out.println(" INFORMASI BUKU PERTAMA");
        System.out.println("════════════════════════════════");
        buku1.tampil();

        System.out.println("\n════════════════════════════════");
        System.out.println(" INFORMASI BUKU KEDUA");
        System.out.println("════════════════════════════════");
        buku2.tampil();

        System.out.println("\n════════════════════════════════");
        System.out.println(" HASIL PERBANDINGAN");
        System.out.println("════════════════════════════════");
        double similarity = buku1.cekTingkatKesamaan(buku2);
        System.out.println("\nTingkat Kesamaan: " + String.format("%.2f%%", similarity));
    }

    private static KoleksiBuku pilihBuku(String message) {
        System.out.println("\n" + message + ":");

        System.out.println("Pilih kategori buku:");
        for (int i = 0; i < rak.length; i++) {
            System.out.println((i + 1) + ". " + rak[i].getJenis());
        }

        System.out.print("Pilih kategori (1-" + rak.length + "): ");
        int categoryChoice = getIntInput();

        if (categoryChoice < 1 || categoryChoice > rak.length) {
            System.out.println("Kategori tidak valid.");
            return null;
        }

        KelompokBuku selectedCategory = rak[categoryChoice - 1];

        if (selectedCategory.inventaris.isEmpty()) {
            System.out.println("Kategori " + selectedCategory.getJenis() + " tidak memiliki buku.");
            return null;
        }
        System.out.println("\nPilih buku dari kategori " + selectedCategory.getJenis() + ":");
        for (int i = 0; i < selectedCategory.inventaris.size(); i++) {
            System.out.println((i + 1) + ". " + selectedCategory.inventaris.get(i).getNamaBuku());
        }

        System.out.print("Pilih buku (1-" + selectedCategory.inventaris.size() + "): ");
        int bookChoice = getIntInput();

        if (bookChoice < 1 || bookChoice > selectedCategory.inventaris.size()) {
            System.out.println("Pilihan buku tidak valid.");
            return null;
        }

        return selectedCategory.inventaris.get(bookChoice - 1);
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}