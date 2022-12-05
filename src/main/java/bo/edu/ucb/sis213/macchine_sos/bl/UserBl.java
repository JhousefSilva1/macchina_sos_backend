package bo.edu.ucb.sis213.macchine_sos.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.macchine_sos.dao.MacchinaUserDao;
import bo.edu.ucb.sis213.macchine_sos.dto.CreateUserDto;
import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaUser;
import org.springframework.stereotype.Service;

@Service
public class UserBl {

    private MacchinaUserDao macchinaUserDao;
//Sptring lo realiza, lo mapea de la clase DAO
    public UserBl(MacchinaUserDao macchinaUserDao){
        this.macchinaUserDao = macchinaUserDao;
    }

    public void CreateUser(CreateUserDto createUserDto){

        MacchinaUser macchinaUser = new MacchinaUser();
        macchinaUser.setUsername(createUserDto.getUsername());

        String secret = BCrypt.withDefaults().hashToString(12, createUserDto.getPasswordd().toCharArray());
        createUserDto.getPasswordd();
        macchinaUser.setPasswordd(secret);
        macchinaUser.setNamed(createUserDto.getNamed());
        macchinaUser.setLastnames(createUserDto.getLastnames());
        macchinaUser.setEmail(createUserDto.getEmail());
        macchinaUser.setPhone(createUserDto.getPhone());
        macchinaUser.setDni(createUserDto.getDni());
        this.macchinaUserDao.CreateUser(macchinaUser);

    }
}
