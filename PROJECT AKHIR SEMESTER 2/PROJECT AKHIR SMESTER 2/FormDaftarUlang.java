//FormDaftarUlang.java

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File; // Ditambahkan untuk penyimpanan file
import java.io.FileWriter;           // Ditambahkan untuk penyimpanan file
import java.io.IOException;     // Ditambahkan untuk penyimpanan file
import javax.swing.*;    // Ditambahkan untuk error handling file
// javax.swing.JFileChooser sudah tercakup oleh javax.swing.*

public class FormDaftarUlang extends JFrame {

    // Komponen-komponen form
    private JTextField txtNama, txtNIM, txtTempatLahir, txtEmail, txtNoHP, txtNamaOrtu, txtNoHPOrtu;
    private JTextArea txtAlamat;
    private JComboBox<String> cmbJurusan, cmbFakultas, cmbJenisKelamin;
    private JComboBox<Integer> cmbTanggal, cmbTahun;
    private JComboBox<String> cmbBulan;
    private JRadioButton rbRegular, rbKelasKaryawan;
    private JCheckBox cbPernyataan;
    private JButton btnSubmit, btnReset;

    private JPanel mainPanel;

    public FormDaftarUlang() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(750, 700); // Adjusted height slightly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents(); // Initialize all UI components

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(UIConstants.BACKGROUND_COLOR);

        // Panel Header
        HeaderPanel headerPanel = new HeaderPanel();
        mainPanel.add(headerPanel);

        // Panel Data Pribadi
        JPanel sectionPersonalData = PanelFactory.createSectionPanel("Data Pribadi");
        PersonalDataPanel personalDataPanel = new PersonalDataPanel(txtNama, txtNIM, cmbJenisKelamin,
                txtTempatLahir, cmbTanggal, cmbBulan, cmbTahun, txtAlamat, txtEmail, txtNoHP);
        sectionPersonalData.add(personalDataPanel);
        mainPanel.add(sectionPersonalData);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Panel Data Akademik
        JPanel sectionAcademicData = PanelFactory.createSectionPanel("Data Akademik");
        // Create listener for fakultas ComboBox
        ActionListener fakultasListener = e -> updateJurusan();
        AcademicDataPanel academicDataPanel = new AcademicDataPanel(cmbFakultas, cmbJurusan,
                rbRegular, rbKelasKaryawan, fakultasListener);
        sectionAcademicData.add(academicDataPanel);
        mainPanel.add(sectionAcademicData);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Panel Data Orang Tua
        JPanel sectionParentData = PanelFactory.createSectionPanel("Data Orang Tua/Wali");
        ParentDataPanel parentDataPanel = new ParentDataPanel(txtNamaOrtu, txtNoHPOrtu);
        sectionParentData.add(parentDataPanel);
        mainPanel.add(sectionParentData);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Panel Kontrol (Pernyataan dan Tombol)
        // Pastikan Anda memiliki kelas ControlsPanel atau sesuaikan bagian ini
        // Untuk contoh, saya asumsikan ControlsPanel ada dan berfungsi seperti sebelumnya.
        ControlsPanel controlsPanel = new ControlsPanel(cbPernyataan, btnSubmit, btnReset,
                e -> submitForm(), e -> resetForm());
        mainPanel.add(controlsPanel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        setVisible(true);
    }

