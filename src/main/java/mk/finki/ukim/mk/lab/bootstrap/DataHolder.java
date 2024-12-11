package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.jpa.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.jpa.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataHolder {
    public static List<Artist> performers=new ArrayList<>();
    public static List<Song> songs=new ArrayList<>();
    public static List<Album> albums=new ArrayList<>();

    public final AlbumRepository albumRepository;
    public final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public DataHolder(AlbumRepository albumRepository, SongRepository songRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @PostConstruct
    public void init() {
        Artist ar1=new Artist("Andrej","Stojanovski","This visionary painter captures the fleeting beauty of urban life.");
        Artist ar2=new Artist("Saso","Sasovski","An experimental sculptor and installation artist.");
        Artist ar3=new Artist("Pavel","Pavlovski","A contemporary digital illustrator.");
        Artist ar4=new Artist("Marjan","Marjanovski","A performance and multimedia artist.");
        Artist ar5=new Artist("Markovski","Markovski","This minimalist photographer has a unique eye for capturing stark.");

        artistRepository.save(ar1);
        artistRepository.save(ar2);
        artistRepository.save(ar3);
        artistRepository.save(ar4);
        artistRepository.save(ar5);



        Album a1=new Album("Thriller", "Pop", "1982");
        Album a2=new Album("Back in Black", "Rock", "1980");
        Album a3=new Album("The Dark Side of the Moon", "Progressive Rock", "1973");
        Album a4=new Album("1989", "Pop", "2014");
        Album a5=new Album("Nevermind", "Grunge", "1991");

        albumRepository.save(a1);
        albumRepository.save(a2);
        albumRepository.save(a3);
        albumRepository.save(a4);
        albumRepository.save(a5);

//        Optional<Album> albumOptional=albumRepository.findAll().stream().findFirst();

        Song s1=new Song("T001", "Midnight Echo", "Jazz", 2019,a1);
        Song s2=new Song("T002", "Sunset Drive", "Synthwave", 2021,a2);
        Song s3=new Song("T003", "Dreamscape", "Electronic", 2020,a3);
        Song s4=new Song("T004", "Dream", "Electronic", 2020,a4);
        Song s5=new Song("T005", "Mountain Whispers", "Folk", 2025,a5);

        songRepository.save(s1);
        songRepository.save(s2);
        songRepository.save(s3);
        songRepository.save(s4);
        songRepository.save(s5);

    }
}
