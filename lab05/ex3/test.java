import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Movie movie = new Movie.Builder("Homem-Aranha 2", 2004)
                .director(new Person("Sam Raimi", 63))
                .writer(new Person("Stan Lee", 95))
                .cast(Arrays.asList(
                        new Person("Tobey Maguire", 47),
                        new Person("Kirsten Dunst", 40)))
                .genres(Arrays.asList("Crime", "Drama"))
                .locations(Arrays.asList(
                        new Place("New York City"),
                        new Place("Sicily")))
                .languages(Arrays.asList("Ingles"))
                .isTelevision(false)
                .isNetflix(true)
                .isIndependent(false)
                .build();

        // Print out the movie's title, year, director, and cast
        System.out.println(movie);
    }

}
