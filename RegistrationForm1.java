import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class RegistrationForm1 extends JFrame {
    private final JTextField nameTextField;
    private final JTextField mobileTextField;
    private final JRadioButton maleRadioButton;
    private final JRadioButton femaleRadioButton;
    private final JComboBox<String> dayComboBox;
    private final JComboBox<String> monthComboBox;
    private final JComboBox<String> yearComboBox;
    private final JTextArea addressTextArea;
    private final JCheckBox termsCheckBox;
    private final JButton submitButton;
    private final JButton resetButton;

    public RegistrationForm1() {
        setTitle("Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        
        // North Panel
        JPanel northPanel = new JPanel(new GridLayout(0, 2));
        add(northPanel, BorderLayout.NORTH);
        
        northPanel.add(new JLabel("Name"));
        nameTextField = new JTextField();
        northPanel.add(nameTextField);

        northPanel.add(new JLabel("Mobile"));
        mobileTextField = new JTextField();
        northPanel.add(mobileTextField);

        northPanel.add(new JLabel("Gender"));
        JPanel genderPanel = new JPanel(new FlowLayout());
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        northPanel.add(genderPanel);

        northPanel.add(new JLabel("DOB"));
        JPanel dobPanel = new JPanel(new FlowLayout());
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = Integer.toString(i);
        }
        dayComboBox = new JComboBox<>(days);
        monthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        yearComboBox = new JComboBox<>(new String[]{"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"});
        dobPanel.add(dayComboBox);
        dobPanel.add(monthComboBox);
        dobPanel.add(yearComboBox);
        northPanel.add(dobPanel);

        northPanel.add(new JLabel("Address"));
        addressTextArea = new JTextArea(2, 20);
        northPanel.add(addressTextArea);

        termsCheckBox = new JCheckBox("Accept Terms And Conditions.");
        northPanel.add(termsCheckBox);
        
        // South Panel
        JPanel southPanel = new JPanel(new FlowLayout());
        add(southPanel, BorderLayout.SOUTH);
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener((ActionEvent e) -> {
            // Code to handle submit action
        });
        southPanel.add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener((ActionEvent e) -> {
            // Code to handle reset action
        });
        southPanel.add(resetButton);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RegistrationForm1 frame = new RegistrationForm1();
            frame.setVisible(true);
        });
    }
}
