import java.awt.*;
import javax.swing.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(UIConstants.BACKGROUND_COLOR);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JLabel lblTitle = new JLabel("FORMULIR DAFTAR ULANG MAHASISWA BARU");
        lblTitle.setFont(UIConstants.APP_TITLE_FONT);
        lblTitle.setForeground(UIConstants.PRIMARY_COLOR);
        lblTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblSubtitle = new JLabel("Tahun Akademik 2025/2026");
        lblSubtitle.setFont(UIConstants.APP_SUBTITLE_FONT);
        lblSubtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JSeparator separator = new JSeparator();
        separator.setForeground(UIConstants.ACCENT_COLOR);
        separator.setAlignmentX(Component.LEFT_ALIGNMENT);
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));


        add(lblTitle);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(lblSubtitle);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(separator);
    }
}