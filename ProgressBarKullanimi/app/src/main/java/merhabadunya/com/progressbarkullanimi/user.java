package merhabadunya.com.progressbarkullanimi;

/**
 * Created by omera on 12.03.2018.
 */

public class user {

    private String title, genre, year;



    public user(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
