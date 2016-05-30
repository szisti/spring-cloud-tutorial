package solution.steve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import solution.steve.domain.DataFormat;
import solution.steve.domain.TimeFormat;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListConverter {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping(value = "/get-list", method = RequestMethod.GET)
    private List<String> getList() {
        ResponseEntity<Resources<DataFormat>> dataFormats =
                this.restTemplate.exchange("http://data-provider/dataFormats/",
                        HttpMethod.GET, null, new ParameterizedTypeReference<Resources<DataFormat>>() {});

        return dataFormats.getBody().getContent().stream().map(TimeFormat::new).map(TimeFormat::toString).collect(Collectors.toList());
    }
}
