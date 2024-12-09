package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist,Song song);
    Song findByTrackId(String trackId);
    List<Song> searchByStr(String name);
    Song searchById(Long id);
    void deleteSongByTrackId(String trackId);
    void deleteSongById(Long id);
    Song saveOrUpdateSong(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Long id,Album album);
}
