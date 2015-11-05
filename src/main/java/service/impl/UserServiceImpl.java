package service.impl;

import form.UserRegistrationForm;
import model.User;
import model.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import service.UserService;
import util.UserRegistrationValidator;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public boolean saveNewUser(UserRegistrationForm form) {
        User user = null;
        if (form != null && UserRegistrationValidator.registrationDataCorrectness(form)) {
            user = new User();
            user.setUsername(form.getUsername());
            user.setRole(UserRole.ROLE_USER);
            user.setPassword(encoder.encode(form.getPassword()));
            user.setEmail(form.getEmail());
        }
        if (user != null) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean containsUser(String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public List<User> findAll() {


        return userRepository.findAll();
    }
}
