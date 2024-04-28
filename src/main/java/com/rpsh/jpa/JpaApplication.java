package com.rpsh.jpa;

import com.github.javafaker.Faker;
import com.rpsh.jpa.models.Author;
import com.rpsh.jpa.models.specification.AuthorSpecification;
import com.rpsh.jpa.repositories.AuthorRepository;
import com.rpsh.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository repository,
            VideoRepository videoRepository
    ) {
        return args -> {

            for (int i = 0; i < 50; i++) {
                Faker faker = new Faker();
                var author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .age(faker.number().numberBetween(20, 50))
                        .email(faker.internet().emailAddress())
                        .build();
               // repository.save(author);
            }

                var author = Author.builder()
                        .id(1)
                        .firstName("Rupesh")
                        .lastName("Karki")
                        .age(28)
                        .email("rpshkarki@gmail.com")
                        .build();
             //  repository.save(author);

           // repository.updateByNamedQuery(12);
         //   repository.updateAuthor(22,1);

				/*  var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);*/


            Specification<Author> specification = Specification
                    .where(AuthorSpecification.hasAge(43))
                    .or(AuthorSpecification.firstNameContains("Joni"));
            repository.findAll(specification).forEach(System.out::println);
        };
    }

}
