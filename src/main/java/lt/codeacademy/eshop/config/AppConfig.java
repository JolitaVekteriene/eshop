package lt.codeacademy.eshop.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration()
public class AppConfig {


//    @Bean                                     //NEBEREIKIA TIES TEMPLATES
//    public DataSource dataSource() {
//        DataSourceBuilder<?> dataSource = DataSourceBuilder.create();
//        dataSource.url("jdbc:h2:mem:eshopDB");
//        dataSource.username("sa");
//        dataSource.password("");
//
//        return dataSource.build();
//    }
}
