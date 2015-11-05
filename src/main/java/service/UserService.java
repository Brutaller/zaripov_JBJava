package service;

import form.UserRegistrationForm;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean saveNewUser(UserRegistrationForm form);

    List<User> findAll();

    boolean containsUser(String username);

}
