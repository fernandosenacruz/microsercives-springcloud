package io.github.fernandosenacruz.mscards;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@SpringBootApplication
@EnableRabbit
@Slf4j
public class MscardsApplication {

	public static void main(String[] args) {
		log.info("Info: {}", "info test");
		log.error("Error: {}", "error test");
		log.warn("Aviso: {}", "warn test");
		SpringApplication.run(MscardsApplication.class, args);
	}

}
