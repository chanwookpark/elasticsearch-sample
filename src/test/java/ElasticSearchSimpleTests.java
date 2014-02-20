
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.junit.Test;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;
import static org.junit.Assert.assertNotNull;

/**
 * Created by chanwook on 2014. 2. 16..
 */
public class ElasticSearchSimpleTests {

    @Test
    public void simpleStartup() {
        Node node = nodeBuilder().node();
        Client client = node.client();

        assertNotNull(client);

        node.close();
    }

    @Test
    public void onlyClient() {
        Node node = nodeBuilder().client(true).node();
        Client client = node.client();

        node.close();
    }

    @Test
    public void local() {
        Node node = nodeBuilder().local(true).node();
        Client client = node.client();

        client.close();
    }

    @Test
    public void transport() {
        TransportClient client = new TransportClient().addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

        client.close();
    }
}
