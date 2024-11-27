package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return this.songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return this.songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return this.songRepository.findByTrackId(trackId);
    }

    @Override
    public List<Song> searchByStr(String name) {
        return this.songRepository.searchByStr(name);
    }

    @Override
    public Song searchById(Long id){
        return this.songRepository.searchById(id);
    }

    @Override
    public void deleteSongByTrackId(String trackId) {
        songRepository.deleteByTrackId(trackId);
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteSongById(id);
    }

    @Override
    public Song saveOrUpdateSong(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Long id, Album album) {
        return this.songRepository.saveOrUpdate(trackId,title,genre,releaseYear,performers,id,album);
    }


}
