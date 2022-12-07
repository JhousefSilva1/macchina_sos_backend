package bo.edu.ucb.sis213.macchine_sos.api;

import bo.edu.ucb.sis213.macchine_sos.bl.SecurityBl;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthReqDto;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthResDto;
import bo.edu.ucb.sis213.macchine_sos.dto.ResponseDto;
import bo.edu.ucb.sis213.macchine_sos.dto.UserDto;
import bo.edu.ucb.sis213.macchine_sos.util.MacchinaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public UserDto test (@PathVariable(name = "userId") Integer userid){
        return this.securityBl.getUserByPk(userid);
    }

    //hacerlo por simplicidad
    @PostMapping()
    public ResponseDto<AuthResDto>  authentication(@RequestBody AuthReqDto authReqDto){
            if(authReqDto != null && authReqDto.username() != null && authReqDto.passwordd() != null){

                try {
                    //retorno los tokens null porque no hay error, true porque fue exitoso
                    return new ResponseDto<>(securityBl.authenticate(authReqDto), null, true);

                }catch(MacchinaException me){
                    return new ResponseDto<>(null, me.getMessage(), false);
                }
            }else {
               return  new ResponseDto<>(null,"Credenciales incorrectas",true);
            }
        //return securityBl.authenticate(authReqDto);

    }
    //Forma correcta pra el campo laboral
    @RequestMapping("/v2/")
    public ResponseEntity<ResponseDto<AuthResDto>> authenticationV2(@RequestBody AuthReqDto authReqDto){
        if(authReqDto != null && authReqDto.username() != null && authReqDto.passwordd() != null){

            try {
                //retorno los tokens null porque no hay error, true porque fue exitoso
                //return new ResponseDto<>(securityBl.authenticate(authReqDto), null, true);

                ResponseDto<AuthResDto> responseDto = new ResponseDto<>(securityBl.authenticate(authReqDto),null,true);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);

            }catch(MacchinaException me){
                ResponseDto<AuthResDto> responseDto = new ResponseDto<>(null,me.getMessage(),false);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            }
            //retorno los tokens null porque no hay error, true porque fue exitoso

    }else{
        ResponseDto<AuthResDto> responseDto = new ResponseDto<>(null,"Credenciales incorrectas",false);

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }
}
