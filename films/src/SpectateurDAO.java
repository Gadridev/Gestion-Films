import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpectateurDAO {
    public void insertSpectateur(Spectateur spectateur){
        String sql = "INSERT INTO cinema.spectateurs (id_spectateurs, nom, email) VALUES (?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, spectateur.getId_spectateurs());
            stmt.setString(2, spectateur.getNom());
            stmt.setString(3, spectateur.getEmail());
            stmt.executeUpdate();
            System.out.println("Spectateur added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Spectateur> getAllSpectateur(){
        List<Spectateur> spectateurs=new ArrayList<>();
        String sql = "SELECT * FROM spectateurs";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                spectateurs.add(new Spectateur(
                        rs.getInt("id_spectateurs"),
                        rs.getString("nom"),
                        rs.getString("email")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spectateurs;
    }
    public Spectateur getByName(String name) {
        String sql = "SELECT * FROM spectateurs WHERE nom = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Spectateur(
                        rs.getInt("id_spectateurs"),
                        rs.getString("nom"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // film not found
    }
}
