package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    }
    public Song findByTrackId(String trackId){
        return DataHolder.songs.stream().filter(s -> s.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song){
        return DataHolder.songs.stream().filter(s -> s.equals(song)).findFirst().get().addPerformer(artist);
    }

    public List<Song> searchByStr(String name){
        return DataHolder.songs.stream().filter(c -> c.getTitle().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public Song searchById(Long id){
        return DataHolder.songs.stream().filter(s->s.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteByTrackId(String trackId){
        DataHolder.songs.removeIf(s -> s.getTrackId().equals(trackId));
    }

    public void deleteSongById(Long id){
        DataHolder.songs.removeIf(s-> s.getId().equals(id));
    }

    public Song saveOrUpdate(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Long id, Album album){
        DataHolder.songs.removeIf(s-> s.getTrackId().equals(trackId));
        Song s=new Song(trackId, title, genre, releaseYear, performers, id, album);
        DataHolder.songs.add(s);
        return s;
    }
}
