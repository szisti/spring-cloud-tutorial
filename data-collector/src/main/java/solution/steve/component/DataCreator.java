package solution.steve.component;

import com.betvictor.sportsbook.automation.zookeeper.NodeCandidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.cluster.leader.Candidate;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import solution.steve.domain.DataFormat;

@Component
public class DataCreator {
    private static final Logger LOG = LoggerFactory.getLogger(DataCreator.class);

    int port = 0;

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private Candidate candidate;

    public DataCreator() {

    }

    @EventListener
    public void getServlet(EmbeddedServletContainerInitializedEvent servlet) {
        port = servlet.getApplicationContext().getEmbeddedServletContainer().getPort();
    }

    @Scheduled(fixedDelay = 100)
    public void addEntry() {
        if (port > 0 && candidate.getRole().equals(NodeCandidate.NodeStatus.Leader.toString())) {
            ResponseEntity<DataFormat> data = restTemplate.postForEntity("http://data-provider/add-entry", new DataFormat(port, System.currentTimeMillis()), DataFormat.class);
            LOG.info("Adding entry for port {}, {}, {}", port, data, data.getBody());
        }
    }

}
