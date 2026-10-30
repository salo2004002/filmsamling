import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private static final String HEADER = "title;director;yearCreated;inColor;lengthInMinutes;genre;lastWatched";
    private String filmName;
    private int skippedLineCount;

    public FileHandler(String filmName){
        this.filmName = filmName;
    }
    public int getSkippedLineCount(){
        return skippedLineCount;
    }
    public void saveMovies(ArrayList<Movie> movies) throws FileNotFoundException{
        PrintStream output = new PrintStream(new File(filmName));
        output.println(HEADER);
        for(Movie movie: movies){
            output.println(toCsvLine(movie));
        }
        output.close();
    }
    private String toCsvLine(Movie movie){
        String lastWatched = "";
        if(movie.hasBeenWatched()){
            lastWatched = movie.getLastWatched().toString();
        }
        return movie.getTitle() + ";"
                + movie.getDirector() + ";"
                + movie.getYearCreated() + ";"
                + movie.isInColor() + ";"
                + movie.getLengthInMinutes() + ";"
                + movie.getGenre() +  ";"
                + lastWatched;
    }
    public ArrayList<Movie> loadMovies() throws FileNotFoundException{
        ArrayList<Movie> movies = new ArrayList<>();
        Scanner fillScanner = new Scanner(new File(filmName));
        skippedLineCount = 0;
        if(fillScanner.hasNextLine()){
            fillScanner.nextLine();
        }
        while (fillScanner.hasNextLine()){
            String line = fillScanner.nextLine();
            Movie movie = parseMovie(line);
            if(movie == null){
                skippedLineCount++;
            }else {
                movies.add(movie);
            }
        }
        fillScanner.close();
        return movies;
    }

    private Movie parseMovie(String line){
        String[] fields = line.split(";", -1);
        if(fields.length !=7){
            return null;
        }
        try {
            String title = fields[0];
            String director = fields[1];
            int yearCreated = Integer.parseInt(fields[2]);
            boolean inColor = Boolean.parseBoolean(fields[3]);
            int lengthInMinutes = Integer.parseInt(fields[4]);
            String genre = fields[5];
            Movie movie = new Movie(title,director,yearCreated,inColor,lengthInMinutes,genre);
            if(!fields[6].isEmpty()){
                movie.markAsWatched(LocalDate.parse(fields[6]));
            }
            return movie;
        }catch (IllegalArgumentException a){
            return null;
        }catch (DateTimeException a){
            return null;
        }
    }

}
