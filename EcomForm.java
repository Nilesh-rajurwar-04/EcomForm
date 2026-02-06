import javax.swing.*;

public class EcomForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("E-Commerce Customer Form");

        frame.setSize(500, 600);
        frame.setLayout(null);  // absolute positioning
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lblName = new JLabel("Customer Name:");
        lblName.setBounds(30, 30, 150, 25);
        frame.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(180, 30, 200, 25);
        frame.add(txtName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 70, 150, 25);
        frame.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(180, 70, 200, 25);
        frame.add(txtEmail);

        JLabel lblMobile = new JLabel("Mobile:");
        lblMobile.setBounds(30, 110, 150, 25);
        frame.add(lblMobile);

        JTextField txtMobile = new JTextField();
        txtMobile.setBounds(180, 110, 200, 25);
        frame.add(txtMobile);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, 150, 150, 25);
        frame.add(lblAddress);

        JTextArea txtAddress = new JTextArea();
        txtAddress.setBounds(180, 150, 200, 60);
        frame.add(txtAddress);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, 230, 150, 25);
        frame.add(lblGender);

        JRadioButton rbMale = new JRadioButton("Male");
        rbMale.setBounds(180, 230, 70, 25);

        JRadioButton rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(260, 230, 80, 25);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        frame.add(rbMale);
        frame.add(rbFemale);
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(100, 420, 100, 30);
        frame.add(btnSubmit);
        btnSubmit.addActionListener(e -> {

        String name = txtName.getText();
        String email = txtEmail.getText();
        String mobile = txtMobile.getText();
        String address = txtAddress.getText();

        String gender = rbMale.isSelected() ? "Male" : "Female";

   

        JOptionPane.showMessageDialog(frame,
            "Registered Successfully!\n\n" +
            "Name: " + name +
            "\nEmail: " + email +
            "\nMobile: " + mobile +
            "\nGender: " + gender +
            "\nAddress: " + address
        
        );
});




        frame.setVisible(true);
    }
}
