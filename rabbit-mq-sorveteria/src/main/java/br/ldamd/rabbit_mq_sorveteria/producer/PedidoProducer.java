package br.ldamd.rabbit_mq_sorveteria.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.ldamd.rabbit_mq_sorveteria.config.RabbitMQConfig;

@Component
public class PedidoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarPedido(String pedido) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_PEDIDOS, pedido);
        System.out.println("Pedido enviado: " + pedido);
    }
}