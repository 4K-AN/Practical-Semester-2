import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FormDaftarUlang extends JFrame {

    // Komponen-komponen form
// Daftar variabel komponen GUI yang akan digunakan di form:

// Input teks untuk data mahasiswa dan orang tua
private JTextField txtNama,       // Nama lengkap mahasiswa
                   txtNIM,        // Nomor Induk Mahasiswa
                   txtTempatLahir,// Tempat lahir mahasiswa
                   txtEmail,      // Alamat email mahasiswa
                   txtNoHP,       // Nomor handphone mahasiswa
                   txtNamaOrtu,   // Nama orang tua/wali
                   txtNoHPOrtu;   // Nomor handphone orang tua/wali

private JTextArea txtAlamat;      // Area teks untuk alamat lengkap mahasiswa

// Dropdown (combo box) untuk pilihan akademik dan kelamin
private JComboBox<String> cmbJurusan,      // Program studi
                          cmbFakultas,     // Fakultas
                          cmbJenisKelamin;// Jenis kelamin

// Dropdown untuk tanggal lahir (Integer) dan tahun lahir
private JComboBox<Integer> cmbTanggal,     // Tanggal (1–31)
                       cmbTahun;         // Tahun (misal 2007, 2006, dst.)

private JComboBox<String> cmbBulan;        // Bulan lahir (Januari–Desember)

// Radio button untuk memilih jenis kelas
private JRadioButton rbRegular,            // Kelas Regular
                     rbKelasKaryawan;     // Kelas Karyawan

private JCheckBox cbPernyataan;            // Checkbox pernyataan kebenaran data

// Tombol aksi
private JButton btnSubmit,  // Tombol untuk submit form
                btnReset;   // Tombol untuk mereset/bersihkan form

private JPanel mainPanel;   // Panel utama yang menampung semua sub-panel

// Warna dan font untuk styling konsisten di seluruh form
// Palet warna baru sesuai request
private Color primaryColor = new Color(0xC5, 0xAD, 0xED);  // #C5ADED (ungu pastel lembut)
private Color accentColor  = new Color(0xF8, 0xAB, 0xEB);  // #F8ABEB (pink muda ceria)


private Font titleFont  = new Font("Segoe UI", Font.BOLD, 16); // Font untuk judul section
private Font labelFont  = new Font("Segoe UI", Font.PLAIN, 12); // Font untuk label field
private Font buttonFont = new Font("Segoe UI", Font.BOLD, 12); // Font untuk teks tombol


    public FormDaftarUlang() {
        // Atur judul jendela aplikasi
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        // Tentukan lebar dan tinggi jendela (pixels)
        setSize(750, 650);
        // Saat tombol close diklik, keluar dari aplikasi
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Posisikan jendela di tengah layar
        setLocationRelativeTo(null);

        // Membuat panel utama dengan BoxLayout vertikal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // Panel Header
        createHeaderPanel();

        // Panel Data Pribadi
        createPersonalDataPanel();

        // Panel Data Akademik
        createAcademicDataPanel();

        // Panel Data Orang Tua
        createParentDataPanel();

        // Panel Pernyataan dan Tombol
        createButtonPanel();

        // Menambahkan scrollpane untuk mainPanel
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        setVisible(true);
    }
/**
 * Membuat dan menambahkan panel header yang berisi:
 * - Judul utama form
 * - Subjudul tahun akademik
 * - Garis pemisah visual
 */
    private void createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        // Gunakan layout vertikal agar komponen ditumpuk atas-ke-bawah
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Beri jarak bawah agar tidak menempel ke komponen berikutnya
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        // Label judul form
        JLabel lblTitle = new JLabel("FORMULIR DAFTAR ULANG MAHASISWA BARU");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(primaryColor);
        lblTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Label subjudul tahun akademik
        JLabel lblSubtitle = new JLabel("Tahun Akademik 2025/2026");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Garis pemisah visual
        JSeparator separator = new JSeparator();
        separator.setForeground(accentColor);
        separator.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Tambahkan semua komponen ke panel header
        headerPanel.add(lblTitle);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        headerPanel.add(lblSubtitle);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        headerPanel.add(separator);

        mainPanel.add(headerPanel);
    }

    private void createPersonalDataPanel() {
        JPanel panelDataPribadi = createSectionPanel("Data Pribadi");

        // Nama Lengkap
        JPanel panelNama = createFieldPanel("Nama Lengkap *");
        txtNama = new JTextField(20);
        panelNama.add(txtNama);
        panelDataPribadi.add(panelNama);

        // NIM
        JPanel panelNIM = createFieldPanel("NIM *");
        txtNIM = new JTextField(20);
        panelNIM.add(txtNIM);
        panelDataPribadi.add(panelNIM);

        // Jenis Kelamin
        JPanel panelJK = createFieldPanel("Jenis Kelamin *");
        String[] jenisKelamin = {"-- Pilih --", "Laki-laki", "Perempuan"};
        cmbJenisKelamin = new JComboBox<>(jenisKelamin);
        panelJK.add(cmbJenisKelamin);
        panelDataPribadi.add(panelJK);

        // Tempat dan Tanggal Lahir
        JPanel panelTTL = createFieldPanel("Tempat, Tanggal Lahir *");
        txtTempatLahir = new JTextField(10);
        panelTTL.add(txtTempatLahir);

        panelTTL.add(new JLabel(", "));

        Integer[] tanggal = new Integer[31];
        for (int i = 0; i < 31; i++) {
            tanggal[i] = i + 1;
        }
        cmbTanggal = new JComboBox<>(tanggal);
        panelTTL.add(cmbTanggal);

        String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        cmbBulan = new JComboBox<>(namaBulan);
        panelTTL.add(cmbBulan);

        Integer[] tahun = new Integer[30];
        for (int i = 0; i < 30; i++) {
            tahun[i] = 2007 - i;
        }
        cmbTahun = new JComboBox<>(tahun);
        panelTTL.add(cmbTahun);

        panelDataPribadi.add(panelTTL);

        // Alamat
        JPanel panelAlamat = createFieldPanel("Alamat Lengkap *");
        txtAlamat = new JTextArea(4, 20);
        txtAlamat.setLineWrap(true);
        txtAlamat.setWrapStyleWord(true);
        JScrollPane scrollAlamat = new JScrollPane(txtAlamat);
        panelAlamat.add(scrollAlamat);
        panelDataPribadi.add(panelAlamat);

        // Email
        JPanel panelEmail = createFieldPanel("Email *");
        txtEmail = new JTextField(20);
        panelEmail.add(txtEmail);
        panelDataPribadi.add(panelEmail);

        // No. HP
        JPanel panelNoHP = createFieldPanel("Nomor HP *");
        txtNoHP = new JTextField(20);
        panelNoHP.add(txtNoHP);
        panelDataPribadi.add(panelNoHP);

        mainPanel.add(panelDataPribadi);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    }


    private void createAcademicDataPanel() {
        JPanel panelDataAkademik = createSectionPanel("Data Akademik");

        // Fakultas
        JPanel panelFakultas = createFieldPanel("Fakultas *");
        String[] fakultas = {"-- Pilih --", "Teknik", "Ekonomi dan Bisnis", "Ilmu Komputer",
            "Kedokteran", "Hukum", "Ilmu Sosial dan Politik"};
        cmbFakultas = new JComboBox<>(fakultas);
        cmbFakultas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateJurusan();
            }
        });

        // Fakultas
        panelFakultas.add(cmbFakultas);
        panelDataAkademik.add(panelFakultas);

        // Jurusan
        JPanel panelJurusan = createFieldPanel("Program Studi *");
        String[] jurusan = {"-- Pilih Fakultas Dahulu --"};
        cmbJurusan = new JComboBox<>(jurusan);
        panelJurusan.add(cmbJurusan);
        panelDataAkademik.add(panelJurusan);

        // Kelas
        JPanel panelKelas = createFieldPanel("Kelas *");
        rbRegular = new JRadioButton("Regular", true);
        rbKelasKaryawan = new JRadioButton("Kelas Karyawan", false);
        ButtonGroup bgKelas = new ButtonGroup();
        bgKelas.add(rbRegular);
        bgKelas.add(rbKelasKaryawan);

        rbRegular.setBackground(Color.WHITE);
        rbKelasKaryawan.setBackground(Color.WHITE);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        radioPanel.setBackground(Color.WHITE);
        radioPanel.add(rbRegular);
        radioPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        radioPanel.add(rbKelasKaryawan);

        panelKelas.add(radioPanel);
        panelDataAkademik.add(panelKelas);

        mainPanel.add(panelDataAkademik);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    }

    private void createParentDataPanel() {
        JPanel panelDataOrtu = createSectionPanel("Data Orang Tua/Wali");

        // Nama Orang Tua
        JPanel panelNamaOrtu = createFieldPanel("Nama Orang Tua/Wali *");
        txtNamaOrtu = new JTextField(20);
        panelNamaOrtu.add(txtNamaOrtu);
        panelDataOrtu.add(panelNamaOrtu);

        // No. HP Orang Tua
        JPanel panelNoHPOrtu = createFieldPanel("Nomor HP Orang Tua/Wali *");
        txtNoHPOrtu = new JTextField(20);
        panelNoHPOrtu.add(txtNoHPOrtu);
        panelDataOrtu.add(panelNoHPOrtu);

        mainPanel.add(panelDataOrtu);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    }

    private void createButtonPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        bottomPanel.setBackground(Color.WHITE);

        // Panel Pernyataan
        JPanel panelPernyataan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPernyataan.setBackground(Color.WHITE);
        panelPernyataan.setAlignmentX(Component.LEFT_ALIGNMENT);

        cbPernyataan = new JCheckBox("Saya menyatakan bahwa data yang saya isi adalah benar");
        cbPernyataan.setFont(labelFont);
        cbPernyataan.setBackground(Color.WHITE);
        panelPernyataan.add(cbPernyataan);

        // Panel Tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(buttonFont);
        btnSubmit.setBackground(primaryColor);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        btnReset = new JButton("Reset");
        btnReset.setFont(buttonFont);
        btnReset.setBackground(Color.WHITE);
        btnReset.setForeground(primaryColor);
        btnReset.setFocusPainted(false);
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        buttonPanel.add(btnReset);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(btnSubmit);

        bottomPanel.add(panelPernyataan);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(buttonPanel);

        mainPanel.add(bottomPanel);
    }

    private JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(230, 230, 230)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(titleFont);
        lblTitle.setForeground(primaryColor);
        lblTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JSeparator separator = new JSeparator();
        separator.setForeground(accentColor);
        separator.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lblTitle);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(separator);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        return panel;
    }

    private JPanel createFieldPanel(String label) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblField = new JLabel(label);
        lblField.setFont(labelFont);
        lblField.setPreferredSize(new Dimension(150, 20));

        panel.add(lblField);

        return panel;
    }

    private void updateJurusan() {
        cmbJurusan.removeAllItems();

        String selectedFakultas = (String) cmbFakultas.getSelectedItem();

        if (selectedFakultas.equals("Teknik")) {
            String[] jurusan = {"-- Pilih --", "Teknik Sipil", "Teknik Mesin", "Teknik Elektro", "Teknik Kimia", "Arsitektur"};
            for (String j : jurusan) {
                cmbJurusan.addItem(j);
            }
        } else if (selectedFakultas.equals("Ekonomi dan Bisnis")) {
            String[] jurusan = {"-- Pilih --", "Manajemen", "Akuntansi", "Ekonomi Pembangunan", "Bisnis Digital"};
            for (String j : jurusan) {
                cmbJurusan.addItem(j);
            }
        } else if (selectedFakultas.equals("Ilmu Komputer")) {
            String[] jurusan = {"-- Pilih --", "Informatika", "Sistem Informasi", "Teknologi Informasi", "Data Science"};
            for (String j : jurusan) {
                cmbJurusan.addItem(j);
            }
        } else if (selectedFakultas.equals("Kedokteran")) {
            String[] jurusan = {"-- Pilih --", "Kedokteran Umum", "Kedokteran Gigi", "Keperawatan", "Farmasi"};
            for (String j : jurusan) {
                cmbJurusan.addItem(j);
            }
        } else if (selectedFakultas.equals("Hukum")) {
            String[] jurusan = {"-- Pilih --", "Ilmu Hukum", "Hukum Bisnis"};
            for (String j : jurusan) {
                cmbJurusan.addItem(j);
            }
        } else if (selectedFakultas.equals("Ilmu Sosial dan Politik")) {
            String[] jurusan = {"-- Pilih --", "Ilmu Komunikasi", "Hubungan Internasional", "Administrasi Publik", "Sosiologi"};
            for (String j : jurusan) {
                cmbJurusan.addItem(j);
            }
        } else {
            cmbJurusan.addItem("-- Pilih Fakultas Dahulu --");
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
        cmbFakultas.setSelectedIndex(0);
        cmbTanggal.setSelectedIndex(0);
        cmbBulan.setSelectedIndex(0);
        cmbTahun.setSelectedIndex(0);

        rbRegular.setSelected(true);
        cbPernyataan.setSelected(false);
    }

    private boolean validateForm() {
        StringBuilder errorMessage = new StringBuilder("Mohon lengkapi data berikut:\n");
        boolean valid = true;

        if (txtNama.getText().trim().isEmpty()) {
            errorMessage.append("- Nama Lengkap\n");
            valid = false;
        }

        if (txtNIM.getText().trim().isEmpty()) {
            errorMessage.append("- NIM\n");
            valid = false;
        }

        if (cmbJenisKelamin.getSelectedIndex() == 0) {
            errorMessage.append("- Jenis Kelamin\n");
            valid = false;
        }

        if (txtTempatLahir.getText().trim().isEmpty()) {
            errorMessage.append("- Tempat Lahir\n");
            valid = false;
        }

        if (txtAlamat.getText().trim().isEmpty()) {
            errorMessage.append("- Alamat Lengkap\n");
            valid = false;
        }

        if (txtEmail.getText().trim().isEmpty()) {
            errorMessage.append("- Email\n");
            valid = false;
        }

        if (txtNoHP.getText().trim().isEmpty()) {
            errorMessage.append("- Nomor HP\n");
            valid = false;
        }

        if (cmbFakultas.getSelectedIndex() == 0) {
            errorMessage.append("- Fakultas\n");
            valid = false;
        }

        if (cmbJurusan.getSelectedIndex() == 0 || cmbJurusan.getSelectedItem().equals("-- Pilih Fakultas Dahulu --")) {
            errorMessage.append("- Program Studi\n");
            valid = false;
        }

        if (txtNamaOrtu.getText().trim().isEmpty()) {
            errorMessage.append("- Nama Orang Tua/Wali\n");
            valid = false;
        }

        if (txtNoHPOrtu.getText().trim().isEmpty()) {
            errorMessage.append("- Nomor HP Orang Tua/Wali\n");
            valid = false;
        }

        if (!cbPernyataan.isSelected()) {
            errorMessage.append("- Centang pernyataan bahwa data yang diisi benar\n");
            valid = false;
        }

        if (!valid) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

        return valid;
    }

    private void submitForm() {
        if (!validateForm()) {
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Apakah anda yakin data yang Anda isi sudah benar?",
                "Konfirmasi Data",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.OK_OPTION) {
            showSummaryWindow();
        }
    }


    private void showSummaryWindow() {
        JFrame summaryFrame = new JFrame("Ringkasan Data Daftar Ulang");
        summaryFrame.setSize(600, 500);
        summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        summaryFrame.setLocationRelativeTo(this);

        // Create summary panel
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.Y_AXIS));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        summaryPanel.setBackground(Color.WHITE);

        // Header
        JLabel headerLabel = new JLabel("RINGKASAN DATA DAFTAR ULANG");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerLabel.setForeground(primaryColor);
        headerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        summaryPanel.add(headerLabel);
        summaryPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Data table
        JPanel dataPanel = new JPanel(new GridLayout(0, 2, 10, 8));
        dataPanel.setBackground(Color.WHITE);
        dataPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Set border for the data panel
        dataPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(230, 230, 230)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Data Pribadi
        addDataRow(dataPanel, "Nama Lengkap:", txtNama.getText());
        addDataRow(dataPanel, "NIM:", txtNIM.getText());
        addDataRow(dataPanel, "Jenis Kelamin:", cmbJenisKelamin.getSelectedItem().toString());

        // Tanggal Lahir
        String tanggalLahir = cmbTanggal.getSelectedItem() + " "
                + cmbBulan.getSelectedItem() + " "
                + cmbTahun.getSelectedItem();
        addDataRow(dataPanel, "Tempat, Tanggal Lahir:", txtTempatLahir.getText() + ", " + tanggalLahir);
        addDataRow(dataPanel, "Alamat:", txtAlamat.getText());
        addDataRow(dataPanel, "Email:", txtEmail.getText());
        addDataRow(dataPanel, "Nomor HP:", txtNoHP.getText());

        // Data Akademik
        addDataRow(dataPanel, "Fakultas:", cmbFakultas.getSelectedItem().toString());
        addDataRow(dataPanel, "Program Studi:", cmbJurusan.getSelectedItem().toString());
        addDataRow(dataPanel, "Kelas:", rbRegular.isSelected() ? "Regular" : "Kelas Karyawan");

        // Data Orang Tua
        addDataRow(dataPanel, "Nama Orang Tua/Wali:", txtNamaOrtu.getText());
        addDataRow(dataPanel, "Nomor HP Orang Tua/Wali:", txtNoHPOrtu.getText());

        summaryPanel.add(dataPanel);
        summaryPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Success message
        JPanel successPanel = new JPanel();
        successPanel.setLayout(new BoxLayout(successPanel, BoxLayout.Y_AXIS));
        successPanel.setBackground(new Color(232, 245, 233));
        successPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(165, 214, 167)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        successPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Success label
        JLabel successLabel = new JLabel("✓ Pendaftaran anda telah berhasil!");
        successLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        successLabel.setForeground(new Color(46, 125, 50));
        successLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Instruction label
        JLabel instructionLabel = new JLabel("Silakan cetak ringkasan ini dan bawa saat registrasi ulang pada tanggal yang telah ditentukan.");
        instructionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        instructionLabel.setForeground(new Color(46, 125, 50));
        instructionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add components to success panel
        successPanel.add(successLabel);
        successPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        successPanel.add(instructionLabel);

        summaryPanel.add(successPanel);

        // Tombol Cetak
        JButton btnPrint = new JButton("Cetak");
        btnPrint.setFont(buttonFont);
        btnPrint.setBackground(primaryColor);
        btnPrint.setForeground(Color.WHITE);
        btnPrint.setFocusPainted(false);
        btnPrint.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(summaryFrame, "Fungsi cetak akan diimplementasikan di sistem nyata.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(btnPrint);
        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add components to summary panel
        summaryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        summaryPanel.add(btnPanel);

        // Create summary frame
        JScrollPane scrollPane = new JScrollPane(summaryPanel);
        scrollPane.setBorder(null);
        summaryFrame.add(scrollPane);

        summaryFrame.setVisible(true);
    }
    
    private void addDataRow(JPanel panel, String label, String value) {
        JLabel lblName = new JLabel(label);
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel.add(lblName);

        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel.add(lblValue);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormDaftarUlang();
            }
        });
    }
}