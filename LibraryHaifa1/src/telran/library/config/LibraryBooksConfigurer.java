package telran.library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ComponentScan(basePackages="telran.security")
@EnableMongoRepositories(basePackages="telran.security.repositories")
@Order(value=200)
public class LibraryBooksConfigurer extends WebSecurityConfigurerAdapter {



}
