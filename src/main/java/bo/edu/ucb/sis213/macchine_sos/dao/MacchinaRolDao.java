package bo.edu.ucb.sis213.macchine_sos.dao;

import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaRol;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//sa/lpz/28585
public interface MacchinaRolDao {
    @Select("""
            
            SELECT
                                     rol.rol_id,
                                     rol.named,
                                     rol.description,
                                     rol.tx_username,
                                     rol.tx_host,
                                     rol.tx_date
                                 FROM macchina_rol rol
                                          JOIN macchina_group_rol group_rol ON group_rol.rol_id = rol.rol_id
                                          JOIN macchina_user_group user_group ON user_group.group_id = group_rol.group_id
                                          JOIN macchina_user usr ON usr.user_id = user_group.user_id
                                 WHERE usr.username = #{username}
                                   AND
                                     rol.status = true
                                   AND
                                     group_rol.status = true
                                   AND
                                     user_group.status = true
                                   AND
                                     usr.status = true
            
            
            
            """)
    public List<MacchinaRol> findRolesByUsername(String username);

}
