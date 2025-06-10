//AcademicDataPanel.java

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AcademicDataPanel extends JPanel {

    public AcademicDataPanel(JComboBox<String> cmbFakultas, JComboBox<String> cmbJurusan,
                             JRadioButton rbRegular, JRadioButton rbKelasKaryawan, ActionListener fakultasListener) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(UIConstants.BACKGROUND_COLOR);

        // Fakultas
        JPanel panelFakultas = PanelFactory.createFieldPanel("Fakultas *");
        cmbFakultas.addActionListener(fakultasListener); 
        panelFakultas.add(cmbFakultas);
        add(panelFakultas);

        // Jurusan
        JPanel panelJurusan = PanelFactory.createFieldPanel("Program Studi *");
        panelJurusan.add(cmbJurusan);
        add(panelJurusan);

        // Kelas
        JPanel panelKelas = PanelFactory.createFieldPanel("Kelas *");
        ButtonGroup bgKelas = new ButtonGroup();
        bgKelas.add(rbRegular);
        bgKelas.add(rbKelasKaryawan);

        rbRegular.setBackground(UIConstants.BACKGROUND_COLOR);
        rbKelasKaryawan.setBackground(UIConstants.BACKGROUND_COLOR);
        rbRegular.setFont(UIConstants.LABEL_FONT);
        rbKelasKaryawan.setFont(UIConstants.LABEL_FONT);


        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        radioPanel.setBackground(UIConstants.BACKGROUND_COLOR);
        radioPanel.add(rbRegular);
        radioPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        radioPanel.add(rbKelasKaryawan);

        panelKelas.add(radioPanel);
        add(panelKelas);
    }
}