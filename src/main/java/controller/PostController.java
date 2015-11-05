package controller;

import model.Post;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.PostService;
import service.UserService;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @RequestMapping("profile/post/add")
    @ResponseStatus(HttpStatus.OK)
    public void addPost(@RequestParam("text") String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.savePost(user, text);
    }

    @RequestMapping(value = "friend/friend/post/add")
    @ResponseStatus(HttpStatus.OK)
    public void addPostOnOtherUserPage(Model model, String friend, String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.savePost(user, friend, text);
    }

    @RequestMapping("friend/friend/post/getAll")
    public String getAllPostsPage(Model model, String friend) {
        List<Post> posts = postService.getAll(friend);
        model.addAttribute("posts", posts);
        return "postsList";
    }

    @RequestMapping("profile/post/getAll")
    public String getAllPostsPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.getAll(user);
        User principal;
        try {
            principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            principal = null;
        }
        model.addAttribute("principal", principal);
        model.addAttribute("posts", posts);
        return "postsList";
    }

}
