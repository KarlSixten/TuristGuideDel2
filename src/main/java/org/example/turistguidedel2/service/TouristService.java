package org.example.turistguidedel2.service;

import org.example.turistguidedel2.model.CurrencyRate;
import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.repository.TouristRepository;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public double getDkkToEur() throws IOException {
        URL url = new URL("https://cdn.forexvalutaomregner.dk/api/latest.json");
        BufferedReader inputFromUrl = new BufferedReader(new InputStreamReader(url.openStream()));
        CurrencyRate currencyRate = new Gson().fromJson(inputFromUrl, CurrencyRate.class);
        inputFromUrl.close();

        return currencyRate.getDkkToEur();
    }

    public List<TouristAttraction> getAttractionList() {
        return touristRepository.getAttractionList();
    }

    public TouristAttraction findAttraction(String searchString) {
        return touristRepository.findAttraction(searchString);
    }

/*
    public void deleteAttraction(TouristAttraction attractionToDelete) {
        touristRepository.deleteAttraction(attractionToDelete);
    }

    public void addAttraction(TouristAttraction attractionToAdd) {
        touristRepository.addAttraction(attractionToAdd);
    }

    public List<String> getValidCities() {
        return touristRepository.getValidCities();
    }

    public List<String> getTagsList() {
        return touristRepository.getTagsList();
    }
    public void updateAttraction(int indexToUpdate, TouristAttraction updatedAttraction){
        touristRepository.updateAttraction(indexToUpdate, updatedAttraction);
    }
}
