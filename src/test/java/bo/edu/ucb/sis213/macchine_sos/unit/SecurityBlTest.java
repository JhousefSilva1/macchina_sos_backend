package bo.edu.ucb.sis213.macchine_sos.unit;

import bo.edu.ucb.sis213.macchine_sos.bl.SecurityBl;
import bo.edu.ucb.sis213.macchine_sos.dao.MacchinaUserDao;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthReqDto;
import bo.edu.ucb.sis213.macchine_sos.dto.AuthResDto;
import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class SecurityBlTest {

    @Test
    void successAuthentication(){

        MacchinaUserDao macchinaUserDao = Mockito.mock(MacchinaUserDao.class); //invetar un DAO
        SecurityBl securityBl = new SecurityBl(macchinaUserDao);

        AuthResDto response = securityBl.authenticate(new AuthReqDto("JhousefSilva","878e7wqe47878dqc8787q"));

        Assertions.assertNotNull(response);//que la respuesta no sea nulo
        Assertions.assertNotNull(response.getToken());//que el token no sea nulo
        Assertions.assertNotNull(response.getRefreshToken());//que el refresh token no sea nulo
    }
}
