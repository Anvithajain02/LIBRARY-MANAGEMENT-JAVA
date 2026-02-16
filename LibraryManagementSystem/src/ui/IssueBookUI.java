package ui;

import dao.IssueDAO;

import javax.swing.*;

public class IssueBookUI extends JFrame {

    JTextField bookIdField, studentField;

    public IssueBookUI(){

        setTitle("Issue Book");
        setSize(300,250);
        setLayout(null);

        JLabel l1 = new JLabel("Book ID:");
        l1.setBounds(20,30,80,25);
        add(l1);

        bookIdField = new JTextField();
        bookIdField.setBounds(120,30,120,25);
        add(bookIdField);

        JLabel l2 = new JLabel("Student:");
        l2.setBounds(20,70,80,25);
        add(l2);

        studentField = new JTextField();
        studentField.setBounds(120,70,120,25);
        add(studentField);

        JButton issueBtn = new JButton("Issue");
        issueBtn.setBounds(80,130,120,30);
        add(issueBtn);

        issueBtn.addActionListener(e -> issueBook());

        setVisible(true);
    }

    private void issueBook(){
        int bookId = Integer.parseInt(bookIdField.getText());
        String student = studentField.getText();

        new IssueDAO().issueBook(bookId, student);

        JOptionPane.showMessageDialog(this,"Book Issued");
    }
}

