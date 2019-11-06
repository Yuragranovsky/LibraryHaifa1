package telran.library.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import telran.library.api.LibraryApiConstants;

@Configuration
@ComponentScan(basePackages="telran.security")
@EnableMongoRepositories(basePackages="telran.security.repositories")
@Order(value=50)
public class LibraryBooksConfigurer extends WebSecurityConfigurerAdapter {
	@Value("${authentication:enabled}")
	String authentication;
@Override
protected void configure(HttpSecurity http) throws Exception{
	http.httpBasic();
	http.csrf().disable();
	if (authentication.equals("disabled")) {
		http.authorizeRequests().anyRequest().permitAll();
	} else {
		http.authorizeRequests().antMatchers(LibraryApiConstants.ADD_BOOK)
		.hasRole("ABCD1");
		http.authorizeRequests().anyRequest().authenticated();
	}
	
}


}
