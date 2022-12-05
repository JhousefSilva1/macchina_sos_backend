package bo.edu.ucb.sis213.macchine_sos.dto;

public class AuthResDto {
   private String token;
   private String RefreshToken;

    public AuthResDto() {

    }

    public AuthResDto(String token, String refreshToken) {
        this.token = token;
        RefreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }


}

