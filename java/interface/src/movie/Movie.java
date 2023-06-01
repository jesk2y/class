package movie;

public class Movie implements Comparable<Movie>{
    String name;
    int count;

    public Movie(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }


    @Override
    public int compareTo(Movie o) {
        return o.count - this.count;
    }
}
