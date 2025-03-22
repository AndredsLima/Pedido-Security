package pedidos.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pedidos.dto.PedidoDTO;

@Service
public class PedidoService {

    @Autowired
    private AmazonSQS amazonSQS;

    @Value("${aws.sqs.queue.url}")
    private String queueUrl;

    public void processarPedido(PedidoDTO pedidoDTO) {
        try {

            // Serializa o objeto recebido
            String mensagem = new ObjectMapper().writeValueAsString(pedidoDTO);
            System.out.println("Mensagem serializada: " + mensagem);

            // Envia a mensagem para a fila SQS
            amazonSQS.sendMessage(new SendMessageRequest(queueUrl, mensagem));
            System.out.println("Mensagem enviada para a fila SQS");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}