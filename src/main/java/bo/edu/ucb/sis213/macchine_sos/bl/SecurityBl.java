package bo.edu.ucb.sis213.macchine_sos.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.macchine_sos.dao.MacchinaRolDao;
import bo.edu.ucb.sis213.macchine_sos.dao.MacchinaUserDao;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthReqDto;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthResDto;
import bo.edu.ucb.sis213.macchine_sos.dto.UserDto;
import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaRol;
import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class SecurityBl {
    private MacchinaUserDao macchinaUserDao;

    private MacchinaRolDao macchinaRolDao;

    public SecurityBl(MacchinaUserDao macchinaUserDao, MacchinaRolDao macchinaRolDao) {
        this.macchinaUserDao = macchinaUserDao;
        this.macchinaRolDao = macchinaRolDao;
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

                //Consultamos los roles que tiene el usuario
                List<MacchinaRol> roles = macchinaRolDao.findRolesByUsername(credentials.username());
                List<String> rolesAsString = new ArrayList<>();
                for(MacchinaRol rol: roles){
                    rolesAsString.add(rol.getNamed());
                }
                result=generateTokenJwt(credentials.username(), 300,rolesAsString);

             //   result.setToken("Test Token");
               // result.setRefreshToken("Test Refresh Token");


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
public AuthResDto generateTokenJwt(String subject, int expirationTimeSeconds, List<String> roles) {
        AuthResDto result = new AuthResDto();
            //generar el token principal
        try{
            Algorithm algorithm = Algorithm.HMAC256("pruebaToken");
            String token = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                    .withClaim("refresh", false)
                    .withExpiresAt(new Date(System.currentTimeMillis() + expirationTimeSeconds * 1000))
                    .sign(algorithm);
            result.setToken(token);
            String refreshToken = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                    .withClaim("refresh", true)
                    .withExpiresAt(new Date(System.currentTimeMillis() + expirationTimeSeconds * 1000))
                    .sign(algorithm);
            result.setRefreshToken(refreshToken);
        }catch (JWTCreationException exception){
           // throw new RuntimeException("Error al generar el token", exception);
        }

        return  result;

    }
}
