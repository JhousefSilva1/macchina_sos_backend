package bo.edu.ucb.sis213.macchine_sos.dto;

public class UserDto {

    private Integer user_id;
    private String username;
    //private String passwordd;
    private String named;
    private String lastnaames;
    private String email;
    private String phone;
    private String dni;


    public UserDto() {
    }

    public UserDto(Integer user_id, String username, String named, String lastnaames, String email, String phone, String dni) {
        this.user_id = user_id;
        this.username = username;
        //this.passwordd = passwordd;
        this.named = named;
        this.lastnaames = lastnaames;
        this.email = email;
        this.phone = phone;
        this.dni = dni;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named;
    }

    public String getLastnaames() {
        return lastnaames;
    }

    public void setLastnaames(String lastnaames) {
        this.lastnaames = lastnaames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", named='" + named + '\'' +
                ", lastnaames='" + lastnaames + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
