package panels;

import model.DataStore;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Panel for searching students by ID or name.
 *
 * ASSIGNED TO: Student 5 (Search Feature Owner)
 * 
 * TODO for Student 5:
 * - Implement search by name (partial match / contains)
 * - Add search filter options (search by ID, by name, by course, etc.)
 * - Display results in a table or formatted list
 * - Handle case-insensitive search
 * - Show "No results found" message when appropriate
 * - Add a "Clear Search" button
 */
public class SearchStudentPanel extends JPanel {
  private JTextField searchField;
  private JTextArea resultArea;
  private JTable resultTable;
  private DefaultTableModel tableModel;


  public SearchStudentPanel() {
    setLayout(new BorderLayout());

    // Title
    JLabel title = new JLabel("Search Student", SwingConstants.CENTER);
    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
    add(title, BorderLayout.NORTH);

    // Search bar
    JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

    searchPanel.add(new JLabel("Search by ID, name,  course:"));
    searchField = new JTextField(20);
    searchPanel.add(searchField);

    JButton searchBtn = new JButton("Search");
    searchBtn.addActionListener(e -> performSearch());
    searchPanel.add(searchBtn);

    JButton clearBtn = new JButton("Clear Search");
    clearBtn.addActionListener(e -> {
      searchField.setText("");
//      resultArea.setText("");
      tableModel.setRowCount(0);
    });
    searchPanel.add(clearBtn);

    add(searchPanel, BorderLayout.NORTH);

    // Results area

    JPanel resultsWrapper = new JPanel(new BorderLayout());
    resultsWrapper.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

    JLabel resultsLabel = new JLabel("Results:");
    resultsLabel.setFont(new Font("Arial", Font.BOLD, 14));
    resultsWrapper.add(resultsLabel, BorderLayout.NORTH);


//    resultArea = new JTextArea();
//    resultArea.setEditable(false);
//    resultArea.setFont(new Font("Monospaced", Font.PLAIN,14));
//    JScrollPane scrollPane = new JScrollPane(resultArea);
//    resultsWrapper.add(scrollPane, BorderLayout.CENTER);
//
//    add(resultsWrapper, BorderLayout.CENTER);
    JLabel resultLabel = new JLabel("Results: ");
    resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
    resultsWrapper.add(resultLabel, BorderLayout.CENTER);

    String[] columnLabels = {"Student ID", "Name", "Age", "Email", "Course", "Year Level", "Contact Number"};
    tableModel = new DefaultTableModel(columnLabels, 0){
      @Override
      public boolean isCellEditable(int row, int col){
        return false;
      }
    };

    resultTable = new JTable(tableModel);
    resultTable.setFillsViewportHeight(true);
    JScrollPane scrollPane = new JScrollPane(resultTable);

    resultsWrapper.add(scrollPane, BorderLayout.CENTER);
    add(resultsWrapper, BorderLayout.CENTER);
  }

  private void performSearch() {
    String query = searchField.getText().trim().toLowerCase();

    if (query.isEmpty()) {
      JOptionPane.showMessageDialog(this,
          "Please enter a search term.", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    tableModel.setRowCount(0);

    List<Student> allStudents = DataStore.getInstance().getAllStudents();
    List<Student> results = new ArrayList<>();

    for (Student s : allStudents) {
      if (s.getId().toLowerCase().contains(query)
          || s.getName().toLowerCase().contains(query)
              || String.valueOf(s.getAge()).contains(query)
              || s.getEmail().toLowerCase().contains(query)
              || s.getCourse().toLowerCase().contains(query)
              || s.getYearLevel().toLowerCase().contains(query)
              || s.getContactNumber().toLowerCase().contains(query)) {
        results.add(s);
      }
    }

    if (results.isEmpty()) {
//      resultArea.setText("no results are found: \"" + searchField.getText().trim() + "\"");
      JOptionPane.showMessageDialog(this,"no results are found: \"" + searchField.getText().trim() + "\"" );
    } else {
//      StringBuilder sb = new StringBuilder();
//      sb.append(String.format("%-15s %-25s %-5s%n", "ID", "Name", "Age"));
//      sb.append("-".repeat(45)).append("\n");
//      for (Student s : results) {
//        sb.append(String.format("%-15s %-25s %-5d%n", s.getId(), s.getName(), s.getAge()));
//      }
//      sb.append("\nFound ").append(results.size()).append(" result(s).");
//      resultArea.setText(sb.toString());
      for (Student el : results){
        Object[] row = {
          el.getId(), el.getName(), el.getAge(), el.getEmail(), el.getCourse(), el.getYearLevel(), el.getContactNumber()
        };
        tableModel.addRow(row);
      }
    }
  }
}
