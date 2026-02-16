package ui;

import dao.IssueDAO;

import javax.swing.*;

public class ReturnBookUI extends JFrame {

    private JTextField issueIdField;

    public ReturnBookUI() {

        setTitle("Return Book");
        setSize(300,220);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter Issue ID:");
        label.setBounds(30,40,120,25);
        add(label);

        issueIdField = new JTextField();
        issueIdField.setBounds(150,40,100,25);
        add(issueIdField);

        JButton returnBtn = new JButton("Return Book");
        returnBtn.setBounds(80,100,120,30);
        add(returnBtn);

        returnBtn.addActionListener(e -> returnBook());

        setVisible(true);
    }

    private void returnBook() {

        try {
            int issueId = Integer.parseInt(issueIdField.getText());

            IssueDAO dao = new IssueDAO();
            double fine = dao.returnBook(issueId);

            JOptionPane.showMessageDialog(this,
                    "Book returned successfully.\nFine: ₹" + fine);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid Issue ID");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error returning book");
        }
    }
}
