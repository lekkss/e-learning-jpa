package com.lekkss.jpa;

import com.github.javafaker.Faker;
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

	@Bean
	public CommandLineRunner commandLineRunner(
		AuthorRepository repository,
		VideoRepository	videoRepository
	) {
		return args -> {
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				var author =  Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19,40))
						.email(faker.name().username() + i +"@lekksscoding.com")
						.build();
				repository.save(author);
			}
				// Update author with id 1
				var author =  Author.builder()
						.id(1)
						.firstName("Olu")
						.lastName("Afo")
						.age(27)
						.email("lekan@gmail.com")
						.build();
//				repository.save(author);

				// update author a set a.age = 2 where a.id = 1
//			repository.updateAuthor(30, 1);

//			repository.updateAllAuthorsAges(90);

//			repository.findByNamedQuery(20);
//					.forEach(System.out::println);

			//update with named query
			repository.updateByNamedQuery(12);


//			var video = Video.builder()
//					.name("ABC")
//					.length(5)
//					.build();
//			videoRepository.save(video);
		};
	}

}
