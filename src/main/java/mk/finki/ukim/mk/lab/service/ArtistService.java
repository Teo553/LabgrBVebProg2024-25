package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtist();
    Artist findById(String id);
}
