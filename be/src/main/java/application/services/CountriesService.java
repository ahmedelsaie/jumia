package application.services;


import application.objects.Country;
import application.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesService {

    @Autowired
    CountryRepository countryRepo;

    public List<Country> listAllCountries()
    {
        return countryRepo.findAll();
    }
}
