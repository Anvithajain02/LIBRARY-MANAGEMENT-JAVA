package ui;

import dao.UserDAO;

import javax.swing.*;

public class LoginUI extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;

    public LoginUI() {

        setTitle("Library Login");
        setSize(300,250);
        setLayout(null);

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(30,40,80,25);
        add(l1);

        usernameField = new JTextField();
        usernameField.setBounds(120,40,120,25);
        add(usernameField);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(30,80,80,25);
        add(l2);

        passwordField = new JPasswordField();
        passwordField.setBounds(120,80,120,25);
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(90,130,100,30);
        add(loginBtn);

        loginBtn.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        UserDAO dao = new UserDAO();

        if (dao.login(username, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            new DashboardUI();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }
}

