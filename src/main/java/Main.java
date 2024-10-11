//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> lista_drame = new ArrayList<>();
        List<String> lista_comedii = new ArrayList<>();

        try {
            File file = new File("src/main/resurse/filme.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String film = scanner.nextLine().toLowerCase();

                switch (film.toLowerCase()) {
                    case "superbad":
                    case "hit man":
                    case "the fall guy":
                        lista_comedii.add(film);
                        break;
                    case "titanic":
                    case "gladiator":
                    case "taxi driver":
                        lista_drame.add(film);
                        break;
                    default:
                        System.out.println("Film nerecunoscut: " + film);
                        break;
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit.");
            e.printStackTrace();
        }

        System.out.println("Drama movies sorted:");
        lista_drame.stream()
                .filter(drama -> drama.length() > 3)
                .map(String::toUpperCase)
                .sorted(String::compareTo)
                .forEach(System.out::println);
        System.out.println("\n*********************\n");
        System.out.println("Comedy movies sorted:");
        lista_comedii.stream()
                .filter(comedie -> comedie.length() > 3)
                .map(String::toLowerCase)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
}
