package ui;

import dao.BookDAO;
import model.Book;

import javax.swing.*;

public class AddBookUI extends JFrame {

    JTextField titleField, authorField, categoryField, quantityField;

    public AddBookUI() {

        setTitle("Add Book");
        setSize(350,300);
        setLayout(null);

        JLabel l1 = new JLabel("Title:");
        l1.setBounds(30,30,100,25);
        add(l1);

        titleField = new JTextField();
        titleField.setBounds(130,30,150,25);
        add(titleField);

        JLabel l2 = new JLabel("Author:");
        l2.setBounds(30,70,100,25);
        add(l2);

        authorField = new JTextField();
        authorField.setBounds(130,70,150,25);
        add(authorField);

        JLabel l3 = new JLabel("Category:");
        l3.setBounds(30,110,100,25);
        add(l3);

        categoryField = new JTextField();
        categoryField.setBounds(130,110,150,25);
        add(categoryField);

        JLabel l4 = new JLabel("Quantity:");
        l4.setBounds(30,150,100,25);
        add(l4);

        quantityField = new JTextField();
        quantityField.setBounds(130,150,150,25);
        add(quantityField);

        JButton btn = new JButton("Save");
        btn.setBounds(110,200,100,30);
        add(btn);

        btn.addActionListener(e -> saveBook());

        setVisible(true);
    }

    private void saveBook() {

        String title = titleField.getText();
        String author = authorField.getText();
        String category = categoryField.getText();
        int quantity = Integer.parseInt(quantityField.getText());

        Book book = new Book(title, author, category, quantity);
        BookDAO dao = new BookDAO();
        dao.addBook(book);

        JOptionPane.showMessageDialog(this, "Book Added Successfully");
    }
}

