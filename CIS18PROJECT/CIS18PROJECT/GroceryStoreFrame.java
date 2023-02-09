package CIS18PROJECT;
import javax.swing.*;
import java.awt.*;

 public class GroceryStoreFrame extends JFrame {
    public void GroceryFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        JFrame frame = new JFrame("GroceryStore");
        JLabel titleLabel = new JLabel("GroceryStore");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(titleLabel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}