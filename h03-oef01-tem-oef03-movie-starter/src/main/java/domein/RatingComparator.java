package domein;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2) {
        return Comparator.comparingDouble(Movie::getRating).reversed().compare(m1, m2);
    }

}