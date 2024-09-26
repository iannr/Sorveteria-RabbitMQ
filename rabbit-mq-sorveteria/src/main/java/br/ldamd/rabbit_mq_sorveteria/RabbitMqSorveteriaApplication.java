package br.ldamd.rabbit_mq_sorveteria;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqSorveteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSorveteriaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RabbitTemplate rabbitTemplate) {
		return args -> {
			String mensagem = "Teste de pedido de sorvete";
			rabbitTemplate.convertAndSend("", "fila_pedidos", mensagem);
			System.out.println("Mensagem enviada: " + mensagem);
		};
	}
}
