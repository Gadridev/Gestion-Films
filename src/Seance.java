public class Seance {
    private int idSeance;
    private int horaire;
    private int salle;
    private int capaciteMax;
    private int idFilm;

    public Seance(int idSeance, int horaire, int salle, int capaciteMax, int idFilm) {
        this.idSeance = idSeance;
        this.horaire = horaire;
        this.salle = salle;
        this.capaciteMax = capaciteMax;
        this.idFilm = idFilm;
    }

    @Override public String toString() {
        return "Seance{" +"idSeance"+ idSeance + ", "+"horaire"+ horaire + ", "+"salle" + salle + ", capaciteMax=" + capaciteMax + ", filmId=" + idFilm + "}";
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public int getHoraire() {
        return horaire;
    }

    public void setHoraire(int horaire) {
        this.horaire = horaire;
    }

    public int getSalle() {
        return salle;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }
}
