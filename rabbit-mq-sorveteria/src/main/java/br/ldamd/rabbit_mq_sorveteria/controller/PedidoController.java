package br.ldamd.rabbit_mq_sorveteria.controller;

import br.ldamd.rabbit_mq_sorveteria.producer.PedidoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    private final PedidoProducer pedidoProducer;

    @Autowired
    public PedidoController(PedidoProducer pedidoProducer) {
        this.pedidoProducer = pedidoProducer;
    }

    @PostMapping("/pedir-sorvete")
    public String pedirSorvete(@RequestParam String sabor) {
        pedidoProducer.enviarPedido(sabor);
        return "Pedido de sorvete de " + sabor + " enviado!";
    }
}
