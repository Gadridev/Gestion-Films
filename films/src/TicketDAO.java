import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketDAO {
    public void buyTicket(Ticket ticket){
        String sql = "INSERT INTO cinema.tickets (numero, prix, id_Seances,id_Spectateurs) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getNumero());
            stmt.setFloat(2, ticket.getPrix());
            stmt.setInt(3, ticket.getId_seances());
            stmt.setInt(4, ticket.getId_spectateurs());
            stmt.executeUpdate();
            System.out.println("Ticket added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
