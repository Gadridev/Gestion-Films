public class Spectateur {
    private  int id_spectateurs;
    private String nom;
    private String email;

    public Spectateur(int id_spectateurs, String nom, String email) {
        this.id_spectateurs = id_spectateurs;
        this.nom = nom;
        this.email = email;
    }

    public int getId_spectateurs() {
        return id_spectateurs;
    }

    public void setId_spectateurs(int id_spectateurs) {
        this.id_spectateurs = id_spectateurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Spectateur{" +
                "id_spectateurs=" + id_spectateurs +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
