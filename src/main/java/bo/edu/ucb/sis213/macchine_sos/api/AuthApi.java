package bo.edu.ucb.sis213.macchine_sos.api;

import bo.edu.ucb.sis213.macchine_sos.bl.SecurityBl;
import bo.edu.ucb.sis213.macchine_sos.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthApi {

    private SecurityBl securityBl;

    public AuthApi(SecurityBl securityBl){
        this.securityBl = securityBl;
    }
    @GetMapping("/{userid}")
    public UserDto test (@PathVariable(name = "userid") Integer userid){
        return this.securityBl.getUserByPk(userid);
    }
}
