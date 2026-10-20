import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();

    public void startProgram() {
        boolean isRunning = true;
        System.out.println("Welcome to the film archive");

        while (isRunning) {
            //Meny
            System.out.println("1. Create a movie\n" + "2. Show all movies\n" + "3. Search movies\n" + "4. Edit a movie\n" + "5. Delete a movie\n" + "0. Strop");
            System.out.println("Enter number:\n>");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> addMovie();
                case 2 -> showAllMovies();
                case 3 -> searchMovies();
                case 4 -> editMovie();
                case 5 -> deleteMovie();
                case 0 -> isRunning = false;
                default -> System.out.println("Unknown choice" + choice);
            }

        }
    }
}
