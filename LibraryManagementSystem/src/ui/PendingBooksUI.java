package ui;

import dao.IssueDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class PendingBooksUI extends JFrame {

    JTable table;

    public PendingBooksUI() {

        setTitle("Pending Books");
        setSize(600,300);

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("Issue ID");
        model.addColumn("Book ID");
        model.addColumn("Student");
        model.addColumn("Issue Date");

        try {
            IssueDAO dao = new IssueDAO();
            ResultSet rs = dao.getPendingBooks();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getString("student_name"),
                        rs.getDate("issue_date")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
}
