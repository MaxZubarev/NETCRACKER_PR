/*
package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"Services", "DAOsloi"})
public class Conf {
    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource manager = new DriverManagerDataSource();
        manager.setUrl("jdbc:mysql://localhost:3306/autosalon");
        manager.setUsername("root");
        manager.setPassword("root");
        manager.setDriverClassName("com.mysql.jdbc.Driver");
        return manager;
    }
}

*/
