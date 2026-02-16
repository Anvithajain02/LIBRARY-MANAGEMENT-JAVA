package ui;

import dao.BookDAO;
import javax.swing.*;

public class DashboardUI extends JFrame {

    public DashboardUI() {

        setTitle("Library Management Dashboard");
        setSize(450,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Total Books Stat
        int totalBooks = new BookDAO().getTotalBooks();
        JLabel stats = new JLabel("Total Books: " + totalBooks);
        stats.setBounds(50,20,200,30);
        add(stats);

        // Add Book Button
        JButton addBookBtn = new JButton("Add Book");
        addBookBtn.setBounds(130,60,150,35);
        add(addBookBtn);

        // View Books Button
        JButton viewBookBtn = new JButton("View Books");
        viewBookBtn.setBounds(130,110,150,35);
        add(viewBookBtn);

        // Search Book Button
        JButton searchBookBtn = new JButton("Search Book");
        searchBookBtn.setBounds(130,160,150,35);
        add(searchBookBtn);

        // Issue Book Button
        JButton issueBookBtn = new JButton("Issue Book");
        issueBookBtn.setBounds(130,210,150,35);
        add(issueBookBtn);

        // Return Book Button
        JButton returnBookBtn = new JButton("Return Book");
        returnBookBtn.setBounds(130,260,150,35);
        add(returnBookBtn);

        // Button Actions
        addBookBtn.addActionListener(e -> new AddBookUI());
        viewBookBtn.addActionListener(e -> new ViewBooksUI());
        searchBookBtn.addActionListener(e -> new SearchBookUI());
        issueBookBtn.addActionListener(e -> new IssueBookUI());
        returnBookBtn.addActionListener(e -> new ReturnBookUI());

        JButton issuedBtn = new JButton("Issued Books");
        issuedBtn.setBounds(130,310,150,35);
        add(issuedBtn);

        JButton pendingBtn = new JButton("Pending Books");
        pendingBtn.setBounds(130,360,150,35);
        add(pendingBtn);

        issuedBtn.addActionListener(e -> new IssuebooksUI());
        pendingBtn.addActionListener(e -> new PendingBooksUI());


        setLocationRelativeTo(null);
        setVisible(true);
    }
}
