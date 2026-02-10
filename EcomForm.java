package in.ac.spit.ecom.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcomForm {

    public static void main(String[] args) {

        
        JFrame frame = new JFrame("E-Commerce Customer Form");
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        JLabel title = new JLabel("Customer Registration", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(title, BorderLayout.NORTH);

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        
        JLabel lblName = new JLabel("Customer Name:");
        JTextField txtName = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JLabel lblMobile = new JLabel("Mobile:");
        JTextField txtMobile = new JTextField();

        JLabel lblAddress = new JLabel("Address:");
        JTextArea txtAddress = new JTextArea(3, 20);
        JScrollPane scroll = new JScrollPane(txtAddress);

        JLabel lblGender = new JLabel("Gender:");
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton rbMale = new JRadioButton("Male");
        JRadioButton rbFemale = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);

        JButton btnSubmit = new JButton("Submit");

        
        panel.add(lblName);
        panel.add(txtName);

        panel.add(lblEmail);
        panel.add(txtEmail);

        panel.add(lblMobile);
        panel.add(txtMobile);

        panel.add(lblAddress);
        panel.add(scroll);

        panel.add(lblGender);
        panel.add(genderPanel);

        panel.add(new JLabel(""));
        panel.add(btnSubmit);

        frame.add(panel, BorderLayout.CENTER);

        
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = txtName.getText().trim();
                String email = txtEmail.getText().trim();
                String mobile = txtMobile.getText().trim();
                String address = txtAddress.getText().trim();

                
                if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "All fields are required!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid Email Format!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                
                if (!mobile.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(frame,
                            "Mobile number must be 10 digits!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                
                String gender = "";
                if (rbMale.isSelected()) {
                    gender = "Male";
                } else if (rbFemale.isSelected()) {
                    gender = "Female";
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Please select gender!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                
                JOptionPane.showMessageDialog(frame,
                        "Registered Successfully!\n\n" +
                                "Name: " + name +
                                "\nEmail: " + email +
                                "\nMobile: " + mobile +
                                "\nGender: " + gender +
                                "\nAddress: " + address);
            }
        });

        frame.setVisible(true);
    }
}
