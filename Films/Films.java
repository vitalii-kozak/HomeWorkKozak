package Films;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Films {

    private final ArrayList<Film> films = new ArrayList<>();

    public void add(Film film) {
        films.add(film);
    }

    public Films findByYears(int year1, int year2) {
        Films results = new Films();
        for (Film film : films) {
            if ((film.getYear() >= year1) && (film.getYear() <= year2)) {
                results.add(film);
            }
        }
        return results;
    }

    public Films findByGenre(Genre genre) {
        Films results = new Films();
        for (Film film : films) {
            if (film.isGenreExist(genre))  {
                results.add(film);
            }
        }
        return results;
    }

    public Films findByActor(Actor actor) {
        Films results = new Films();
        for (Film film : films) {
            if (film.isActorExist(actor))  {
                results.add(film);
            }
        }
        return results;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Film film : films) {
            joiner.add(film.toString());
        }
        return "Films:\n" + joiner.toString();
    }
}
