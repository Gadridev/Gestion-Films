import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class FilmDAO {
    public void insertFilms(Film film){
        String sql = "INSERT INTO cinema.films (titre, duree, categorie) VALUES (?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, film.getTitre());
            stmt.setInt(2, film.getDuree());
            stmt.setString(3, film.getCategorie());
            stmt.executeUpdate();
            System.out.println("Film added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Film> getAllFilms(){
        List<Film> films=new ArrayList<>();
        String sql = "SELECT * FROM films";
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                films.add(new Film(
                        rs.getInt("id_film"),
                        rs.getString("titre"),
                        rs.getInt("duree"),
                        rs.getString("categorie")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
    //    public Film getFilmByIds(int id) {
//        for (Film f : films) {
//            if (f.getIdFilm() == id) return f;
//        }
//        return null;
//    }
    public Film getFilmById(int id) {
        String sql = "SELECT * FROM films WHERE id_film = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Film(
                        rs.getInt("id_film"),
                        rs.getString("titre"),
                        rs.getInt("duree"),
                        rs.getString("categorie")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // film not found
    }
}
