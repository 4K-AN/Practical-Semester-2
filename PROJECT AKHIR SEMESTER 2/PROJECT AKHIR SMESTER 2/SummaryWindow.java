import java.awt.*;
import javax.swing.*;

public class SummaryWindow extends JFrame {

    public SummaryWindow(String nama, String nim, String jenisKelamin, String ttl, String alamat,
                         String email, String noHp, String fakultas, String jurusan, String kelas,
                         String namaOrtu, String noHpOrtu) {

        setTitle("Ringkasan Data Daftar Ulang");
        setSize(650, 600); // Adjusted size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center relative to the main form if passed, or screen

        JPanel mainSummaryPanel = new JPanel();
        mainSummaryPanel.setLayout(new BoxLayout(mainSummaryPanel, BoxLayout.Y_AXIS));
        mainSummaryPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainSummaryPanel.setBackground(UIConstants.BACKGROUND_COLOR);

        // Header
        JLabel headerLabel = new JLabel("RINGKASAN DATA DAFTAR ULANG");
        headerLabel.setFont(UIConstants.SUMMARY_HEADER_FONT);
        headerLabel.setForeground(UIConstants.PRIMARY_COLOR);
        headerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainSummaryPanel.add(headerLabel);
        mainSummaryPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Data content panel
        SummaryContentPanel dataPanel = new SummaryContentPanel(nama, nim, jenisKelamin, ttl, alamat, email,
                                                                noHp, fakultas, jurusan, kelas, namaOrtu, noHpOrtu);
        mainSummaryPanel.add(dataPanel);
        mainSummaryPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Success message panel
        JPanel successPanel = new JPanel();
        successPanel.setLayout(new BoxLayout(successPanel, BoxLayout.Y_AXIS));
        successPanel.setBackground(UIConstants.SUCCESS_MESSAGE_BG_COLOR);
        successPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, UIConstants.SUCCESS_MESSAGE_BORDER_COLOR),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        successPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        successPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100)); // Constrain height


        JLabel successLabel = new JLabel("✓ Pendaftaran Anda telah berhasil!");
        successLabel.setFont(UIConstants.SUCCESS_MESSAGE_FONT_BOLD);
        successLabel.setForeground(UIConstants.SUCCESS_MESSAGE_TEXT_COLOR);
        successLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel instructionLabel = new JLabel(
                "<html>Silakan cetak ringkasan ini dan bawa saat registrasi ulang <br>pada tanggal yang telah ditentukan.</html>");
        instructionLabel.setFont(UIConstants.SUCCESS_MESSAGE_FONT_PLAIN);
        instructionLabel.setForeground(UIConstants.SUCCESS_MESSAGE_TEXT_COLOR);
        instructionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        successPanel.add(successLabel);
        successPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        successPanel.add(instructionLabel);
        mainSummaryPanel.add(successPanel);
        mainSummaryPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Space after success message

        // Tombol Cetak
        JButton btnPrint = new JButton("Cetak");
        btnPrint.setFont(UIConstants.BUTTON_FONT);
        btnPrint.setBackground(UIConstants.PRIMARY_COLOR);
        btnPrint.setForeground(UIConstants.TEXT_COLOR_ON_PRIMARY);
        btnPrint.setFocusPainted(false);
        //btnPrint.setAlignmentX(Component.LEFT_ALIGNMENT); // Alignment for button in FlowLayout panel

        btnPrint.addActionListener(e ->
                JOptionPane.showMessageDialog(SummaryWindow.this,
                        "Fungsi cetak akan diimplementasikan di sistem nyata.",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE)
        );
        
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Align button to the right
        btnPanel.setBackground(UIConstants.BACKGROUND_COLOR);
        btnPanel.add(btnPrint);
        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align the panel itself to the left

        mainSummaryPanel.add(btnPanel);

        JScrollPane scrollPane = new JScrollPane(mainSummaryPanel);
        scrollPane.setBorder(null); // Remove scroll pane border
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        setVisible(true);
    }
}