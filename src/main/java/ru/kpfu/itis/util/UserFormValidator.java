package ru.kpfu.itis.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Azat Zaripov on 10.10.2015.
 */
public class UserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if ((user.getName1() == null || user.getName1().isEmpty())) {
            errors.rejectValue("name1", "", "Поле \"Имя\" обязательно для заполнения");
        }
        if ((user.getName2() == null || user.getName2().isEmpty())) {
            errors.rejectValue("name2", "", "Поле \"Фамилия\" обязательно для заполнения");
        }
        if ((user.getName3() == null || user.getName3().isEmpty())) {
            errors.rejectValue("name3", "", "Поле \"Отчество\" обязательно для заполнения");
        }
    }
}
