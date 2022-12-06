package bo.edu.ucb.sis213.macchine_sos.dao;

import bo.edu.ucb.sis213.macchine_sos.entity.MacchinaUser;
import org.apache.ibatis.annotations.Insert;
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
            AND status = true
            """)
    MacchinaUser findByPrimaryKey(Integer userId);

    @Select("""
            select
                
                passwordd
                
                        
            from macchina_user
                        
            where 
            username = #{username}
            AND status = true

            """)
    String findByUsernameAndPassword(String username);

    @Insert("""
            INSERT INTO
                macchina_user
                (
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
                )
                
                VALUES (#{username}, #{passwordd}, #{named}, #{lastnames}, #{email}, #{phone}, #{dni}, true, 'anonymus', '127.0.0.1',now())
 
            """)
    void CreateUser(MacchinaUser macchinaUser);
}
