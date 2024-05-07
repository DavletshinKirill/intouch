package dev.davletshin.intouch;

import dev.davletshin.intouch.config.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntouchApplication {
	private static Initializer initiator;

	@Autowired
	public void setInitialLoader(Initializer initiator) {
		IntouchApplication.initiator = initiator;
	}

	public static void main(String[] args) {
		SpringApplication.run(IntouchApplication.class, args);
		initiator.initialize();
	}

}
