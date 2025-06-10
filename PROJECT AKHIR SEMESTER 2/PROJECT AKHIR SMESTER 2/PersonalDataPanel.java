//PersonalDataPanel.java


import java.awt.*;
import javax.swing.*;

public class PersonalDataPanel extends JPanel {

    public PersonalDataPanel(JTextField txtNama, JTextField txtNIM, JComboBox<String> cmbJenisKelamin,
                             JTextField txtTempatLahir, JComboBox<Integer> cmbTanggal, JComboBox<String> cmbBulan,
                             JComboBox<Integer> cmbTahun, JTextArea txtAlamat, JTextField txtEmail, JTextField txtNoHP) {
        super(); 
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
        setBackground(UIConstants.BACKGROUND_COLOR); 

        // Nama Lengkap
        JPanel panelNama = PanelFactory.createFieldPanel("Nama Lengkap *");
        panelNama.add(txtNama);
        add(panelNama);

        // NIM
        JPanel panelNIM = PanelFactory.createFieldPanel("NIM *");
        panelNIM.add(txtNIM);
        add(panelNIM);

        // Jenis Kelamin
        JPanel panelJK = PanelFactory.createFieldPanel("Jenis Kelamin *");
        panelJK.add(cmbJenisKelamin);
        add(panelJK);

        // Tempat dan Tanggal Lahir
        JPanel panelTTL = PanelFactory.createFieldPanel("Tempat, Tgl. Lahir *");
        panelTTL.add(txtTempatLahir);
        panelTTL.add(new JLabel(", "));
        panelTTL.add(cmbTanggal);
        panelTTL.add(cmbBulan);
        panelTTL.add(cmbTahun);
        add(panelTTL);

        // Alamat - Use createTextAreaFieldPanel for better alignment
        JPanel panelAlamat = PanelFactory.createTextAreaFieldPanel("Alamat Lengkap *");
        txtAlamat.setLineWrap(true);
        txtAlamat.setWrapStyleWord(true);
        JScrollPane scrollAlamat = new JScrollPane(txtAlamat);
        scrollAlamat.setPreferredSize(new Dimension(200, 60));
        JPanel alamatContentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0,0));
        alamatContentPanel.setBackground(UIConstants.BACKGROUND_COLOR);
        alamatContentPanel.add(scrollAlamat);
        panelAlamat.add(alamatContentPanel); 
        add(panelAlamat);


        // Email
        JPanel panelEmail = PanelFactory.createFieldPanel("Email *");
        panelEmail.add(txtEmail);
        add(panelEmail);

        // No. HP
        JPanel panelNoHP = PanelFactory.createFieldPanel("Nomor HP *");
        panelNoHP.add(txtNoHP);
        add(panelNoHP);
    }
}