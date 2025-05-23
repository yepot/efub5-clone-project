package efub.project.tweeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TweeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweeterApplication.class, args);
	}

}
