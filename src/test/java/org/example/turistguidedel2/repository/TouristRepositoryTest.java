package org.example.turistguidedel2.repository;

import org.example.turistguidedel2.model.TouristAttraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {
    TouristRepository touristRepository = new TouristRepository();

    @BeforeEach
    void setUp() {
        TouristRepository touristRepository = new TouristRepository();
    }

    @Test
    void findAttraction() {
        TouristAttraction touristAttraction = touristRepository.findAttraction("Tivoli");
        String actualName = touristAttraction.getName();
        String expectedName = "Tivoli";
        assertEquals(actualName, expectedName);

    }

    @Test
    void deleteAttraction() {
        TouristAttraction touristAttractionToDelete = new TouristAttraction("Tivoli", "Jaja", "Aarhus", 5, List.of("Hyggeligt"));
        touristRepository.deleteAttraction(touristAttractionToDelete);


        assertFalse(touristRepository.getAttractionList().contains(touristAttractionToDelete));
    }

    @Test
    void addAttraction() {
        TouristAttraction attractionToAdd = new TouristAttraction("Tivoli", "Jaja", "Aarhus", 5, List.of("Hyggeligt"));
        touristRepository.addAttraction(attractionToAdd);

        assertEquals(touristRepository.getAttractionList().get(touristRepository.getAttractionList().size() - 1), attractionToAdd);
        assertTrue(touristRepository.getAttractionList().contains(attractionToAdd));
    }

    @Test
    void updateAttraction() {
        TouristAttraction attractionToAdd = new TouristAttraction("Tivoli", "Jaja", "Aarhus", 5, List.of("Hyggeligt"));
        touristRepository.updateAttraction(1, attractionToAdd);


    }
}