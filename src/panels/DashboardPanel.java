package panels;

import model.DataStore;

import javax.swing.*;
import java.awt.*;

/**
 * Dashboard panel showing summary/statistics.
 * 
 * ASSIGNED TO: Student 2 (Main Frame / Dashboard Owner)
 * 
 * TODO for Student 2:
 * - Display total number of students
 * - Add a welcome message or app logo
 * - Show summary statistics (e.g., average age, total count)
 * - Add a refresh button to update the stats
 * - Make it visually appealing (use colors, larger fonts, icons)
 */
public class DashboardPanel extends JPanel {
  private JLabel countLabel;

  public DashboardPanel() {
    setLayout(new BorderLayout());



    // Title
    JLabel title = new JLabel("Dashboard", SwingConstants.CENTER);
    title.setForeground(Color.blue);
    title.setFont(new Font("Arial", Font.BOLD, 28));
    title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    add(title, BorderLayout.NORTH);



    // Center content
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 20, 40));

    JLabel welcomeLabel = new JLabel("WELCOME TO STUDENT MANAGEMENT SYSTEM");
    welcomeLabel.setForeground(Color.black);
    welcomeLabel.setFont(new Font("Arial", Font.ITALIC, 20));
    welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    centerPanel.add(welcomeLabel);



    countLabel = new JLabel("Total Students: " + DataStore.getInstance().getCount());
    countLabel.setFont(new Font("Arial", Font.PLAIN, 18));
    countLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    centerPanel.add(countLabel);

    centerPanel.add(Box.createVerticalStrut(20));

    JButton refreshBtn = new JButton("Refresh");
    refreshBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    refreshBtn.addActionListener(e -> refreshData());
    centerPanel.add(refreshBtn);

    add(centerPanel, BorderLayout.CENTER);
  }

  private void refreshData() {
    countLabel.setText("Total Students: " + DataStore.getInstance().getCount());
  }
}
