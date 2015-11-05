package service;

import model.Post;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void savePost(User user, String text);

    void savePost(User user, String friend, String text);

    List<Post> getAll(User user);

    List<Post> getAll(String friend);

}
