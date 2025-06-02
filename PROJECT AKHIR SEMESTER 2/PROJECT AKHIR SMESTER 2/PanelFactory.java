import java.awt.*;
import javax.swing.*;

public class PanelFactory {

    /**
     * Creates a standard section panel with a title and separator.
     * @param title The title of the section.
     * @return A JPanel configured as a section panel.
     */
    public static JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(UIConstants.BACKGROUND_COLOR);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, UIConstants.BORDER_COLOR),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(UIConstants.SECTION_TITLE_FONT);
        lblTitle.setForeground(UIConstants.PRIMARY_COLOR);
        lblTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JSeparator separator = new JSeparator();
        separator.setForeground(UIConstants.ACCENT_COLOR);
        separator.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Limit separator width to prevent it from spanning the entire frame if parent alignment changes
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));


        panel.add(lblTitle);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(separator);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        return panel;
    }

    /**
     * Creates a field panel with a label and a placeholder for a component.
     * The component itself should be added to the returned panel by the caller.
     * @param labelText The text for the label.
     * @return A JPanel configured for a form field.
     */
    public static JPanel createFieldPanel(String labelText) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5)); // Reduced vertical gap
        panel.setBackground(UIConstants.BACKGROUND_COLOR);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Set a maximum height to prevent panels from growing too tall with text areas
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); // Adjust height as needed

        JLabel lblField = new JLabel(labelText);
        lblField.setFont(UIConstants.LABEL_FONT);
        lblField.setPreferredSize(new Dimension(150, 20)); // Label width, component height

        panel.add(lblField);
        return panel;
    }
     /**
     * Creates a field panel specifically for JTextArea to better align the label.
     * @param labelText The text for the label.
     * @return A JPanel configured for a form field with a JTextArea.
     */
    public static JPanel createTextAreaFieldPanel(String labelText) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Align label and text area horizontally
        panel.setBackground(UIConstants.BACKGROUND_COLOR);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100)); // Allow more height for text area

        JLabel lblField = new JLabel(labelText);
        lblField.setFont(UIConstants.LABEL_FONT);
        lblField.setPreferredSize(new Dimension(150, 20));
        lblField.setAlignmentY(Component.TOP_ALIGNMENT); // Align label to the top of the text area

        // Add some spacing between label and text area
        panel.add(lblField);
        panel.add(Box.createRigidArea(new Dimension(0,0))); // Horizontal spacing is managed by FlowLayout in createFieldPanel. For BoxLayout, you might need this.

        return panel;
    }
}