package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository <Song, Long> {
    Song findSongByTrackId(String trackId);

    List<Song> findAllByTitleLike(String title);

    void removeSongByTrackId(String trackId);

    void removeSongById(Long songId);

    Song searchSongById(Long id);

    List<Song> findAllByTitleContainingIgnoreCase(String title);

    List<Song> findAllByAlbum_Id(Long albumId);
}
