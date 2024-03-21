import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class RegistrationForm2 extends JFrame {
    // In-memory storage to simulate database
    ArrayList<String[]> records = new ArrayList<>();
    
    // Swing components
    private JTextField idField, nameField, addressField, contactField;
    private JRadioButton maleButton, femaleButton;
    private JButton exitButton, registerButton;
    private JTable dataTable;
    private DefaultTableModel tableModel;
    
    public RegistrationForm2) {
        createUI();
    }
    
    private void createUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(780, 393);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // Initializing components
        idField = new JTextField(10);
        nameField = new JTextField(10);
        addressField = new JTextField(10);
        contactField = new JTextField(10);
        
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        registerButton = new JButton("Register");
        exitButton = new JButton("Exit");
        
        // Table Model
        String[] columnNames = {"ID", "Name", "Gender", "Address", "Contact"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dataTable = new JTable(tableModel);
        
        // Adding components to the frame
        add(new JLabel("ID"));
        add(idField);
        add(new JLabel("Name"));
        add(nameField);
        add(new JLabel("Gender"));
        add(maleButton);
        add(femaleButton);
        add(new JLabel("Address"));
        add(addressField);
        add(new JLabel("Contact"));
        add(contactField);
        
        add(exitButton);
        add(registerButton);
        
        // Scroll Pane for Table
        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setPreferredSize(new Dimension(500, 150));
        add(scrollPane);
        
        // Action listeners for buttons
        registerButton.addActionListener((ActionEvent e) -> {
            registerUser();
        });
        
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        pack(); // Adjusts size to fit all components
    }
    
    private void registerUser() {
        // Here you would add your database insertion code
        // For simulation purposes, we're adding it to the in-memory list
        String gender = maleButton.isSelected() ? "Male" : "Female";
        String[] record = {idField.getText(), nameField.getText(), gender, addressField.getText(), contactField.getText()};
        records.add(record);
        updateTable();
        
        // Clear fields
        idField.setText("");
        nameField.setText("");
        addressField.setText("");
        contactField.setText("");
        
    }
    
    private void updateTable() {
        // In an actual application, you would fetch this data from a database
        tableModel.setRowCount(0); // Clear existing data
        for (String[] record : records) {
            tableModel.addRow(record);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistrationForm().setVisible(true);
        });
    }
}

