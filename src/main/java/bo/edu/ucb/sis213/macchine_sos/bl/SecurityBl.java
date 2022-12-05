package bo.edu.ucb.sis213.macchine_sos.bl;

import bo.edu.ucb.sis213.macchine_sos.dao.MacchinaUserDao;
import bo.edu.ucb.sis213.macchine_sos.dto.UserDto;
import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaUser;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service

public class SecurityBl {
    private MacchinaUserDao macchinaUserDao;

    public SecurityBl(MacchinaUserDao macchinaUserDao){
        this.macchinaUserDao = macchinaUserDao;
    }
    public UserDto getUserByPk (Integer userId){
        MacchinaUser macchinaUser = macchinaUserDao.findByPrimaryKey(userId);
        UserDto userDto =  new UserDto(
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
}
