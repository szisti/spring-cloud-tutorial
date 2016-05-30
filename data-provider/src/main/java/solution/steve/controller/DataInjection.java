package solution.steve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import solution.steve.domain.DataFormat;
import solution.steve.repository.DataFormatRepository;

@RestController
public class DataInjection {

    @Autowired
    private DataFormatRepository repository;

    @RequestMapping(value = "/add-entry", method = RequestMethod.POST)
    private DataFormat addEntry(@RequestBody DataFormat dataFormat) {
        return repository.save(dataFormat);
    }

}
