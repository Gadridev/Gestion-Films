public class Ticket {
    private int numero;
    private float prix;
    private int id_spectateurs;
    private int id_seances;

    public Ticket(int numero, float prix, int id_spectateurs, int id_seances) {
        this.numero = numero;
        this.prix = prix;
        this.id_spectateurs = id_spectateurs;
        this.id_seances = id_seances;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_spectateurs() {
        return id_spectateurs;
    }

    public void setId_spectateurs(int id_spectateurs) {
        this.id_spectateurs = id_spectateurs;
    }

    public int getId_seances() {
        return id_seances;
    }

    public void setId_seances(int id_seances) {
        this.id_seances = id_seances;
    }
}

