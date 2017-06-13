package Films;

import java.util.ArrayList;

public class Film {

    private String filmName;
    private int year;
    private final ArrayList<Actor> actors = new ArrayList<>();
    private final ArrayList<Genre> genres = new ArrayList<>();


    public Film(String filmName, int year) {
        this.filmName = filmName;
        this.year = year;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public boolean isGenreExist(Genre genre) {
        return genres.contains(genre);
    }

    public boolean isActorExist(Actor actor) {
        return actors.contains(actor);
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public String getFilmName() {
        return filmName;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", year=" + year +
                ", actors=" + actors +
                ", genres=" + genres +
                '}';
    }
}

enum Genre { COMEDY, DRAMA, ACTION, THRILLER };
