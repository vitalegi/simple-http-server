package it.vitalegi.simplehttpserver;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

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
				.setCachePeriod(10).resourceChain(true).addResolver(new PathResourceResolver() {

					@Override
					protected Resource getResource(String resourcePath, Resource location) throws IOException {
						Resource relative = location.createRelative(resourcePath);
						if (relative.getFile().isDirectory()) {
							return super.getResource(resourcePath + "/index.html", location);
						}
						return super.getResource(resourcePath, location);
					}
				});
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "index.html");
	}
}