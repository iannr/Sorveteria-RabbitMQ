package br.ldamd.rabbit_mq_sorveteria.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_PEDIDOS = "fila_pedidos_sorvete";

    @Bean
    public Queue filaPedidos() {
        return new Queue(FILA_PEDIDOS, false);
    }
}
