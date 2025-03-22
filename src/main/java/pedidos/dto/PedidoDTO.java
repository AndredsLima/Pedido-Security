package pedidos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoDTO {
    private Long id;
    private String cliente;
    private List<ItemDTO> itens;}

