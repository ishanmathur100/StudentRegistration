
import javax.swing.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    // Labels
    JLabel lblName, lblRoll, lblGender, lblBranch;

    // Text fields
    JTextField txtName, txtRoll, txtBranch;

    // Gender radio buttons
    JRadioButton male, female;
    ButtonGroup genderGroup;

    // Terms checkbox
    JCheckBox terms;

    // Buttons
    JButton submit, reset;

    // Constructor
    public StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(450, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Student Name
        lblName = new JLabel("Student Name");
        lblName.setBounds(30, 30, 120, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(170, 30, 180, 30);
        add(txtName);

        // Roll Number
        lblRoll = new JLabel("Roll Number");
        lblRoll.setBounds(30, 80, 120, 30);
        add(lblRoll);

        txtRoll = new JTextField();
        txtRoll.setBounds(170, 80, 180, 30);
        add(txtRoll);

        // Gender
        lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 130, 120, 30);
        add(lblGender);

        male = new JRadioButton("Male");
        male.setBounds(170, 130, 80, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(260, 130, 100, 30);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // Branch
        lblBranch = new JLabel("Branch");
        lblBranch.setBounds(30, 180, 120, 30);
        add(lblBranch);

        txtBranch = new JTextField();
        txtBranch.setBounds(170, 180, 180, 30);
        add(txtBranch);

        // Terms and Conditions
        terms = new JCheckBox("I accept Terms & Conditions");
        terms.setBounds(30, 230, 250, 30);
        add(terms);

        // Submit button
        submit = new JButton("Submit");
        submit.setBounds(80, 290, 100, 35);
        submit.addActionListener(this);
        add(submit);

        // Reset button
        reset = new JButton("Reset");
        reset.setBounds(220, 290, 100, 35);
        reset.addActionListener(this);
        add(reset);

        setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {

        // Reset form
        if (e.getSource() == reset) {
            txtName.setText("");
            txtRoll.setText("");
            txtBranch.setText("");
            genderGroup.clearSelection();
            terms.setSelected(false);
            return;
        }

        // Validate student name
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please enter Student Name");
            return;
        }

        // Validate roll number
        if (txtRoll.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please enter Roll Number");
            return;
        }

        // Validate gender
        if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(
                this, "Please select Gender");
            return;
        }

        // Validate branch
        if (txtBranch.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please enter Branch");
            return;
        }

        // Validate terms acceptance
        if (!terms.isSelected()) {
            JOptionPane.showMessageDialog(
                this, "Please accept Terms & Conditions");
            return;
        }

        // Get selected gender
        String gender = male.isSelected() ? "Male" : "Female";

        // Display registration details
        JOptionPane.showMessageDialog(
            this,
            "Registration Successful\n\n"
            + "Name : " + txtName.getText().trim()
            + "\nRoll Number : " + txtRoll.getText().trim()
            + "\nGender : " + gender
            + "\nBranch : " + txtBranch.getText().trim()
        );
    }

    // Main method
    public static void main(String[] args) {
        new StudentRegistration();
    }
}
