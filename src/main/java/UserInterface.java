import java.util.ArrayList;
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
            System.out.print("Enter number:\n> ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> addMovie();
                case 2 -> showAllMovies();
//                case 3 -> searchMovies();
//                case 4 -> editMovie();
//                case 5 -> deleteMovie();
                case 0 -> isRunning = false;
                default -> System.out.println("Unknown choice" + choice);
            }
        }

    }
    private void addMovie(){
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Year cerated: ");
        int yearCreated = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Is movie in color (True or false): ");
        boolean isColor = scanner.nextBoolean();
        System.out.print("Length of movie in minutes: ");
        int lengthInMinutes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        controller.addMovie(title , director,yearCreated, isColor, lengthInMinutes, genre);
    }
    private void showAllMovies(){
        ArrayList<Movie> list = controller.getMovies();
        for(Movie movie : list){
            System.out.print(movie.toString());
        }

    }

}
