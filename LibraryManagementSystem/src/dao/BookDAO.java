package dao;

import db.DBConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookDAO {

    // Add Book
    public void addBook(Book book) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO books(title,author,category,quantity) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setInt(4, book.getQuantity());

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Book
    public ResultSet searchBook(String title) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM books WHERE title LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete Book
    public void deleteBook(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dashboard Stats
    public int getTotalBooks() {
        int count = 0;

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM books");

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
