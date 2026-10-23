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
            switch (choice) {
                case 1 -> addMovie();
                case 2 -> showAllMovies();
                case 3 -> searchMovies();
                case 4 -> editMovies();
                case 5 -> deleteMovies();
                case 0 -> isRunning = false;
                default -> System.out.println("Unknown choice" + choice);
            }
        }

    }

    private void addMovie() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Year cerated: ");
        int yearCreated = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Is movie in color (True or false): ");
        String input = scanner.nextLine();
        while(!input.equalsIgnoreCase("true") && !input.equalsIgnoreCase("false")){
            System.out.print("Invalid input, please write true or false: ");
            input = scanner.nextLine();
        }
        boolean isColor = input.equalsIgnoreCase("true");
        System.out.print("Length of movie in minutes: ");
        int lengthInMinutes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        controller.addMovie(title, director, yearCreated, isColor, lengthInMinutes, genre);
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

        for(int i= 0; i < found.size(); i++){
            System.out.println((i + 1) + ". " + found.get(i).getTitle());
        }
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > found.size()){
            System.out.println("Invalid choice");
            return;
        }
        Movie movie = found.get(number - 1);

        System.out.print("new Title: (currently " + movie.getTitle() + "): ");
        String title = scanner.nextLine();
        System.out.print("new Director: (currently " + movie.getDirector() + "): ");
        String director = scanner.nextLine();
        System.out.print("new Year created: (currently " + movie.getYearCreated() + "): ");
        int yearCreated = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Is movie in color (True or false): (currently" + movie.isInColor() + "): ");
        String input = scanner.nextLine();
        while(!input.equalsIgnoreCase("true") && !input.equalsIgnoreCase("false")){
            System.out.print("Invalid input, please write true or false: ");
            input = scanner.nextLine();
        }
        boolean isColor = input.equalsIgnoreCase("true");
        System.out.print("new Length of movie in minutes: (currently " + movie.getLengthInMinutes() + "): ");
        int lengthInMinutes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("new Genre: currently " + movie.getGenre() + "): ");
        String genre = scanner.nextLine();

        boolean success = controller.editMovie(movie, title, director, yearCreated, isColor, lengthInMinutes, genre);

        if(success) {
            System.out.println("Movie information updated");
        }else{
            System.out.println("Movie information could not be updated");
        }

    }
    private void deleteMovies(){
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

        for(int i= 0; i < found.size(); i++){
            System.out.println((i + 1) + ". " + found.get(i).getTitle());
        }
        System.out.println("Enter a number: ");
        int number = 0;
        boolean validInput = false;
        while (!validInput){
            try{
                number = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException a){
                System.out.println("Invalid input, please enter a number: ");
            }
        }
        scanner.nextLine();

        if (number < 1 || number > found.size()){
            System.out.println("Invalid choice");
            return;
        }
        Movie movie = found.get(number - 1);

        System.out.println("You are about to delete " + movie.getTitle() + "\"" +
                "Are you sure? Decision is FINAL! \" " +
                "Yes/No"); //Ændre til yes/no senere
        String answer = scanner.nextLine();
        if(!answer.equalsIgnoreCase("Yes")){
            System.out.println("Delete cancelled.");
            return;
        }
        if(controller.deleteMovie(movie)){
            System.out.println("Movie deleted.");
        }else{
            System.out.println("Could not delete the movie");
        }

    }





    }



