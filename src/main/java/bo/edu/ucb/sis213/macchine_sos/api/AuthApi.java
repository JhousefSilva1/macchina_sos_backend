package bo.edu.ucb.sis213.macchine_sos.api;

import bo.edu.ucb.sis213.macchine_sos.bl.SecurityBl;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthReqDto;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthResDto;
import bo.edu.ucb.sis213.macchine_sos.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public AuthResDto authentication(@RequestBody AuthReqDto authReqDto){

        return securityBl.authenticate(authReqDto);

    }
}
