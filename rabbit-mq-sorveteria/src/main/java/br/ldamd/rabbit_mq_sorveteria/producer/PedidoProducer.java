package br.ldamd.rabbit_mq_sorveteria.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {

    private final RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = ""; // Se não usar um exchange, mantenha vazio.
    private static final String ROUTING_KEY = "fila_pedidos"; // Nome da fila como routing key.

    @Autowired
    public PedidoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarPedido(String mensagem) {
        // Envia a mensagem para a fila
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }
}
