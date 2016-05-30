package solution.steve.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import solution.steve.domain.DataFormat;
import solution.steve.repository.DataFormatRepository;

@Component
public class DataCreator {

    int port;

    @Autowired
    private DataFormatRepository repository;

    public DataCreator() {

    }

    @EventListener
    public void getServlet(EmbeddedServletContainerInitializedEvent servlet) {
        port = servlet.getApplicationContext().getEmbeddedServletContainer().getPort();
        repository.save(new DataFormat(port, System.currentTimeMillis()));
    }
}
