package library.system.dao;
import library.system.connection.MakeConection;
import library.system.model.Book;
import java.sql.*;


public class BookDAO extends BaseDAO {
    public boolean existentISBN(String isbn) {
        return exists("books", "isbn", isbn);
    }

    public void registerBook(Book book) {
        String sql = "INSERT INTO books (title, author, isbn, publication_year) VALUES (?, ?, ?, ?)";

        try (Connection conn = MakeConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getIsbn());
            stmt.setInt(4, book.getPublicationYear());

            stmt.executeUpdate();
            System.out.println("Book registered with success!");

        } catch (SQLException e) {
            throw new RuntimeException("Error saving book: " + e.getMessage());
        }
    }
}