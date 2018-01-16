package si.fri.prpo.zx2.ponudnik.vrsta;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@ApplicationScoped
public class QueueManager {

    private Logger log = Logger.getLogger(QueueManager.class.getName());

    private Connection connection;
    private Channel channel;

    @PostConstruct
    private void init() {

        ConnectionFactory factory = new ConnectionFactory();

        // konfiguracija factory-ja
        try {
            factory.setUri("amqp://rabbit:rabbit@192.168.99.100:5672");
        } catch (NoSuchAlgorithmException | KeyManagementException  | URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            // vzpostavitev povezave
            connection = factory.newConnection();

            // ustvarjanje channel-a
            channel = connection.createChannel();

            // deklaracija vrste na channel-u
            channel.queueDeclare("PRPO_PONUDNIKI", false, false, false, null);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void stop() {

        // zaprtje channel-a in uničenje povezave
        try {
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void posljiObvestiloODodanemPonudniku(Integer ponudnikId) throws IOException {

        // vstavljanje sporočila v vrstno
        channel.basicPublish("", "PRPO_PONUDNIKI", null, ByteBuffer.allocate(4).putInt(ponudnikId).array());
    }
}