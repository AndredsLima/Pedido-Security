package pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedidos.dto.PedidoDTO;
import pedidos.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public String criarPedido(@RequestBody PedidoDTO pedidoDTO) {
//
        pedidoService.processarPedido(pedidoDTO);
        return "Pedido criado e enviado para o sistema de estoque!";
    }}