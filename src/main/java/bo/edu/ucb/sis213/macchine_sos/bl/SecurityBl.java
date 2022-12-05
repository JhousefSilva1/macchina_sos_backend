package bo.edu.ucb.sis213.macchine_sos.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.macchine_sos.dao.MacchinaUserDao;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthReqDto;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthResDto;
import bo.edu.ucb.sis213.macchine_sos.dto.UserDto;
import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaUser;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service

public class SecurityBl {
    private MacchinaUserDao macchinaUserDao;

    public SecurityBl(MacchinaUserDao macchinaUserDao) {
        this.macchinaUserDao = macchinaUserDao;
    }

    public UserDto getUserByPk(Integer userId) {
        MacchinaUser macchinaUser = macchinaUserDao.findByPrimaryKey(userId);
        UserDto userDto = new UserDto(
                //Transformamos la entidad de la bae de datos
                // a un DTO para retornar via API -> DTO
                macchinaUser.getUserId(),
                macchinaUser.getUsername(),
                macchinaUser.getNamed(),
                macchinaUser.getLastnames(),
                macchinaUser.getEmail(),
                macchinaUser.getPhone(),
                macchinaUser.getDni()
        );
        return userDto;
    }

    ///Este metodo realiz la autenticacion del susistema, va a buiscar al reposuitorio de la BD
    // la constrasena del user y la compara con su equivalente en BCrypt
    public AuthResDto authenticate(AuthReqDto credentials) {

        AuthResDto result = new AuthResDto();
        System.out.println("Comenzando el preoceso de autenticacion con " + credentials);

        String currentPasswordInBcrypt = macchinaUserDao.findByUsernameAndPassword(credentials.username());//No se le pasa el PWD
        System.out.println("Se obtuvo la siguiente contrasena de la base de datos: " + currentPasswordInBcrypt);



        //consulto si los pwd son iguales
        if (currentPasswordInBcrypt != null) {
            System.out.println("Se procede a comparar las contrasenas");
            BCrypt.Result bcryptresult = BCrypt.verifyer().verify(credentials.passwordd().toCharArray(), currentPasswordInBcrypt);
            if (bcryptresult.verified) {
                //Si son iguales, retorno un objeto de tipo AuthResDto
                //procedemos a generar el token
                System.out.println("Las contrasenas son iguales se procede a generar el token");
                result.setToken("Test Token");
                result.setRefreshToken("Test Refresh Token");
            } else {
                System.out.println("Las contrasenas no son iguales");
                //Si no son iguales, retorno un objeto de tipo AuthResDto
                throw new RuntimeException("Forbidden the password is incorrect");
            }
        }else {
            System.out.println("No se encontro el usuario");
            throw new RuntimeException("Forbidden the user does not exist");
        }
            return result;
        }

    }
