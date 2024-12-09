package mk.finki.ukim.mk.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.jpa.SongRepository;
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
        if (artist == null || song == null) {
            throw new IllegalArgumentException("Artist or Song cannot be null.");
        }
        song.addPerformer(artist);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return this.songRepository.findSongByTrackId(trackId);
    }

    @Override
    public List<Song> searchByStr(String name) {
        return this.songRepository.findAllByTitleContainingIgnoreCase(name);
    }

    @Override
    public Song searchById(Long id){
        return this.songRepository.searchSongById(id);
    }

    @Override
    @Transactional
    public void deleteSongByTrackId(String trackId) {
        songRepository.removeSongByTrackId(trackId);
    }

    @Override
    @Transactional
    public void deleteSongById(Long id) {
        songRepository.removeSongById(id);
    }

    @Override
    @Transactional
    public Song saveOrUpdateSong(String trackId, String title, String genre, int releaseYear, List<Artist> performers,Long id, Album album) {
        //return this.songRepository.save(new Song(trackId,title,genre,releaseYear,performers,album));
        //return this.songRepository.updateAllByTrackIdAndTitleAndGenreAndReleaseYearAndPerformersAndAlbum(trackId,title,genre,releaseYear,performers,album);
        this.songRepository.removeSongByTrackId(trackId);
        return this.songRepository.save(new Song(trackId,title,genre,releaseYear,performers,id,album));
    }


}
