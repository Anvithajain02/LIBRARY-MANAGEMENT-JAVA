package ui;

import dao.BookDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class SearchBookUI extends JFrame {

    JTextField searchField;
    JTable table;

    public SearchBookUI() {

        setTitle("Search Book");
        setSize(500,300);
        setLayout(null);

        searchField = new JTextField();
        searchField.setBounds(50,20,200,30);
        add(searchField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(270,20,100,30);
        add(searchBtn);

        table = new JTable(new DefaultTableModel(
                new Object[]{"ID","Title","Author","Category","Quantity"},0));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20,70,450,170);
        add(sp);

        searchBtn.addActionListener(e -> searchBook());

        setVisible(true);
    }

    private void searchBook() {
        try {
            BookDAO dao = new BookDAO();
            ResultSet rs = dao.searchBook(searchField.getText());

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while(rs.next()){
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getInt("quantity")
                });
            }

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }


}

