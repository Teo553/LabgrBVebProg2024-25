package mk.finki.ukim.mk.lab.service;


import mk.finki.ukim.mk.lab.model.Comments;

import java.util.List;


public interface CommentsService {
    List<Comments> findAll();
    List<String> findCommentsForPerson(String id);
    String addCommentToSong(String comment,String id);
}
