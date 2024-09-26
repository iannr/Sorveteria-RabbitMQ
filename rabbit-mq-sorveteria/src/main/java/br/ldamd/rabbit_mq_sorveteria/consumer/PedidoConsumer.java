package br.ldamd.rabbit_mq_sorveteria.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;
import br.ldamd.rabbit_mq_sorveteria.config.RabbitMQConfig;

@Component
public class PedidoConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PEDIDOS)
    public void processarPedido(String pedido, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        try {
            System.out.println("Atendendo pedido: " + pedido);

            // Simula o tempo de preparo
            Thread.sleep(2000);

            // Pedido processado com sucesso, reconhecendo a mensagem manualmente
            channel.basicAck(tag, false);
            System.out.println("Pedido pronto: " + pedido);
        } catch (Exception e) {
            e.printStackTrace();
            // Em caso de erro, você pode rejeitar a mensagem e decidir se ela deve ser
            // redelivery
            try {
                channel.basicNack(tag, false, true); // true significa reencolar a mensagem na fila
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
