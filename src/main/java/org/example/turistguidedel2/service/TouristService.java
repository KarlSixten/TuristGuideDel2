package org.example.turistguidedel2.service;

import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAttractionList() {
        return touristRepository.getAttractionList();
    }

    public TouristAttraction findAttraction(String searchString) {
        return touristRepository.findAttraction(searchString);
    }
}
