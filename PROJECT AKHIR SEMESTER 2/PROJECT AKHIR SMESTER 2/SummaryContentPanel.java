//SummaryContentPanel.java


import java.awt.*;
import javax.swing.*;

public class SummaryContentPanel extends JPanel {

    public SummaryContentPanel(String nama, String nim, String jenisKelamin, String ttl, String alamat,
                               String email, String noHp, String fakultas, String jurusan, String kelas,
                               String namaOrtu, String noHpOrtu) {
        setLayout(new GridLayout(0, 2, 10, 8)); 
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
        addDataRow("Alamat:", alamat); 
        addDataRow("Email:", email);
        addDataRow("Nomor HP:", noHp);

     

        // Data Akademik
        addDataRow("Fakultas:", fakultas);
        addDataRow("Program Studi:", jurusan);
        addDataRow("Kelas:", kelas);

      

        // Data Orang Tua
        addDataRow("Nama Orang Tua/Wali:", namaOrtu);
        addDataRow("Nomor HP Orang Tua/Wali:", noHpOrtu);
    }

    private void addDataRow(String label, String value) {
        JLabel lblName = new JLabel(label);
        lblName.setFont(UIConstants.SUMMARY_DATA_LABEL_FONT);
        add(lblName);

       
        JTextArea areaValue = new JTextArea(value);
        areaValue.setFont(UIConstants.SUMMARY_DATA_VALUE_FONT);
        areaValue.setEditable(false);
        areaValue.setLineWrap(true);
        areaValue.setWrapStyleWord(true);
        areaValue.setBackground(getBackground()); 
        areaValue.setOpaque(false); 
        add(areaValue);
    }
}