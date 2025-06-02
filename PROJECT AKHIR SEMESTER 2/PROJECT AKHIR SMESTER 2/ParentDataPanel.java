import javax.swing.*;

public class ParentDataPanel extends JPanel {

    public ParentDataPanel(JTextField txtNamaOrtu, JTextField txtNoHPOrtu) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(UIConstants.BACKGROUND_COLOR);

        // Nama Orang Tua
        JPanel panelNamaOrtu = PanelFactory.createFieldPanel("Nama Orang Tua/Wali *");
        panelNamaOrtu.add(txtNamaOrtu);
        add(panelNamaOrtu);

        // No. HP Orang Tua
        JPanel panelNoHPOrtu = PanelFactory.createFieldPanel("Nomor HP Ortu/Wali *");
        panelNoHPOrtu.add(txtNoHPOrtu);
        add(panelNoHPOrtu);
    }
}