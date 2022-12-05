package bo.edu.ucb.sis213.macchine_sos.dto;

public class CreateUserDto {

    public String username;
    public String passwordd;
    public String named;
    public String lastnames;
    public String email;
    public String phone;
    public String dni;

    public CreateUserDto() {

    }

    public CreateUserDto(String username, String passwordd, String named, String lastnames, String email, String phone, String dni) {
        this.username = username;
        this.passwordd = passwordd;
        this.named = named;
        this.lastnames = lastnames;
        this.email = email;
        this.phone = phone;
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordd() {
        return passwordd;
    }

    public void setPasswordd(String passwordd) {
        this.passwordd = passwordd;
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
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
}
