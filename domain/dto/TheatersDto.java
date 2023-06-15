package domain.dto;

public class TheatersDto {
    private int theaters;
    private String name;
    private String location;
    private int capacity;
    private int movie_seq;

    public TheatersDto(int theaters, String name, String location, int capacity, int movie_seq) {
        this.theaters = theaters;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.movie_seq = movie_seq;
    }

    public TheatersDto() {

    }

    public int getTheaters() {
        return theaters;
    }

    public void setTheaters(int theaters) {
        this.theaters = theaters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMovie_seq() {
        return movie_seq;
    }

    public void setMovie_seq(int movie_seq) {
        this.movie_seq = movie_seq;
    }
}
