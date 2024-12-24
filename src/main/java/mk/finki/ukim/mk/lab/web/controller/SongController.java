package mk.finki.ukim.mk.lab.web.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    public SongController(SongService songService, ArtistService artistService, AlbumService albumService) {
        this.songService = songService;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    private final SongService songService;
    private final ArtistService artistService;
    private final AlbumService albumService;

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String search, Model model) {
        if (search == null || search.isEmpty()) {
            model.addAttribute("songsList", songService.listSongs());
        } else {
            model.addAttribute("songsList", songService.searchByStr(search));
        }
        return "listSongs";
    }

    @GetMapping("/artists")
    public String getArtistsPage(@RequestParam(required = false) String trackId, Model model) {
        model.addAttribute("artistList", artistService.listArtist());
        model.addAttribute("trackId", trackId);
        return "artistsList";
    }

    @GetMapping("/{trackId}")
    public String getSongDetails(@PathVariable String trackId, HttpServletRequest request,Model model) {
        Song song = songService.findByTrackId(trackId);
        if(song==null){
            return "redirect:/songs?error=SongNotFound";
        }
        HttpSession session=request.getSession();
        Integer visitCount=(Integer)session.getAttribute("songVisitCount_"+trackId);
        if(visitCount==null){
            visitCount=0;
        }
        visitCount++;
        session.setAttribute("songVisitCount_"+trackId,visitCount);
        model.addAttribute("visitCount",visitCount);
        model.addAttribute("song", song);
        model.addAttribute("trackid",trackId);
        return "songDetails";
    }

    @GetMapping("/songDetails")
    public String getSongDetailsPage(@RequestParam String trackId, @RequestParam Long artistId, Model model) {
        Artist artist = artistService.findById(artistId);
        Song song = songService.findByTrackId(trackId);
        if (artist != null && song != null) {
            songService.addArtistToSong(artist, song);
        }
        return "redirect:/songs/" + trackId;
    }

    @GetMapping("/edit/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model) {
        if(this.songService.searchById(id)!=null){
            Song song=this.songService.searchById(id);
            List<Album> albums=this.albumService.findAll();
            model.addAttribute("song", song);
            model.addAttribute("albumsList",albums);
            return "add-song";
        }
        return "redirect:/songs?error=SongNotFound";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        this.songService.deleteSongById(id);
        return "redirect:/songs";
    }

    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        List<Album> albums=this.albumService.findAll();
        model.addAttribute("albumsList",albums);
        return "add-song";
    }

    @PostMapping("/add")
    public String addSong(@RequestParam String trackId, @RequestParam Long id, @RequestParam String title,
                          @RequestParam String genre, @RequestParam int releaseYear, @RequestParam Long albumId) {
        Song song;
        Album album=albumService.findById(albumId).orElse(null);
        if (this.songService.searchById(id) != null) {
            song = this.songService.searchById(id);
            this.songService.saveOrUpdateSong(trackId, title, genre, releaseYear, song.getPerformers(),id,album);
        } else {
            song = new Song(trackId, title, genre, releaseYear);
            this.songService.saveOrUpdateSong(trackId, title, genre, releaseYear, song.getPerformers(),id,album);
        }
        return "redirect:/songs";
    }



}
