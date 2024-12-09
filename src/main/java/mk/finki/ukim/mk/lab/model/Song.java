package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackId;

    private String title;

    private String genre;

    private int releaseYear;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Artist> performers;

    @ManyToOne
    private Album album;

    public Song() {
    }

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Long id,Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.id = id;
        this.album = album;
    }

    public Song(String trackId, String title, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers=new ArrayList<Artist>();
        this.album=null;
    }

    public Song(String trackId, String title, String genre, int releaseYear,Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers=new ArrayList<Artist>();
        this.album=album;
    }

    public Artist addPerformer(Artist artist) {
        this.performers.add(artist);
        return artist;
    }

}
