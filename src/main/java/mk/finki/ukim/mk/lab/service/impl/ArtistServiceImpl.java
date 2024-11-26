package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtist() {
        return this.artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return this.artistRepository.findById(id).orElse(null);
    }
}
