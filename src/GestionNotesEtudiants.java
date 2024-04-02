import java.util.HashMap;
import java.util.Map;

public class GestionNotesEtudiants {

    public static void main(String[] args) {
        // Création du HashMap pour stocker les notes des étudiants
        Map<String, Double> notesEtudiants = new HashMap<>();

        // Insérer des notes des étudiants
        notesEtudiants.put("Alice", 15.5);
        notesEtudiants.put("Bob", 18.0);
        notesEtudiants.put("Charlie", 16.75);

        // Afficher la liste des notes
        afficherListeNotes(notesEtudiants);

        // Augmenter la note d'un étudiant
        augmenterNoteEtudiant(notesEtudiants, "Bob", 1.5);
        afficherListeNotes(notesEtudiants);

        // Supprimer la note d'un étudiant
        supprimerNoteEtudiant(notesEtudiants, "Alice");
        afficherListeNotes(notesEtudiants);

        // Afficher la taille du map
        System.out.println("Taille du map : " + notesEtudiants.size());

        // Afficher la note moyenne, max et min
        afficherStatistiques(notesEtudiants);

        // Vérifier s'il y a une note égale à 20
        if (notesEtudiants.containsValue(20.0)) {
            System.out.println("Il y a une note égale à 20.");
        } else {
            System.out.println("Il n'y a pas de note égale à 20.");
        }
    }

    // Méthode pour afficher la liste des notes
    public static void afficherListeNotes(Map<String, Double> notesEtudiants) {
        System.out.println("Liste des notes : ");
        notesEtudiants.forEach((nom, note) -> System.out.println(nom + " : " + note));
    }

    // Méthode pour augmenter la note d'un étudiant
    public static void augmenterNoteEtudiant(Map<String, Double> notesEtudiants, String nomEtudiant, double augmentation) {
        if (notesEtudiants.containsKey(nomEtudiant)) {
            double noteActuelle = notesEtudiants.get(nomEtudiant);
            notesEtudiants.put(nomEtudiant, noteActuelle + augmentation);
        } else {
            System.out.println("L'étudiant " + nomEtudiant + " n'existe pas dans la liste des notes.");
        }
    }

    // Méthode pour supprimer la note d'un étudiant
    public static void supprimerNoteEtudiant(Map<String, Double> notesEtudiants, String nomEtudiant) {
        if (notesEtudiants.containsKey(nomEtudiant)) {
            notesEtudiants.remove(nomEtudiant);
        } else {
            System.out.println("L'étudiant " + nomEtudiant + " n'existe pas dans la liste des notes.");
        }
    }

    // Méthode pour afficher la note moyenne, max et min
    public static void afficherStatistiques(Map<String, Double> notesEtudiants) {
        double somme = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double note : notesEtudiants.values()) {
            somme += note;
            if (note < min) {
                min = note;
            }
            if (note > max) {
                max = note;
            }
        }

        double moyenne = somme / notesEtudiants.size();
        System.out.println("Note moyenne : " + moyenne);
        System.out.println("Note minimale : " + min);
        System.out.println("Note maximale : " + max);
    }
}

