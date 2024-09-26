package br.ldamd.rabbit_mq_sorveteria.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import br.ldamd.rabbit_mq_sorveteria.config.RabbitMQConfig;

@Component
public class PedidoConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PEDIDOS)
    public void processarPedido(String pedido) {
        System.out.println("Atendendo pedido: " + pedido);
        // Simulação de processamento do pedido
        try {
            Thread.sleep(2000); // Simulando tempo de preparo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Pedido pronto: " + pedido);
    }
}
