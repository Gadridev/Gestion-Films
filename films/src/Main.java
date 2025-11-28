import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmDAO filmDAO = new FilmDAO();
        SeanceDAO seanceDAO = new SeanceDAO();
        SpectateurDAO spectateurDAO=new SpectateurDAO();
        TicketDAO ticketDAO=new TicketDAO();
        while (true) {
            System.out.println("\n===== MENU CINEMA =====");
            System.out.println("1. Ajouter un film");
            System.out.println("2. Lister les films");
            System.out.println("3. Ajouter une séance à un film");
            System.out.println("4. Lister les séances d’un film");
            System.out.println("5. Ajouter un spectateur");
            System.out.println("6. Lister les spectateurs");
            System.out.println("7. Acheter un ticket");
            System.out.println("8. Lister les tickets d’un spectateur");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int choix = sc.nextInt();
            sc.nextLine();
            try {
                switch (choix) {
                    case 1:
                        System.out.print("Titre du film : ");
                        String titre = sc.nextLine();

                        System.out.print("Durée (min) : ");
                        int duree = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Catégorie : ");
                        String categorie = sc.nextLine();

                        Film f = new Film(0, titre, duree, categorie);
                        filmDAO.insertFilms(f);
                        break;
                    case 2:
                        filmDAO.getAllFilms().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID du film : ");
                        int idFilm = sc.nextInt();
                        sc.nextLine();
                        // checking film exists:
                        Film film = filmDAO.getFilmById(idFilm);
                        if (film == null) {
                            System.out.println("Erreur : Ce film n'existe pas !");
                            break;
                        }
                        System.out.print("Horaire (ex: 120 pour 2h ou format souhaité) : ");
                        int horaire = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Salle : ");
                        int salle = sc.nextInt();

                        System.out.print("Capacité : ");
                        int capacite = sc.nextInt();
                        sc.nextLine();

                        Seance seance = new Seance(0, horaire, salle, capacite, idFilm);

                        seanceDAO.insertSeances(seance);

                        break;
                    case 4:
                        seanceDAO.getAllSeances().forEach(System.out::println);
                        break;
                    case 5:
                        System.out.print("Donnez moi  nom de spectateur: ");
                        String nom = sc.nextLine();
                        System.out.print("Donnez moi  email de spectateur: ");
                        String email = sc.nextLine();
                        Spectateur spectateur = new Spectateur(0, nom, email);
                        spectateurDAO.insertSpectateur(spectateur);
                        break;
                    case 6:
                        spectateurDAO.getAllSpectateur().forEach(System.out::println);
                        break;
                    case 7:
                        System.out.print("Nom du Spectateur : ");
                        String nomSpec = sc.next();
                        Spectateur spectateurs = spectateurDAO.getByName(nomSpec);
                        if (spectateurs == null) {
                            System.out.println("❌ Spectateur introuvable !");
                            return;
                        }
                        List<Seance> seances = seanceDAO.getAllSeances();

                        for (Seance s : seances) {
                            Film films = filmDAO.getFilmById(s.getIdFilm());
                            String titreFilm = (films != null) ? films.getTitre() : "Film introuvable";
                            System.out.println(
                                    "ID Séance: " + s.getIdSeance() +
                                            " | Film: " + titreFilm +
                                            " | Horaire: " + s.getHoraire() +
                                            " | Salle: " + s.getSalle()
                            );
                        }
                        System.out.print("Choisir ID de la séance : ");
                        int idSeance = sc.nextInt();
                        Seance seancess = seanceDAO.getById(idSeance);
                        if (seancess == null) {
                            System.out.println("❌ Séance introuvable !");
                            return;
                        }
                        if (seancess.getCapaciteMax() <= 0) {
                            System.out.println("❌ Plus de places disponibles !");
                            return;
                        }
                        System.out.println("donnez moi prix de ticket");
                        float prix = sc.nextFloat();
                        Ticket newTicket = new Ticket(
                                0,
                                prix,
                                spectateurs.getId_spectateurs(),
                                seancess.getIdSeance()
                        );
                        ticketDAO.buyTicket(newTicket);
                        break;
                    case 8:

                    case 0:
                        System.out.println("Au revoir !");
                        return;
                    default:
                        System.out.println("Choix invalide !");
                }
            }catch (InputMismatchException e){
                System.out.println("input Invalid");
                sc.next();
            }catch (IndexOutOfBoundsException e){
                System.out.println("this element doesn't exist");
            }
        }
    }
}
