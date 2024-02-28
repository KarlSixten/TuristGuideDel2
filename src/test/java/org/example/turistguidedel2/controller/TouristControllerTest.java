package org.example.turistguidedel2.controller;

import org.example.turistguidedel2.model.CurrencyRate;
import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.repository.TouristRepository;
import org.example.turistguidedel2.service.TouristService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TouristController.class)
class TouristControllerTest {

    private TouristAttraction touristAttraction = new TouristAttraction("Tivoli", "Forlystelsespark i København", "København", 199, List.of("Hyggeligt", "Dyrt"));

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TouristService touristService;

    @MockBean
    private CurrencyRate currencyRate;

    @Test
    void getAllAttractions() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("attractions"));
    }

    @Test
    void showSpecificAttraction() throws Exception {
        given(touristService.findAttraction(ArgumentMatchers.any())).willReturn(
                new TouristAttraction("Tivoli",
                        "Forlystelsespark i København",
                        "København",
                        199,
                        List.of("Hyggeligt", "Dyrt")));

        mockMvc.perform(get("/attractions/Tivoli"))
                .andExpect(status().isOk())
                .andExpect(view().name("attraction"))
               .andExpect(content().string(containsString("Tivoli")));
    }

    @Test
    void getAttractionTags() throws Exception {
       given(touristService.findAttraction(ArgumentMatchers.any())).willReturn(
               new TouristAttraction("Tivoli",
                       "Forlystelsespark i København",
                       "København",
                       199,
                       List.of("Hyggeligt", "Dyrt")));

        mockMvc.perform(get("/attractions/Tivoli/tags"))
                .andExpect(status().isOk())
                .andExpect(view().name("tags"))
                .andExpect(content().string(containsString("Dyrt")));
    }

    @Test
    void saveAttraction() {
    }

    @Test
    void editAttraction() {
    }

    @Test
    void updateAttraction() {
    }

    @Test
    void deleteAttraction() {
    }
}