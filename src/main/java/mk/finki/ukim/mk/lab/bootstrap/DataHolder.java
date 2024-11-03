package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> performers=new ArrayList<>();
    public static List<Song> songs=new ArrayList<>();

    @PostConstruct
    public void init() {
        performers.add(new Artist("123", "Bobi","Galic","This visionary painter captures the fleeting beauty of urban life, blending realism and abstract forms to explore the hidden emotions in everyday scenes. Their work is known for its rich color palettes and intense contrasts, often focusing on themes of solitude and resilience."));
        performers.add(new Artist("124", "Saso","Sasovski","An experimental sculptor and installation artist, this creator is fascinated by nature's intricate forms and the ways they intersect with modern technology. Using recycled and organic materials, they craft immersive experiences that challenge perceptions of space and time."));
        performers.add(new Artist("125", "Pavel","Pavlovski","A contemporary digital illustrator, this artist brings mythical worlds to life through vivid, intricate designs that blend ancient folklore with modern fantasy. Their art often features surreal landscapes, dynamic characters, and a seamless integration of light and shadow, inviting viewers into mysterious realms."));
        performers.add(new Artist("126L", "Marjan","Marjanovski","A performance and multimedia artist, this individual is known for boundary-pushing works that explore identity, memory, and human connection. Their shows combine visual art, spoken word, and dance, creating immersive experiences that provoke self-reflection and social commentary"));
        performers.add(new Artist("127L", "Markovski","Markovski","This minimalist photographer has a unique eye for capturing stark, powerful moments within ordinary spaces. Known for their black-and-white images, they focus on light, shadow, and negative space to evoke emotion through simplicity, often exploring themes of isolation and intimacy."));

        songs.add(new Song("T001", "Midnight Echo", "Jazz", 2019));
        songs.add(new Song("T002", "Sunset Drive", "Synthwave", 2021));
        songs.add(new Song("T003", "Dreamscape", "Electronic", 2020));
        songs.add(new Song("T004", "Dream", "Electronic", 2020));
        songs.add(new Song("T005", "Mountain Whispers", "Folk", 2025));
    }
}
