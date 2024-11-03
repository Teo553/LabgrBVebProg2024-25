package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist,Song song);
    public Song findByTrackId(String trackId);
}
