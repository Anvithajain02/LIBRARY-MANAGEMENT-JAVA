package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IssueDAO {

    // Issue Book
    public boolean issueBook(int bookId, String studentName) {

        String sql = "INSERT INTO issued_books(book_id, student_name, issue_date) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) {
                System.out.println("Database connection failed.");
                return false;
            }

            ps.setInt(1, bookId);
            ps.setString(2, studentName);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Return Book with Fine Calculation
    public double returnBook(int issueId) {

        double fine = 0;

        String selectSQL = "SELECT issue_date FROM issued_books WHERE id=?";
        String updateSQL = "UPDATE issued_books SET return_date=?, fine=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(selectSQL)) {

            if (con == null) {
                System.out.println("Database connection failed.");
                return 0;
            }

            ps.setInt(1, issueId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                    LocalDate today = LocalDate.now();

                    long days = ChronoUnit.DAYS.between(issueDate, today);

                    if (days > 7) {
                        fine = (days - 7) * 5;  // ₹5 per day
                    }

                    try (PreparedStatement ps2 = con.prepareStatement(updateSQL)) {

                        ps2.setDate(1, java.sql.Date.valueOf(today));
                        ps2.setDouble(2, fine);
                        ps2.setInt(3, issueId);

                        ps2.executeUpdate();
                    }

                } else {
                    System.out.println("Issue ID not found.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fine;
    }
    public ResultSet getAllIssuedBooks() {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM issued_books";
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getPendingBooks() {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM issued_books WHERE return_date IS NULL";
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
