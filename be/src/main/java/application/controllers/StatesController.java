package application.controllers;

import application.services.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StatesController {

    @Autowired
    StatesService stateService;

    @GetMapping
    public Object[] listAllStates() {
        return stateService.listAllStates();
    }
}
