package lpp.tree.paths.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"lpp.tree.paths"})
@Configuration
public class RootApplicationConfig extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		new SpringApplication(RootApplicationConfig.class).run();
	}
}