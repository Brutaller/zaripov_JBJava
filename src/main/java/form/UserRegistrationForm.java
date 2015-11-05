package form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserRegistrationForm {

    @NotEmpty(message = "Логин не может быть пустым")
    private String username;

    @Size(min = 6, max = 30,message = "Пароль должен быть от 6 до 30 символов")
    private String password;

    private String repassword;

    private String city;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