    private void initComponents() {
        // Input teks
        txtNama = new JTextField(20);
        txtNIM = new JTextField(20);
        txtTempatLahir = new JTextField(10); // Adjusted size
        txtEmail = new JTextField(20);
        txtNoHP = new JTextField(20);
        txtNamaOrtu = new JTextField(20);
        txtNoHPOrtu = new JTextField(20);

        txtAlamat = new JTextArea(3, 20); // Rows, Columns

        // Dropdown Jenis Kelamin
        String[] jenisKelaminOptions = {"-- Pilih --", "Laki-laki", "Perempuan"};
        cmbJenisKelamin = new JComboBox<>(jenisKelaminOptions);

        // Dropdown Tanggal Lahir
        Integer[] tanggalOptions = new Integer[32]; // 0 untuk "--Pilih--"
        tanggalOptions[0] = null; // Atau representasi "--Pilih--" jika diperlukan validasi khusus
        for (int i = 1; i <= 31; i++) tanggalOptions[i] = i;
        cmbTanggal = new JComboBox<>(tanggalOptions);
        // Set a custom renderer to display "--Pilih--" for null
        cmbTanggal.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value == null) {
                    setText("-- Tanggal --");
                }
                return this;
            }
        });
        cmbTanggal.setSelectedIndex(0);


        String[] bulanOptions = {"-- Bulan --", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                                 "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        cmbBulan = new JComboBox<>(bulanOptions);

        Integer[] tahunOptions = new Integer[31]; // 0 untuk "--Pilih--"
        tahunOptions[0] = null;
        for (int i = 0; i < 30; i++) tahunOptions[i+1] = 2007 - i;
        cmbTahun = new JComboBox<>(tahunOptions);
        cmbTahun.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value == null) {
                    setText("-- Tahun --");
                }
                return this;
            }
        });
        cmbTahun.setSelectedIndex(0);
        
        // Dropdown Akademik
        String[] fakultasOptions = {"-- Pilih --", "Teknik", "Ekonomi dan Bisnis", "Ilmu Komputer",
                                    "Kedokteran", "Hukum", "Ilmu Sosial dan Politik"};
        cmbFakultas = new JComboBox<>(fakultasOptions);

        String[] jurusanInitialOptions = {"-- Pilih Fakultas Dahulu --"};
        cmbJurusan = new JComboBox<>(jurusanInitialOptions);

        // Radio button
        rbRegular = new JRadioButton("Regular", true);
        rbKelasKaryawan = new JRadioButton("Kelas Karyawan", false);
        // ButtonGroup is handled within AcademicDataPanel

        // Checkbox
        cbPernyataan = new JCheckBox("Saya menyatakan bahwa data yang saya isi adalah benar");

        // Tombol
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
    }


    private void updateJurusan() {
        cmbJurusan.removeAllItems();
        String selectedFakultas = (String) cmbFakultas.getSelectedItem();
        String[] jurusan = {};

        if (selectedFakultas == null) selectedFakultas = ""; // handle null case

        switch (selectedFakultas) {
            case "Teknik":
                jurusan = new String[]{"-- Pilih --", "Teknik Sipil", "Teknik Mesin", "Teknik Elektro", "Teknik Kimia", "Arsitektur"};
                break;
            case "Ekonomi dan Bisnis":
                jurusan = new String[]{"-- Pilih --", "Manajemen", "Akuntansi", "Ekonomi Pembangunan", "Bisnis Digital"};
                break;
            case "Ilmu Komputer":
                jurusan = new String[]{"-- Pilih --", "Informatika", "Sistem Informasi", "Teknologi Informasi", "Data Science"};
                break;
            case "Kedokteran":
                jurusan = new String[]{"-- Pilih --", "Kedokteran Umum", "Kedokteran Gigi", "Keperawatan", "Farmasi"};
                break;
            case "Hukum":
                jurusan = new String[]{"-- Pilih --", "Ilmu Hukum", "Hukum Bisnis"};
                break;
            case "Ilmu Sosial dan Politik":
                jurusan = new String[]{"-- Pilih --", "Ilmu Komunikasi", "Hubungan Internasional", "Administrasi Publik", "Sosiologi"};
                break;
            default:
                jurusan = new String[]{"-- Pilih Fakultas Dahulu --"};
                break;
        }
        for (String j : jurusan) {
            cmbJurusan.addItem(j);
        }
    }

    private void resetForm() {
        txtNama.setText("");
        txtNIM.setText("");
        txtTempatLahir.setText("");
        txtAlamat.setText("");
        txtEmail.setText("");
        txtNoHP.setText("");
        txtNamaOrtu.setText("");
        txtNoHPOrtu.setText("");

        cmbJenisKelamin.setSelectedIndex(0);
        cmbFakultas.setSelectedIndex(0); // This will trigger updateJurusan
        cmbTanggal.setSelectedIndex(0);
        cmbBulan.setSelectedIndex(0);
        cmbTahun.setSelectedIndex(0);

        rbRegular.setSelected(true);
        cbPernyataan.setSelected(false);
    }

    private boolean validateForm() {
        StringBuilder errorMessage = new StringBuilder("Mohon lengkapi data berikut:\n");
        boolean valid = true;

        if (txtNama.getText().trim().isEmpty()) { errorMessage.append("- Nama Lengkap\n"); valid = false; }
        if (txtNIM.getText().trim().isEmpty()) { errorMessage.append("- NIM\n"); valid = false; }
        if (cmbJenisKelamin.getSelectedIndex() == 0) { errorMessage.append("- Jenis Kelamin\n"); valid = false; }
        if (txtTempatLahir.getText().trim().isEmpty()) { errorMessage.append("- Tempat Lahir\n"); valid = false; }
        
        // Validasi Tanggal Lahir
        if (cmbTanggal.getSelectedItem() == null || cmbTanggal.getSelectedIndex() == 0) {
            errorMessage.append("- Tanggal Lahir (Tanggal)\n"); valid = false;
        }
        if (cmbBulan.getSelectedIndex() == 0) {
            errorMessage.append("- Tanggal Lahir (Bulan)\n"); valid = false;
        }
        if (cmbTahun.getSelectedItem() == null || cmbTahun.getSelectedIndex() == 0) {
            errorMessage.append("- Tanggal Lahir (Tahun)\n"); valid = false;
        }

        if (txtAlamat.getText().trim().isEmpty()) { errorMessage.append("- Alamat Lengkap\n"); valid = false; }
        if (txtEmail.getText().trim().isEmpty()) { errorMessage.append("- Email\n"); valid = false; }
        else if (!txtEmail.getText().trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errorMessage.append("- Format Email tidak valid\n"); valid = false;
        }
        if (txtNoHP.getText().trim().isEmpty()) { errorMessage.append("- Nomor HP\n"); valid = false; }
        else if (!txtNoHP.getText().trim().matches("\\d{10,13}")) { 
            errorMessage.append("- Nomor HP tidak valid (harus angka, 10-13 digit)\n"); valid = false;
        }

        if (cmbFakultas.getSelectedIndex() == 0) { errorMessage.append("- Fakultas\n"); valid = false; }
        if (cmbJurusan.getSelectedIndex() == 0 || cmbJurusan.getSelectedItem().equals("-- Pilih Fakultas Dahulu --")) {
            errorMessage.append("- Program Studi\n"); valid = false;
        }
        
        if (txtNamaOrtu.getText().trim().isEmpty()) { errorMessage.append("- Nama Orang Tua/Wali\n"); valid = false; }
        if (txtNoHPOrtu.getText().trim().isEmpty()) { errorMessage.append("- Nomor HP Orang Tua/Wali\n"); valid = false; }
        else if (!txtNoHPOrtu.getText().trim().matches("\\d{10,13}")) { 
            errorMessage.append("- Nomor HP Orang Tua/Wali tidak valid (harus angka, 10-13 digit)\n"); valid = false;
        }

        if (!cbPernyataan.isSelected()) { errorMessage.append("- Centang pernyataan bahwa data yang diisi benar\n"); valid = false; }

        if (!valid) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        return valid;
    }

    private void submitForm() {
        if (!validateForm()) {
            return;
        }

        int choice = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin data yang Anda isi sudah benar?",
                "Konfirmasi Data", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (choice == JOptionPane.OK_OPTION) {
            // Ambil semua data dari form
            String nama = txtNama.getText();
            String nim = txtNIM.getText();
            String jenisKelamin = cmbJenisKelamin.getSelectedItem().toString();
            String tempatLahir = txtTempatLahir.getText();
            String tanggal = cmbTanggal.getSelectedItem() != null ? cmbTanggal.getSelectedItem().toString() : "";
            String bulan = cmbBulan.getSelectedItem() != null ? cmbBulan.getSelectedItem().toString() : "";
            String tahun = cmbTahun.getSelectedItem() != null ? cmbTahun.getSelectedItem().toString() : "";
            String tanggalLahir = tanggal + " " + bulan + " " + tahun;
            String ttl = tempatLahir + ", " + tanggalLahir.trim();
            String alamat = txtAlamat.getText();
            String email = txtEmail.getText();
            String noHp = txtNoHP.getText();
            String fakultas = cmbFakultas.getSelectedItem().toString();
            String jurusan = cmbJurusan.getSelectedItem().toString();
            String kelas = rbRegular.isSelected() ? "Regular" : "Kelas Karyawan";
            String namaOrtu = txtNamaOrtu.getText();
            String noHpOrtu = txtNoHPOrtu.getText();

            // Tampilkan summary window terlebih dahulu
            new SummaryWindow(nama, nim, jenisKelamin, ttl, alamat, email, noHp,
                              fakultas, jurusan, kelas, namaOrtu, noHpOrtu);
            
            // Kemudian, simpan data ke file
            saveDataToFile(nama, nim, jenisKelamin, ttl, alamat, email, noHp,
                           fakultas, jurusan, kelas, namaOrtu, noHpOrtu);
        }
    }

    // Method showSummary() tidak lagi dipanggil langsung dari submitForm,
    // karena SummaryWindow dibuat di submitForm sebelum saveDataToFile.
    // Jika Anda ingin memisahkan logika pembuatan SummaryWindow, Anda bisa memanggilnya
    // dari submitForm seperti sebelumnya dan saveDataToFile juga dari submitForm.
    // Untuk contoh ini, SummaryWindow dibuat di submitForm.

    // Method baru untuk menyimpan data ke file
    private void saveDataToFile(String nama, String nim, String jenisKelamin, String ttl, String alamat,
                                String email, String noHp, String fakultas, String jurusan, String kelas,
                                String namaOrtu, String noHpOrtu) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan Data Pendaftaran");
        // Menyarankan nama file default (misalnya berdasarkan NIM)
        fileChooser.setSelectedFile(new File(nim + "_DataPendaftaran.txt"));

        // Set filter untuk hanya menampilkan file .txt atau semua file
        javax.swing.filechooser.FileNameExtensionFilter filter = new javax.swing.filechooser.FileNameExtensionFilter(
        "Text Files (*.txt)", "txt");
        fileChooser.setFileFilter(filter);


        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // Pastikan file memiliki ekstensi .txt jika pengguna tidak mengetikkannya
            // dan filter yang dipilih adalah .txt
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".txt")) {
                fileToSave = new File(filePath + ".txt");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                // Tulis data ke file dengan format sederhana (label: nilai)
                writer.write("=== DATA PRIBADI ==="); writer.newLine();
                writer.write("Nama Lengkap: " + nama); writer.newLine();
                writer.write("NIM: " + nim); writer.newLine();
                writer.write("Jenis Kelamin: " + jenisKelamin); writer.newLine();
                writer.write("Tempat, Tanggal Lahir: " + ttl); writer.newLine();
                writer.write("Alamat: " + alamat.replace("\n", " | ")); // Ganti newline di alamat
                writer.newLine();
                writer.write("Email: " + email); writer.newLine();
                writer.write("Nomor HP: " + noHp); writer.newLine();
                writer.newLine(); 
                writer.write("=== DATA AKADEMIK ==="); writer.newLine();
                writer.write("Fakultas: " + fakultas); writer.newLine();
                writer.write("Program Studi: " + jurusan); writer.newLine();
                writer.write("Kelas: " + kelas); writer.newLine();
                writer.newLine(); 
                writer.write("=== DATA ORANG TUA/WALI ==="); writer.newLine();
                writer.write("Nama Orang Tua/Wali: " + namaOrtu); writer.newLine();
                writer.write("Nomor HP Orang Tua/Wali: " + noHpOrtu); writer.newLine();
                writer.newLine();
                writer.write("Pernyataan: Data yang diisi adalah benar."); writer.newLine();


                JOptionPane.showMessageDialog(this,
                        "Data berhasil disimpan ke:\n" + fileToSave.getAbsolutePath(),
                        "Penyimpanan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Gagal menyimpan data: " + ex.getMessage(),
                        "Error Penyimpanan", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace(); // Penting untuk debugging
            }
        }
    }


    public static void main(String[] args) {
        try {
            // Menggunakan Look and Feel default sistem untuk tampilan yang lebih modern
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Jika gagal, gunakan Look and Feel default Java (Metal)
            e.printStackTrace(); 
        }

        SwingUtilities.invokeLater(() -> new FormDaftarUlang());
    }
}
