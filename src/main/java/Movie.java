public class Movie {

    private String title;
    private String director;
    private int yearCreated;
    private boolean inColor;
    private int lengthInMinutes;
    private String genre;

    public Movie(String title, String director, int yearCreated, boolean inColor,
                 int lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.inColor = inColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
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
        this.title = title;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }
    public void setInColor(boolean inColor) {
        this.inColor = inColor;
    }
    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String toString() {
        return getTitle() + "\n" + getDirector()+ "\n" + getYearCreated()+ "\n" + isInColor()+ "\n" + getLengthInMinutes()+ "\n" + getGenre();
    }
}

