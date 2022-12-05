package bo.edu.ucb.sis213.macchine_sos.api;


import bo.edu.ucb.sis213.macchine_sos.bl.UserBl;
import bo.edu.ucb.sis213.macchine_sos.dto.CreateUserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserApi {

    private UserBl userBl;

    public UserApi(UserBl userBl){
        this.userBl = userBl;
    }
    @PostMapping

    public Map createUser(@RequestBody  CreateUserDto createUserDto){

        userBl.CreateUser(createUserDto);
        return Map.of("message", "User created");

    }

}

