package bo.edu.ucb.sis213.macchine_sos;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("bo.edu.ucb.sis213.macchine_sos.dao")
public class MacchineSosApplication {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean= new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
		sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
		return factoryBean.getObject();
		//return factoryBean.getObject();
	}

	public static void main(String[] args) {
		SpringApplication.run(MacchineSosApplication.class, args);
	}

}
