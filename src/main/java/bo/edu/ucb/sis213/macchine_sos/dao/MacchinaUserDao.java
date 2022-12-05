package bo.edu.ucb.sis213.macchine_sos.dao;

import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaUser;
import org.apache.ibatis.annotations.Select;

public interface MacchinaUserDao {

    @Select("""
            select
                user_id,
                username,
                passwordd,
                named,
                lastnames,
                email,
                phone,
                dni,
                status,
                tx_username,
                tx_host,
                tx_date
                        
            from macchina_user
                        
            where user_id = #{userId}
            """)
    MacchinaUser findByPrimaryKey(Integer userId);
}
