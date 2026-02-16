package ui;

import dao.IssueDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class IssuebooksUI extends JFrame {

    JTable table;

    public IssuebooksUI() {

        setTitle("Issued Books");
        setSize(600,300);

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("Issue ID");
        model.addColumn("Book ID");
        model.addColumn("Student");
        model.addColumn("Issue Date");
        model.addColumn("Return Date");
        model.addColumn("Fine");

        try {
            IssueDAO dao = new IssueDAO();
            ResultSet rs = dao.getAllIssuedBooks();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getString("student_name"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date"),
                        rs.getDouble("fine")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
}
