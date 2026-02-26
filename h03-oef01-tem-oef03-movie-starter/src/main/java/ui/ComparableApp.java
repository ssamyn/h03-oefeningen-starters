package ui;

import domein.Movie;
import domein.RatingComparator;
import domein.YearComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableApp {

    public void startSortMovies() {
        List<Movie> allMovies = new ArrayList<Movie>();
        allMovies.add(new Movie("Force Awakens", 8.3, 2015));
        allMovies.add(new Movie("Force Awakens", 8.3, 2010));
        allMovies.add(new Movie("Force Awakens", 8.3, 2000));
        allMovies.add(new Movie("Star Wars", 8.7, 1977));
        allMovies.add(new Movie("Empire Strikes Back", 8.8, 1980));
        allMovies.add(new Movie("Return of the Jedi", 8.4, 1983));
        allMovies.add(new Movie("Return of the Jedi", 8.4, 1999));
        allMovies.add(new Movie("Return of the Jedi", 8.4, 2015));

        allMovies.sort(Comparator.naturalOrder());
        showMovies("Movies with natural ordering (name - year)", allMovies);
        allMovies.sort(new YearComparator());
        showMovies("Movies with total ordering based on year (seperate class for comparator)", allMovies);
        allMovies.sort(new RatingComparator());
        showMovies("Movies with total ordering based on descending rating (seperate class for comparator)", allMovies);

        // 		Oef 1, met anonieme inner class:
        Comparator<Movie> comparatorAnonymous = null;
        allMovies.sort(comparatorAnonymous);
        showMovies("Movies with total ordering based on descending rating (implemented with anonymous class)", allMovies);


        // 		Oef 2, met lambdas:
        Comparator<Movie> comparatorLambda = null;
        allMovies.sort(comparatorLambda);
        showMovies("Movies with total ordering based on descending rating (implemented with lambda)", allMovies);

        allMovies.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));
        showMovies("Movies with ordering based on name", allMovies);


        //		Oef 3, met methodereferenties:
        Comparator<Movie> comparatorMethodReference = null;
        allMovies.sort(comparatorMethodReference);
        showMovies("Movies with total ordering based on descending rating (implemented with method reference)", allMovies);

        allMovies.sort(null);
        showMovies("Movies with ordering based on name (implemented with method reference)", allMovies);

        allMovies.sort(null);
        showMovies("Movies with total ordering based on descending rating (implemented with method reference)", allMovies);
    }

    private void showMovies(String titel, List<Movie> allMovies) {
        System.out.printf("%s%n", titel);
        System.out.printf("%s%n", "=".repeat(titel.length()));
        for (Movie movie : allMovies) {
            System.out.println(movie);
        }
        System.out.println();
    }
}