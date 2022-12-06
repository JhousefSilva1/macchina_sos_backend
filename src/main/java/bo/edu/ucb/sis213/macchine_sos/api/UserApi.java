package bo.edu.ucb.sis213.macchine_sos.api;


import bo.edu.ucb.sis213.macchine_sos.bl.SecurityBl;
import bo.edu.ucb.sis213.macchine_sos.bl.UserBl;
import bo.edu.ucb.sis213.macchine_sos.dto.CreateUserDto;
import bo.edu.ucb.sis213.macchine_sos.dto.UserDto;
import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaUser;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserApi {

    private UserBl userBl;
    private SecurityBl securityBl;

    public UserApi(UserBl userBl, SecurityBl securityBl){
        this.userBl = userBl;
        this.securityBl = securityBl;
    }
    @PostMapping
/*
    public Map createUser(@RequestBody  CreateUserDto createUserDto){

        userBl.CreateUser(createUserDto);
        return Map.of("message", "User created");

    }*/
    public Map createUser(@RequestHeader Map<String, String> headers, @RequestBody  CreateUserDto createUserDto){
        if(headers.get("Authorization") == null && headers.get("authorization")==null){
            userBl.CreateUser(createUserDto);
            return Map.of("message", "No se ha enviado el token de autorizacion");
        }
        //Se acostumbra que cuando se envua el token de autorizacion se envia en el siguiente formato
        // Autorization Bearer <token>
        String jwt="";
        if(headers.get("Authorization") != null) {
            jwt = headers.get("Authorization").split(" ")[1];
        }else{
            jwt = headers.get("authorization").split(" ")[1];
        }

        //String jwt = headers.get("Authorization").substring(7);
        //if(jwt ==null){
        //  jwt = headers.get("authorization").substring(7);
      //  }
        System.out.println("El token enviado es "+jwt);
       //MacchinaUser macchinaUser=this.securityBl.validateJwtToken(jwt);
        if(this.securityBl.tokenHashRole(jwt,"CREAR_USUARIO")){
            userBl.CreateUser(createUserDto);
            return Map.of("message", "User created");
        }
        else{
            //throw new RuntimeException("No tiene permisos para crear usuarios");
            return Map.of("message", "usted no  tiene permisos para crear usuarios");
        }


       // userBl.CreateUser(createUserDto);


    }

}

