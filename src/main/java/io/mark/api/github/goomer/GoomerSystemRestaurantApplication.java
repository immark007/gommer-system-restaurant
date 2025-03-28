package io.mark.api.github.goomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoomerSystemRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoomerSystemRestaurantApplication.class, args);
	}

}
