package br.ldamd.rabbit_mq_sorveteria.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {

    @RabbitListener(queues = "fila_pedidos_sorvete")
    public void processarPedido(String pedido) {
        System.out.println("Pedido recebido: " + pedido);
        // Simular tempo de preparo do sorvete
        try {
            Thread.sleep(3000); // 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Sorvete de " + pedido + " pronto!");
    }
}
