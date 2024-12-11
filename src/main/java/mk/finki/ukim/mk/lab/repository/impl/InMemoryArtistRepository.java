//package mk.finki.ukim.mk.lab.repository.impl;
//
//import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab.model.Artist;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class InMemoryArtistRepository {
//
//    public List<Artist> findAll() {
//        return DataHolder.performers;
//    }
//
//    public Optional<Artist> findById(Long id){
//        return DataHolder.performers.stream().filter(artist -> artist.getId().equals(id)).findFirst();
//    }
//
//
//
//
//
//
//}
