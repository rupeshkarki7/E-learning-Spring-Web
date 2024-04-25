package com.rpsh.jpa;

import com.rpsh.jpa.models.Author;
import com.rpsh.jpa.models.Video;
import com.rpsh.jpa.repositories.AuthorRepository;
import com.rpsh.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}


	//@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository
	){
		return args -> {
			/*var author = Author.builder()
					.firstName("Rupesh")
					.lastName("Karki")
					.age(22)
					.email("rpshkarki@gmail.com")
					.build();
			repository.save(author);
			*/

			var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);

		};
	}

}
