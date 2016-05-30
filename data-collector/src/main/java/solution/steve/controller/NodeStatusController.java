package solution.steve.controller;


import com.betvictor.sportsbook.automation.zookeeper.NodeCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.cluster.leader.Candidate;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ManagedResource(objectName="solutions.steve:name=NodeStatus",
        description="Node status controller.")
public class NodeStatusController {

    @Autowired
    private Candidate candidate;

    @ManagedAttribute
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String getStatus() {
        return candidate.getRole();
    }

    @ManagedOperation
    @RequestMapping(value = "/yield", method = RequestMethod.GET)
    public String yieldLeadership() {
        ((NodeCandidate)candidate).yieldLeadership();
        return "Leadership yielded";
    }
}
