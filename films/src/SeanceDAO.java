import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceDAO {
    public void insertSeances(Seance seance){
        String sql = "INSERT INTO cinema.seances (id_film, horaire, salle,capacite) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seance.getIdFilm());
            stmt.setInt(2, seance.getHoraire());
            stmt.setInt(3, seance.getSalle());
            stmt.setInt(4, seance.getCapaciteMax());
            stmt.executeUpdate();
            System.out.println("Seance added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Seance> getAllSeances(){
        List<Seance> seances=new ArrayList<>();
        String sql = "SELECT * FROM seances";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                seances.add(new Seance(0,
                        rs.getInt("horaire"),
                        rs.getInt("salle"),
                        rs.getInt("capacite"),
                        rs.getInt("id_film")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }
    public Seance getById(int id_seances) {
        String sql = "SELECT * FROM seances WHERE id_seances = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_seances);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Seance(
                        rs.getInt("id_seances"),
                        rs.getInt("horaire"),
                        rs.getInt("salle"),
                        rs.getInt("capacite"),
                        rs.getInt("id_film")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
