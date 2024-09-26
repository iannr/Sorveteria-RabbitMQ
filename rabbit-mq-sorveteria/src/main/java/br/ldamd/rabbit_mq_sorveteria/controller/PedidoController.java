package br.ldamd.rabbit_mq_sorveteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.ldamd.rabbit_mq_sorveteria.producer.PedidoProducer;

@RestController
public class PedidoController {

    @Autowired
    private PedidoProducer pedidoProducer;

    @PostMapping("/pedir-sorvete")
    public String pedirSorvete(@RequestParam String sabor) {
        pedidoProducer.enviarPedido(sabor);
        return "Pedido de sorvete de " + sabor + " enviado!";
    }
}
