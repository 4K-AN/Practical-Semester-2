import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
// No need for SimpleDateFormat or java.util.Date if not used for parsing/formatting dates directly for display
// java.util.* might still be needed for Arrays or other collections if used.

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
        Integer[] tanggalOptions = new Integer[31];
        for (int i = 0; i < 31; i++) tanggalOptions[i] = i + 1;
        cmbTanggal = new JComboBox<>(tanggalOptions);

        String[] bulanOptions = {"Januari", "Februari", "Maret", "April", "Mei", "Juni",
                                 "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        cmbBulan = new JComboBox<>(bulanOptions);

        Integer[] tahunOptions = new Integer[30];
        for (int i = 0; i < 30; i++) tahunOptions[i] = 2007 - i;
        cmbTahun = new JComboBox<>(tahunOptions);
        
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
        // Check if date combo boxes are at default/placeholder if you add one
        if (cmbTanggal.getSelectedIndex() == -1 ) { /* Assuming -1 if no explicit "--Pilih--" */ }


        if (txtAlamat.getText().trim().isEmpty()) { errorMessage.append("- Alamat Lengkap\n"); valid = false; }
        if (txtEmail.getText().trim().isEmpty()) { errorMessage.append("- Email\n"); valid = false; }
        // Basic email validation (optional)
        else if (!txtEmail.getText().trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errorMessage.append("- Format Email tidak valid\n"); valid = false;
        }
        if (txtNoHP.getText().trim().isEmpty()) { errorMessage.append("- Nomor HP\n"); valid = false; }
         // Basic phone number validation (optional, only digits, maybe length)
        else if (!txtNoHP.getText().trim().matches("\\d{10,13}")) { // Example: 10-13 digits
            errorMessage.append("- Nomor HP tidak valid (harus angka, 10-13 digit)\n"); valid = false;
        }

        if (cmbFakultas.getSelectedIndex() == 0) { errorMessage.append("- Fakultas\n"); valid = false; }
        if (cmbJurusan.getSelectedIndex() == 0 || cmbJurusan.getSelectedItem().equals("-- Pilih Fakultas Dahulu --")) {
            errorMessage.append("- Program Studi\n"); valid = false;
        }
        if (txtNamaOrtu.getText().trim().isEmpty()) { errorMessage.append("- Nama Orang Tua/Wali\n"); valid = false; }
        if (txtNoHPOrtu.getText().trim().isEmpty()) { errorMessage.append("- Nomor HP Orang Tua/Wali\n"); valid = false; }
        else if (!txtNoHPOrtu.getText().trim().matches("\\d{10,13}")) { // Example: 10-13 digits
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
            showSummary();
        }
    }

    private void showSummary() {
        String nama = txtNama.getText();
        String nim = txtNIM.getText();
        String jenisKelamin = cmbJenisKelamin.getSelectedItem().toString();
        String tempatLahir = txtTempatLahir.getText();
        String tanggalLahir = cmbTanggal.getSelectedItem() + " " +
                              cmbBulan.getSelectedItem() + " " +
                              cmbTahun.getSelectedItem();
        String ttl = tempatLahir + ", " + tanggalLahir;
        String alamat = txtAlamat.getText();
        String email = txtEmail.getText();
        String noHp = txtNoHP.getText();
        String fakultas = cmbFakultas.getSelectedItem().toString();
        String jurusan = cmbJurusan.getSelectedItem().toString();
        String kelas = rbRegular.isSelected() ? "Regular" : "Kelas Karyawan";
        String namaOrtu = txtNamaOrtu.getText();
        String noHpOrtu = txtNoHPOrtu.getText();

        // Pass 'this' (the FormDaftarUlang frame) so the summary window can be positioned relative to it.
        // However, SummaryWindow constructor currently uses setLocationRelativeTo(null).
        // If you want it relative to FormDaftarUlang, pass 'this' to SummaryWindow constructor and use it there.
        new SummaryWindow(nama, nim, jenisKelamin, ttl, alamat, email, noHp,
                          fakultas, jurusan, kelas, namaOrtu, noHpOrtu);
    }


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new FormDaftarUlang());
    }
}