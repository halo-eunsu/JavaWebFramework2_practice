package config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import controller.LogOutController;
import controller.MemberListController;

@Configuration
@ComponentScan(basePackages = "controller, dao, vo, validator")
@EnableWebMvc
public class ServletContextConfiguration {
	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		Properties mappings = new Properties();
		mappings.setProperty("/member/list.do", "memberListController");
		mappings.setProperty("/auth/logout.do", "logOutController");
		
		SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
		handlerMapping.setMappings(mappings);
		
		return handlerMapping;
	}
	
	@Bean
	public MemberListController memberListController() {
		return new MemberListController();
	}
	
	@Bean(name = "logOutController")
	public LogOutController logOutController() {
		return new LogOutController();
	}
	
	@Bean
	public UrlBasedViewResolver jspViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
}
