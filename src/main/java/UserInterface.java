import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserInterface {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();

    public void startProgram() {
        boolean isRunning = true;
        System.out.println("Welcome to the film archive");

        while (isRunning) {
            //Meny
            System.out.println("1. Create a movie\n" + "2. Show all movies\n" + "3. Search movies\n" + "4. Edit a movie\n" + "5. Delete a movie\n" + "6. Mark a film as watched\n" +"7. Find film, you haven't seen in a while\n"+ "0. Stop\n");
            int choice = readInt("Enter a number: ");
            switch (choice) {
                case 1 -> addMovie();
                case 2 -> showAllMovies();
                case 3 -> searchMovies();
                case 4 -> editMovies();
                case 5 -> deleteMovies();
                case 6 -> markAsWatched();
                case 7 -> getMoviesNotWatchedForDays();
                case 0 -> isRunning = false;
                default -> System.out.println("Unknown choice" + choice);
            }
        }

    }
    private int readInt (String prompt){
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            }catch (NumberFormatException a) {
                System.out.println("\"" + input + "\" is not a number.");
            }
        }
    }

    private void addMovie() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        int yearCreated = readInt("Year created: ");

        System.out.print("Is movie in color (Yes or No): ");
        String input = scanner.nextLine();
        while(!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No")){
            System.out.print("Invalid input, please write Yes or No: ");
            input = scanner.nextLine();
        }
        boolean isColor = input.equalsIgnoreCase("Yes");
        int lengthInMinutes = readInt("Length of movie in minutes: ");
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        controller.addMovie(title, director, yearCreated, isColor, lengthInMinutes, genre);

        String frame = "-".repeat(title.length()+20);
        System.out.println("\n" + frame);
        System.out.println(title +" added to collection");
        System.out.println(frame + "\n");
    }

    private void showAllMovies() {
        ArrayList<Movie> list = controller.getMovies();
        for (Movie movie : list) {
            System.out.print(movie.toString());
        }

    }

    private void searchMovies() {
        System.out.print("search for title: ");
        String searchText = scanner.nextLine();
        ArrayList<Movie> found = controller.searchMovies(searchText);
        if (found.isEmpty()) {
            System.out.println("Movie was not found");
        } else {
            for (Movie movie : found) {
                System.out.print("- " + movie);
            }
        }


    }
    private void editMovies(){
        System.out.println("Search for title: ");
        String searchText = scanner.nextLine();
        ArrayList<Movie> found = controller.searchMovies(searchText);
        if (found.isEmpty()) {
            System.out.println("Movie was not found");
        } else {
            for (Movie movie : found) {
                System.out.println(movie);
            }
        }

        for(int i= 0; i < found.size(); i++){
            System.out.println((i + 1) + ". " + found.get(i).getTitle());
        }
        int number = readInt("Enter a number");
        if (number < 1 || number > found.size()){
            System.out.println("Invalid choice");
            return;
        }
        Movie movie = found.get(number - 1);

        System.out.print("new Title: (currently " + movie.getTitle() + "): ");
        String title = scanner.nextLine();
        System.out.print("new Director: (currently " + movie.getDirector() + "): ");
        String director = scanner.nextLine();
        int yearCreated = readInt("new Year created: (currently " + movie.getYearCreated() + "): ");

        System.out.print("Is movie in color (Yes or No): (currently" + movie.isInColor() + "): ");
        String input = scanner.nextLine();
        while(!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No")){
            System.out.print("Invalid input, please write true or false: ");
            input = scanner.nextLine();
        }
        boolean isColor = input.equalsIgnoreCase("Yes");
        int lengthInMinutes = readInt("new Length of movie in minutes: (currently " + movie.getLengthInMinutes() + "): ");
        System.out.print("new Genre: currently " + movie.getGenre() + "): ");
        String genre = scanner.nextLine();

        boolean success = controller.editMovie(movie, title, director, yearCreated, isColor, lengthInMinutes, genre);

        if(success) {
            System.out.println("Movie information updated");
                System.out.print(movie);
        }else{
            System.out.println("Movie information could not be updated");
        }

    }
    private void deleteMovies() {
        System.out.println("search for title: ");
        String searchText = scanner.nextLine();
        ArrayList<Movie> found = controller.searchMovies(searchText);
        if (found.isEmpty()) {
            System.out.println("Movie was not found");
        } else {
            for (Movie movie : found) {
                System.out.println(movie);
            }
        }

        for (int i = 0; i < found.size(); i++) {
            System.out.println((i + 1) + ". " + found.get(i).getTitle());
        }
        int number = readInt("Enter a number");
        if (number < 1 || number > found.size()) {
            System.out.println("Invalid choice");
            return;
        }
        Movie movie = found.get(number - 1);

        System.out.println("You are about to delete " + movie.getTitle() + "\"" + "Are you sure? Decision is FINAL! \" " + "Yes/No");//Ændre til yes/no senere
        String answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No")) {
            System.out.print("Invalid input, please write Yes or No: ");
            answer = scanner.nextLine();
        }
            if (answer.equalsIgnoreCase("No")) {
                System.out.println("Delete cancelled.");
                return;
            }
            if (controller.deleteMovie(movie)) {
                System.out.println("Movie deleted.");
            } else {
                System.out.println("Could not delete the movie");
            }

        }
        private void markAsWatched () {
            System.out.println("search for title: ");
            String searchText = scanner.nextLine();
            ArrayList<Movie> found = controller.searchMovies(searchText);
            if (found.isEmpty()) {
                System.out.println("Movie was not found");
            } else {
                for (Movie movie : found) {
                    System.out.println(movie);
                }
            }

            for (int i = 0; i < found.size(); i++) {
                System.out.println((i + 1) + ". " + found.get(i).getTitle());
            }
            int number = readInt("Enter a number");

            if (number < 1 || number > found.size()) {
                System.out.println("Invalid choice");
                return;
            }
            Movie movie = found.get(number - 1);

            controller.markAsWatched(movie);
            System.out.println("\n" + movie + " has been marked as watched\n");

        }

        private void getMoviesNotWatchedForDays () {
            int days = readInt("How many days? ");
            ArrayList<Movie> result = controller.getMoviesNotWatchedForDays(days);

            if (result.isEmpty()) {
                System.out.println("Film not found");
            } else {
                for (Movie movie : result) {
                    System.out.println(movie);
                    if (movie.hasBeenWatched()) {
                        String date = movie.getLastWatched().format(dateFormat);
                        long daysSince = movie.getDaysSinceWatched(LocalDate.now());
                        System.out.println("Last seen: " + date + " ( " + daysSince + " days ago)");
                    } else {
                        System.out.println("Last seen: Never");
                    }
                    System.out.println();
                }
            }
        }
    }




