package org.example.turistguidedel2.controller;

import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public String getAllAttractions(Model model) {
        List<TouristAttraction> attractionList = touristService.getAttractionList();
        model.addAttribute("attractionsList", attractionList);
        return "attractions";
    }

    @GetMapping("{name}/tags")
    public String getAttractionTags() {
        return null;
    }

    @GetMapping("add")
    public String addAttraction() {
        return null;
    }

    @PostMapping("save")
    public String saveAttraction() {
        return null;
    }

    @GetMapping("{name}/edit")
    public String editAttraction() {
        return null;
    }

    @PostMapping("update")
    public String updateAttraction() {
        return null;
    }

    @GetMapping("{name}/delete")
    public String deleteAttraction() {
        return null;
    }
}
