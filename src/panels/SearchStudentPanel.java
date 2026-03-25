package panels;

import model.DataStore;
import model.Student;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> filterBox;

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

        searchPanel.add(new JLabel("Search:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);

        filterBox = new JComboBox<>(new String[]{"ID", "Name", "Course"});
        searchPanel.add(filterBox);

        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> performSearch());
        searchPanel.add(searchBtn);

        JButton clearBtn = new JButton("Clear Search");
        clearBtn.addActionListener(e -> {
            searchField.setText("");
            tableModel.setRowCount(0);
        });
        searchPanel.add(clearBtn);

        add(searchPanel, BorderLayout.NORTH);

        // Results table
        JPanel resultsWrapper = new JPanel(new BorderLayout());
        resultsWrapper.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JLabel resultsLabel = new JLabel("Results:");
        resultsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultsWrapper.add(resultsLabel, BorderLayout.NORTH);

        String[] columns = {"ID", "Name", "Age", "Course"};
        tableModel = new DefaultTableModel(columns, 0);
        resultTable = new JTable(tableModel);
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

        List<Student> allStudents = DataStore.getInstance().getAllStudents();
        List<Student> results = new ArrayList<>();

        String filter = (String) filterBox.getSelectedItem();

        for (Student s : allStudents) {
            switch (filter) {
                case "ID":
                    if (s.getId().toLowerCase().contains(query)) results.add(s);
                    break;
                case "Name":
                    if (s.getName().toLowerCase().contains(query)) results.add(s);
                    break;
                case "Course":
                    if (s.getCourse().toLowerCase().contains(query)) results.add(s);
                    break;
            }
        }

        tableModel.setRowCount(0); // Clear previous results

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No students found matching: \"" + searchField.getText().trim() + "\"",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Student s : results) {
                tableModel.addRow(new Object[]{s.getId(), s.getName(), s.getAge(), s.getCourse()});
            }
        }
    }
}
