package ui;

import db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewBooksUI extends JFrame {

    JTable table;

    public ViewBooksUI() {

        setTitle("Books List");
        setSize(500,300);

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Category");
        model.addColumn("Quantity");

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getInt("quantity")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
}

