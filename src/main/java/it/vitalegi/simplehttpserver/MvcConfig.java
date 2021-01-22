package it.vitalegi.simplehttpserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "it.vitalegi.simplehttpserver" })
public class MvcConfig implements WebMvcConfigurer {

	@Value("${static.resources}")
	String staticResources;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("Static resources: {}", staticResources);
		registry.addResourceHandler("/**")//
				.addResourceLocations(staticResources)//
				.setCachePeriod(10);
	}
}