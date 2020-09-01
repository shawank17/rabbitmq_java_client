package rabbitmq;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);
  private ObjectMapper mapper = new ObjectMapper();
  public void receiveMessage(byte[] message) {
//    String msg = new String(message);
    String messageString = new String(message, StandardCharsets.UTF_8);
    try {
      EmailData emailData = mapper.readValue(messageString, EmailData.class);
      System.out.println("Received <" + emailData + ">");
      latch.countDown();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public CountDownLatch getLatch() {
    return latch;
  }


}