package org.example.turistguidedel2.service;

import org.example.turistguidedel2.model.CurrencyRate;
import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.repository.TouristRepository;
import org.example.turistguidedel2.repository.TouristRepository_DB;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Service
public class TouristService {
    private final TouristRepository_DB touristRepository;

    public TouristService(TouristRepository_DB touristRepository) {
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
    public void addAttraction(TouristAttraction attractionToAdd) {
        touristRepository.addAttraction(attractionToAdd);
    }

    public TouristAttraction findAttraction(String searchString) {
        return touristRepository.findAttraction(searchString);
    }

    public void deleteAttraction(int attractionID) {
        touristRepository.deleteAttraction(attractionID);
    }


/*
    public List<String> getValidCities() {
        return touristRepository.getValidCities();
    }

    public List<String> getTagsList() {
        return touristRepository.getTagsList();
    }
    public void updateAttraction(int indexToUpdate, TouristAttraction updatedAttraction){
        touristRepository.updateAttraction(indexToUpdate, updatedAttraction);
    }*/
}
