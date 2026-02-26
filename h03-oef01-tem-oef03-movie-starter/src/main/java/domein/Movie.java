package domein;

import java.util.Comparator;
import java.util.Objects;

public class Movie implements Comparable<Movie> {

    private double rating;
    private String name;
    private int year;

    public Movie(String name, double rating, int year) {
        setName(name);
        setRating(rating);
        setYear(year);
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%-25s %5.2f %8d", name, rating, year);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }

    @Override
    public int compareTo(Movie m) {
        return Comparator.comparing(Movie::getName)
                .thenComparingInt(Movie::getYear)
                .compare(this, m);
    }

    public static int compareRating(Movie m1, Movie m2) {
        return Comparator.comparingDouble(Movie::getRating)
                .reversed()
                .compare(m1, m2);
    }
}