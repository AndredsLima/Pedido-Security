package pedidos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ItemDTO {
    private Long produtoId;
    private Integer quantidade;



}