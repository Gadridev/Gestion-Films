public class Film {
    private int idFilm;
    private String titre;
    private int duree;
    private String categorie;

    public Film(int idFilm, String titre, int duree, String categorie) {
        this.idFilm = idFilm;
        this.titre = titre;
        this.duree = duree;
        this.categorie = categorie;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    // getters & setters omitted for brevity
    @Override public String toString() {
        return "Film{" + idFilm + ", " + titre + ", " + duree + "min, " + categorie + "}";
    }

    // ... getters and setters ...
}