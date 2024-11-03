package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Artist {
    private String id;
    private String firstName;
    private String lastName;
    private String bio;

    public Artist(String id, String firstName, String lastName, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }
}
