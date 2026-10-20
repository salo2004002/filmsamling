import java.util.Scanner;

public class UserInterface {

    public void startProgram() {


        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();


        boolean isRunning = true;
        System.out.println("Welcome to the film archive");
        System.out.println("1. Opret en film\n" +
                "2. Vis alle film\n" +
                "3. Søg efter film\n" +
                "4. Redigér en film\n" +
                "5. Slet en film\n" +
                "0. Afslut");
    }
}
