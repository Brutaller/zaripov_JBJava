package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.UserFormValidator;

/**
 * Created by Azat Zaripov on 10.10.2015.
 */
@Controller
@RequestMapping(value = "/users")
public class UsersControler {

    @Autowired
    UserService userService;

    private UserFormValidator validator = new UserFormValidator();

    @RequestMapping(value = "/all")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @RequestMapping(value = "/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, BindingResult result) {
        validator.validate(user, result);
        if (result.hasErrors()){
            return "add-user";
        }else {
            userService.addUser(user);
            return "redirect:/users/all";
        }
    }
}
