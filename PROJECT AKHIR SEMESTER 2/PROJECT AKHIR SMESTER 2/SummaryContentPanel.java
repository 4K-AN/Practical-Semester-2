//SummaryContentPanel.java


import java.awt.*;
import javax.swing.*;

public class SummaryContentPanel extends JPanel {

    public SummaryContentPanel(String nama, String nim, String jenisKelamin, String ttl, String alamat,
                               String email, String noHp, String fakultas, String jurusan, String kelas,
                               String namaOrtu, String noHpOrtu) {
        setLayout(new GridLayout(0, 2, 10, 8)); // 0 rows means flexible, 2 columns, gaps
        setBackground(UIConstants.BACKGROUND_COLOR);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, UIConstants.BORDER_COLOR),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Data Pribadi
        addDataRow("Nama Lengkap:", nama);
        addDataRow("NIM:", nim);
        addDataRow("Jenis Kelamin:", jenisKelamin);
        addDataRow("Tempat, Tanggal Lahir:", ttl);
        addDataRow("Alamat:", alamat); // Alamat might be long, GridLayout handles it
        addDataRow("Email:", email);
        addDataRow("Nomor HP:", noHp);

        // Add a visual spacer if desired, or just continue
        // add(new JLabel(" ")); add(new JLabel(" ")); // Empty row for spacing

        // Data Akademik
        addDataRow("Fakultas:", fakultas);
        addDataRow("Program Studi:", jurusan);
        addDataRow("Kelas:", kelas);

        // add(new JLabel(" ")); add(new JLabel(" ")); // Empty row for spacing

        // Data Orang Tua
        addDataRow("Nama Orang Tua/Wali:", namaOrtu);
        addDataRow("Nomor HP Orang Tua/Wali:", noHpOrtu);
    }

    private void addDataRow(String label, String value) {
        JLabel lblName = new JLabel(label);
        lblName.setFont(UIConstants.SUMMARY_DATA_LABEL_FONT);
        add(lblName);

        // Use JTextArea for value to allow wrapping for long text like addresses
        JTextArea areaValue = new JTextArea(value);
        areaValue.setFont(UIConstants.SUMMARY_DATA_VALUE_FONT);
        areaValue.setEditable(false);
        areaValue.setLineWrap(true);
        areaValue.setWrapStyleWord(true);
        areaValue.setBackground(getBackground()); // Match panel background
        areaValue.setOpaque(false); // Make transparent if underlying panel has specific bg
        add(areaValue);
    }
}