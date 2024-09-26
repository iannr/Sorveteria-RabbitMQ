package br.ldamd.rabbit_mq_sorveteria.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PedidoProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String FILA_PEDIDOS = "fila_pedidos_sorvete";

    @PostMapping("/pedir-sorvete")
    public String pedirSorvete(@RequestParam String sabor) {
        rabbitTemplate.convertAndSend(FILA_PEDIDOS, sabor);
        return "Pedido de sorvete de " + sabor + " enviado com sucesso!";
    }
}
