package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.repository.impl.InMemoryArtistRepository;
import mk.finki.ukim.mk.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final InMemoryArtistRepository inMemoryArtistRepository;

    public ArtistServiceImpl(InMemoryArtistRepository inMemoryArtistRepository) {
        this.inMemoryArtistRepository = inMemoryArtistRepository;
    }

    @Override
    public List<Artist> listArtist() {
        return this.inMemoryArtistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return this.inMemoryArtistRepository.findById(id).orElse(null);
    }
}
