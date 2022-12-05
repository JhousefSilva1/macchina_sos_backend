package bo.edu.ucb.sis213.macchine_sos.entity;



import java.util.Date;
import java.util.Objects;

//usamos la entidad macchina_user de la base de datos
public class MacchinaUser {

    private Integer userId;
    private String username;
    private String passwordd;
    private String named;
    private String lastnames;
    private String email;
    private String phone;
    private String dni;
    private boolean status;
    private String tx_user;
    private String tx_host;
    private Date tx_date;

    public MacchinaUser() {
    }

    public MacchinaUser(Integer userId, String username, String passwordd, String named, String lastnames, String email, String phone, String dni, boolean status, String tx_user, String tx_host, Date tx_date) {
        this.userId = userId;
        this.username = username;
        this.passwordd = passwordd;
        this.named = named;
        this.lastnames = lastnames;
        this.email = email;
        this.phone = phone;
        this.dni = dni;
        this.status = status;
        this.tx_user = tx_user;
        this.tx_host = tx_host;
        this.tx_date = tx_date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTx_user() {
        return tx_user;
    }

    public void setTx_user(String tx_user) {
        this.tx_user = tx_user;
    }

    public String getTx_host() {
        return tx_host;
    }

    public void setTx_host(String tx_host) {
        this.tx_host = tx_host;
    }

    public Date getTx_date() {
        return tx_date;
    }

    public void setTx_date(Date tx_date) {
        this.tx_date = tx_date;
    }

    @Override
    public String toString() {
        return "MacchinaUser{" +
                "user_id=" + userId +
                ", username='" + username + '\'' +
                ", passwordd='" + passwordd + '\'' +
                ", named='" + named + '\'' +
                ", lastnaames='" + lastnames + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dni='" + dni + '\'' +
                ", status=" + status +
                ", tx_user='" + tx_user + '\'' +
                ", tx_host='" + tx_host + '\'' +
                ", tx_date=" + tx_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass() != o.getClass()) return false;
        MacchinaUser macUser = (MacchinaUser) o;
        return Objects.equals(userId, macUser.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
