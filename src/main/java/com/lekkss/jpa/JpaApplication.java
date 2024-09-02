package com.lekkss.jpa;

import com.lekkss.jpa.models.Author;
import com.lekkss.jpa.models.Video;
import com.lekkss.jpa.repositories.AuthorRepository;
import com.lekkss.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

//	@Bean
	public CommandLineRunner commandLineRunner(
		AuthorRepository repository,
		VideoRepository	videoRepository
	) {
		return args -> {
//			var author =  Author.builder()
//					.firstName("John")
//					.lastName("Doe")
//					.age(27)
//					.email("john@doe.com")
//					.build();
//			repository.save(author);
			var video = Video.builder()
					.name("ABC")
					.length(5)
					.build();
			videoRepository.save(video);
		};
	}

}
