package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Comments;
import mk.finki.ukim.mk.lab.repository.jpa.CommentsRepository;
import mk.finki.ukim.mk.lab.service.CommentsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsServiceImpl implements CommentsService {
    private final CommentsRepository commentsRepository;

    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public List<String> findCommentsForPerson(String id) {
        List<Comments> all=commentsRepository.findAll();
        List<Comments> onlySong=all.stream().filter(c-> c.getSong_id().equals(id)).collect(Collectors.toList());
        List<String> comments = new ArrayList<>();
        for(int i=0;i<onlySong.size();i++){
            comments.add(onlySong.get(i).getComment());
        }
        return comments;
    }

    @Override
    public String addCommentToSong(String comment, String id) {
        commentsRepository.save(new Comments(id,comment));
        return comment;
    }

}
