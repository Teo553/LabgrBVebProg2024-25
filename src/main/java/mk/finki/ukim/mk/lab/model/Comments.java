package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String song_id;
    private String comment;


    public Comments(String song_id, String comment) {
        this.song_id = song_id;
        this.comment = comment;
    }

    public Comments() {

    }
}
