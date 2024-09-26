package br.ldamd.rabbit_mq_sorveteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.ldamd.rabbit_mq_sorveteria")
public class RabbitMqSorveteriaApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSorveteriaApplication.class, args);
	}
}
