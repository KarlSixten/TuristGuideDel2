package org.example.turistguidedel2.repository;

import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.service.TouristService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractionList;

    public TouristRepository() {
        populateAttractionList();
    }

    private void populateAttractionList() {
        attractionList = new ArrayList<>(List.of(
                new TouristAttraction("Tivoli", "Forlystelsespark i København", List.of("Hyggeligt", "Dyrt")),
                new TouristAttraction("SMK", "Statens museum for kunst", List.of("Hyggeligt", "Billigt")),
                new TouristAttraction("Rundetårn", "Et rundt tårn", List.of("Historisk"))
        ));
    }

    public List<TouristAttraction> getAttractionList() {
        return attractionList;
    }

    public TouristAttraction findAttraction(String searchString) {
        for (TouristAttraction touristAttraction : attractionList) {
            if (touristAttraction.getName().equalsIgnoreCase(searchString)) {
                return touristAttraction;
            }
        }
        return null;
    }
}
