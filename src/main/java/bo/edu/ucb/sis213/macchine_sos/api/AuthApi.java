package bo.edu.ucb.sis213.macchine_sos.api;

import bo.edu.ucb.sis213.macchine_sos.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthApi {
    @GetMapping()
    public UserDto test (){
        return new UserDto(1,"JhousefSilva","Jhousef","Silva","jhousef_silva@gmail.com","65578478","45641654");
    }
}
