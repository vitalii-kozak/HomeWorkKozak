package Films;

public class FilmsRunner {
    public static void main(String[] args) {
        Actor actor1 = new Actor("Sonny Landham");
        Actor actor2 = new Actor("Arnold Schwarzenegger");
        Actor actor3 = new Actor("Carl Weathers");
        Actor actor4 = new Actor("Bill Duke");

        Film film1 = new Film("Predator", 1987);
        film1.addActor(actor1);
        film1.addActor(actor2);
        film1.addActor(actor3);
        film1.addActor(actor4);
        film1.addGenre(Genre.ACTION);
        film1.addGenre(Genre.THRILLER);

        Film film2 = new Film("The pirates of caribbean sea", 2001);
        film2.addActor(new Actor("Johnny Depp"));
        film2.addGenre(Genre.COMEDY);
        film2.addGenre(Genre.ACTION);

        Film film3 = new Film("True lies", 1994);
        film3.addActor(actor2);
        film3.addGenre(Genre.COMEDY);
        film3.addGenre(Genre.ACTION);

        Films films = new Films();
        films.add(film1);
        films.add(film2);
        films.add(film3);

        System.out.println(films);
        System.out.println("***BY YEARS ****************************");
        System.out.println(films.findByYears(1986, 1995));
        System.out.println("***BY GENRE ****************************");
        System.out.println(films.findByGenre(Genre.COMEDY));
        System.out.println("***BY Actor ****************************");
        System.out.println(films.findByActor(actor2));


    }
}
