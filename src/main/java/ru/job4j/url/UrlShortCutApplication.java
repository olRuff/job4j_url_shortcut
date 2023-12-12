package ru.job4j.url;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UrlShortCutApplication {

	@Bean(destroyMethod = "close")
	public static SessionFactory sf() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		return new MetadataSources(registry)
				.buildMetadata()
				.buildSessionFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(UrlShortCutApplication.class, args);
	}

}
