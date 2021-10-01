package application.controllers;


import application.objects.Country;
import application.services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    @Autowired
    CountriesService countryService;

    @GetMapping
    public List<Country> listAllCountries() {
        return countryService.listAllCountries();
    }

}
