import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Movie {

    private static final int  FIRST_MOVIE_YEAR = 1888;
    private static final int MINIMUM_LENGTH_IN_MINUTES = 1;
    private String title;
    private String director;
    private int yearCreated;
    private boolean inColor;
    private int lengthInMinutes;
    private String genre;
    private LocalDate lastWatched;



    public Movie(String title, String director, int yearCreated, boolean inColor,
                 int lengthInMinutes, String genre) {
        setTitle(title);
        setDirector(director);
        setYearCreated(yearCreated);
        this.inColor = inColor;
        setLengthInMinutes(lengthInMinutes);
        setGenre(genre);
        this.lastWatched = null;

    }
    public String getTitle(){
        return title;
    }
    public String getDirector(){
        return director;
    }

    public int getYearCreated() {
        return yearCreated;
    }
    public boolean isInColor() {
        return inColor;
    }
    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
    public String getGenre(){
        return genre;
    }
    public void setTitle(String title) {
       if(title.isBlank())
           throw new IllegalArgumentException("Title can't be blank");
        this.title = title;
    }
    public void setDirector(String director) {
        if(director.isBlank())
            throw new IllegalArgumentException("Director can't be blank");

        this.director = director;
    }
    public void setYearCreated(int yearCreated) {
        if(yearCreated < FIRST_MOVIE_YEAR){
            throw new IllegalArgumentException("You can't have that year!");
        } else if (yearCreated > LocalDate.now().getYear() +1) {
            throw new IllegalArgumentException("The movie hassent been relist yet");
        }
        this.yearCreated = yearCreated;
    }
    public void setInColor(boolean inColor) {
        this.inColor = inColor;
    }
    public void setLengthInMinutes(int lengthInMinutes) {
        if(lengthInMinutes < MINIMUM_LENGTH_IN_MINUTES){
            throw new IllegalArgumentException("The movie can't be shorter then 1 min ");
        }
        this.lengthInMinutes = lengthInMinutes;
    }
    public void setGenre(String genre) {
        if(genre.isBlank())
            throw new IllegalArgumentException("Genre can't be blank");
        this.genre = genre;
    }
    public String toString() {
        return getTitle() + " " + getDirector()+ " " + getYearCreated()+ "\n" + (isInColor() ? "Color" : "Black and white") + " " + getLengthInMinutes()+ " " + getGenre();
    }

    public LocalDate getLastWatched() {
        return lastWatched;
    }

    public boolean hasBeenWatched() {
        return lastWatched != null;
    }
    public void markAsWatched(LocalDate date) {
        lastWatched = date;
    }
    public long getDaysSinceWatched(LocalDate today) {
        return ChronoUnit.DAYS.between(lastWatched, today);
    }
}

