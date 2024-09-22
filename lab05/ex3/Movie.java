import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder{
        private final String title;
        private final int year;
        private Person director = new Person("", 0);
        private Person writer= new Person("", 0);
        private String series = "";
        private List<Person> cast = new ArrayList<Person>();
        private List<Place> locations = new ArrayList<Place>();
        private List<String> languages = new ArrayList<String>();
        private List<String> genres = new ArrayList<String>();
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;
    
        public Builder(String title, int year){
            this.title = title;
            this.year = year;
        }

        public Builder director(Person val){
            this.director = val;
            return this;
        }

        public Builder writer(Person val){
            this.writer = val;
            return this;
        }
        
        public Builder series(String val){
            this.series = val;
            return this;
        }

        public Builder cast(List<Person> val){
            this.cast = val;
            return this;
        }

        public Builder locations(List<Place> val){
            this.locations = val;
            return this;
        }

        public Builder languages(List<String> val){
            this.languages = val;
            return this;
        }

        public Builder genres(List<String> val){
            this.genres = val;
            return this;
        }

        public Builder isTelevision(boolean val){
            this.isTelevision = val;
            return this;
        }

        public Builder isNetflix(boolean val){
            this.isNetflix = val;
            return this;
        }

        public Builder isIndependent(boolean val){
            this.isIndependent = val;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    private Movie(Builder builder){
        title = builder.title;
        year = builder.year;
        director = builder.director;
        writer = builder.writer;
        series = builder.series;
        cast = builder.cast;
        locations = builder.locations;
        languages = builder.languages;
        genres = builder.genres;
        isTelevision = builder.isTelevision;
        isNetflix = builder.isNetflix;
        isIndependent = builder.isIndependent;
    }

    public String toString() {
        String result = "Titulo: " + this.title + "\n" + "Ano: " + this.year + "\n" + "Diretor: " + this.director + "\n"
                      + "Escritor: " + this.writer + "\n"+ "Series: " + this.series + "\n"+ "Elenco: " + this.cast + "\n"
                      + "Localidades: " + this.locations + "\n"+ "Linguagens: " + this.languages + "\n"+ "Generos: " + this.genres + "\n"
                      + "Televisao?: " + this.isTelevision + "\n"+ "Netflix?: " + this.isNetflix + "\n"+ "Independente?: " + this.isIndependent + "\n";
        return result;
    }
    
}
