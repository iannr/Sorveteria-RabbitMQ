package br.ldamd.rabbit_mq_sorveteria.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_PEDIDOS = "fila_pedidos";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_PEDIDOS, false); // Se for falso, a fila não é durável
    }
}
