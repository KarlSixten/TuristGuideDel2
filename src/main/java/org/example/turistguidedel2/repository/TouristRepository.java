package org.example.turistguidedel2.repository;

import org.example.turistguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractionList;
    private final List<String> validCities = List.of("København", "Aarhus", "Odense");
    private final List<String> tagsList = List.of("Hyggeligt", "Billigt", "Dyrt", "Historisk");

    /*public TouristRepository() {
        populateAttractionList();
    }*/

    /*private void populateAttractionList() {
        attractionList = new ArrayList<>(List.of(
                new TouristAttraction("Tivoli", "Forlystelsespark i København", "København", 199, List.of("Hyggeligt", "Dyrt")),
                new TouristAttraction("SMK", "Statens museum for kunst", "København", 49, List.of("Hyggeligt", "Billigt")),
                new TouristAttraction("Tivoli Friheden", "Forlystelsespark i Aarhus", "Aarhus", 299, List.of("Uhyggeligt", "Billigt")),
                new TouristAttraction("Rundetårn", "Et rundt tårn", "København", 249, List.of("Historisk"))));
    }*/

    public List<TouristAttraction> getAttractionList() {
        return attractionList;
    }

    public List<String> getValidCities() {
        return validCities;
    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public TouristAttraction findAttraction(String searchString) {
        for (TouristAttraction touristAttraction : attractionList) {
            if (touristAttraction.getName().equalsIgnoreCase(searchString)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public void deleteAttraction(TouristAttraction touristAttraction) {
        attractionList.remove(touristAttraction);
    }

    public void addAttraction(TouristAttraction attractionToAdd) {
        attractionList.add(attractionToAdd);
    }
    public void updateAttraction(int indexToUpdate, TouristAttraction updatedAttraction) {
        attractionList.set(indexToUpdate, updatedAttraction);
    }
}