package service.impl;

import model.Post;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repositories.PostRepository;
import repositories.UserRepository;
import service.PostService;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Transactional
@Service
public class PostServiceImpl implements PostService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Qualifier("postRepository")
    @Autowired
    private PostRepository postRepository;

    @Transactional
    @Override
    public void savePost(User user, String text) {
        Post post = new Post();
        User u = userRepository.findByUsername(user.getUsername());
        post.setUser(u);
        post.setUserPage(u);
        post.setText(text);
        post.setDate(new java.sql.Date((new java.util.Date()).getTime()));
        post.setTime(new java.sql.Time((new java.util.Date()).getTime()));
        postRepository.save(post);

    }

    @Override
    @Transactional
    public void savePost(User user, String friend, String text) {
        Post post = new Post();
        User userPage = userRepository.findByUsername(friend);
        User userAuthor = userRepository.findByUsername(user.getUsername());
        post.setUserPage(userPage);
        post.setUser(userAuthor);
        post.setText(text);
        post.setDate(new java.sql.Date((new java.util.Date()).getTime()));
        post.setTime(new java.sql.Time((new java.util.Date()).getTime()));
        postRepository.save(post);
    }

    @Override
    public List<Post> getAll(User user) {
        return postRepository.findByUserPage(user);
    }

    @Override
    public List<Post> getAll(String friend) {
        User userPage = userRepository.findOneByUsername(friend);
        return postRepository.findByUserPage(userPage);
    }
}
