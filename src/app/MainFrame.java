package app;

import panels.AddStudentPanel;
import panels.ViewStudentsPanel;
import panels.SearchStudentPanel;
import panels.EditStudentPanel;
import panels.DashboardPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Main application frame. Assembles all panels into a tabbed layout.
 * 
 * ASSIGNED TO: Student 2 (Main Frame / App Shell Owner)
 * 
 * TODO for Student 2:
 * - Customize the look and feel (colors, fonts, window size)
 * - Add a menu bar if desired (File > Exit, Help > About)
 * - Add an application icon
 * - Improve the overall layout and styling
 */
public class MainFrame extends JFrame {

  public MainFrame() {
    setTitle("Student Management System");
    ImageIcon icon= new ImageIcon(getClass().getResource("/images/icon.png"));
    setIconImage(icon.getImage());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1000, 600);
    setMinimumSize(new Dimension(800, 500));


    setLocationRelativeTo(null); // Center on screen

    Color green = Color.decode("#0640B");
    Color white = Color.decode("#FFFFFF");

    getContentPane().setBackground(white);

    //Menu
    JMenuBar menuBar= new JMenuBar();
    menuBar.setBackground(white);

    JMenu fileMenu = new JMenu("File");
    JMenuItem exitItem= new JMenuItem("Exit");
    exitItem.addActionListener(e -> System.exit(0));

    fileMenu.add(exitItem);

    JMenu helpMenu= new JMenu("Help");
    JMenuItem aboutItem = new JMenuItem("About");
    aboutItem.addActionListener(e ->JOptionPane.showMessageDialog(this, "Student Management SYstem rsakrr") );

    helpMenu.add(aboutItem);
    menuBar.add(fileMenu);
    menuBar.add(helpMenu);

    setJMenuBar(menuBar);


    // --- Tabbed Pane: each tab is owned by a different student ---
    JTabbedPane tabbedPane = new JTabbedPane();

    tabbedPane.addTab("Dashboard", new DashboardPanel());
    tabbedPane.addTab("Add Student", new AddStudentPanel());
    tabbedPane.addTab("View Students", new ViewStudentsPanel());
    tabbedPane.addTab("Search Student", new SearchStudentPanel());
    tabbedPane.addTab("Edit / Delete", new EditStudentPanel());




    add(tabbedPane, BorderLayout.CENTER);

  }

  public static void main(String[] args) {
    // Use the system look-and-feel for a native appearance
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ignored) {
    }

    SwingUtilities.invokeLater(() -> {
      MainFrame frame = new MainFrame();
      frame.setVisible(true);
    });
  }
}
