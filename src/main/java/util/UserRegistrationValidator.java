package util;

import form.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import repositories.UserRepository;

public class UserRegistrationValidator implements Validator {

    @Autowired
    UserRepository userRepository;

    public static boolean registrationDataCorrectness(UserRegistrationForm form) {
        return (form.getEmail().matches(".+@.+") && form.getUsername() != "" &&
                form.getPassword() != "" && form.getPassword().equals(form.getRepassword()));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistrationForm form = (UserRegistrationForm) o;

        boolean bool1 = false;
        boolean bool2 = false;

        try {
            userRepository.findOneByUsername(form.getUsername());
        } catch (NullPointerException e) {
            bool1 = true;
        }
        try {
            userRepository.findOneByEmail(form.getEmail());
        } catch (NullPointerException e) {
            bool2 = true;
        }

        if (bool1) {
            errors.rejectValue("login", "такое имя уже существует");
        }
        if (bool2) {
            errors.rejectValue("email", "пользователь с таким e-mail уже существует");
        }
        if (!form.getEmail().matches(".+@.+")) {
            errors.rejectValue("email", "невалидный e-mail");
        }
        if (form.getPassword() != form.getRepassword()) {
            errors.rejectValue("repassword", "пароли не совпадают");
        }
        if (form.getPassword().length() < 6 && form.getPassword().length() > 32) {
            errors.rejectValue("password", "длина пароля должна быть от 6 до 32 символов");
        }
    }
}
