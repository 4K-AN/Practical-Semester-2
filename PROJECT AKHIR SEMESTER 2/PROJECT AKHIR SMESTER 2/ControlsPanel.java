//ControlPanel.java

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControlsPanel extends JPanel {

    public ControlsPanel(JCheckBox cbPernyataan, JButton btnSubmit, JButton btnReset,
                         ActionListener submitListener, ActionListener resetListener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBackground(UIConstants.BACKGROUND_COLOR);

        // Panel Pernyataan
        JPanel panelPernyataan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPernyataan.setBackground(UIConstants.BACKGROUND_COLOR);
        panelPernyataan.setAlignmentX(Component.LEFT_ALIGNMENT);

        cbPernyataan.setFont(UIConstants.LABEL_FONT);
        cbPernyataan.setBackground(UIConstants.BACKGROUND_COLOR);
        panelPernyataan.add(cbPernyataan);

        // Panel Tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        buttonPanel.setBackground(UIConstants.BACKGROUND_COLOR);
        //buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // For FlowLayout, alignmentX has less effect
                                                            // Centering is handled by FlowLayout.CENTER


        btnSubmit.setFont(UIConstants.BUTTON_FONT);
        btnSubmit.setBackground(UIConstants.PRIMARY_COLOR);
        btnSubmit.setForeground(UIConstants.TEXT_COLOR_ON_PRIMARY);
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(submitListener);

        btnReset.setFont(UIConstants.BUTTON_FONT);
        btnReset.setBackground(UIConstants.BACKGROUND_COLOR); // Or a light gray
        btnReset.setForeground(UIConstants.PRIMARY_COLOR);
        btnReset.setBorder(BorderFactory.createLineBorder(UIConstants.PRIMARY_COLOR)); // Add a border
        btnReset.setFocusPainted(false);
        btnReset.addActionListener(resetListener);

        buttonPanel.add(btnReset);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(btnSubmit);

        add(panelPernyataan);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(buttonPanel);
    }
}