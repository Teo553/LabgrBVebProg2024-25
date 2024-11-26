package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
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
}
