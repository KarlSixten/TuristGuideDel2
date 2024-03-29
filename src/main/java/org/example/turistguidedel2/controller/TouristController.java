package org.example.turistguidedel2.controller;

import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public String getAllAttractions(Model model) throws IOException {
        List<TouristAttraction> attractionList = touristService.getAttractionList();
        model.addAttribute("attractionsList", attractionList);
        model.addAttribute("dkkToEur", touristService.getDkkToEur());
        return "attractions";
    }

    @GetMapping("{name}")
    public String showSpecificAttraction(@PathVariable("name") String name, Model model) {
        TouristAttraction touristAttraction = touristService.findAttraction(name);
        model.addAttribute("attraction", touristAttraction);
        return "attraction";
    }

    @GetMapping("add")
    public String addAttraction(Model model) {
        model.addAttribute("attraction", new TouristAttraction());
        model.addAttribute("validCities", touristService.getValidCities());
        //model.addAttribute("tagsList", touristService.getTagsList());
        return "add";
    }


    @GetMapping("{name}/tags")
    public String getAttractionTags(@PathVariable("name") String name, Model model) {
        TouristAttraction touristAttraction = touristService.findAttraction(name);
        List<String> tagList = touristService.getTagList(touristAttraction.getAttractionID());

        model.addAttribute("attraction", touristAttraction);
        model.addAttribute("tagList", tagList);
        return "tags";
    }

    @PostMapping("save")
    public String saveAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.addAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("{name}/edit")
    public String editAttraction(@PathVariable("name") String name, Model model) {
        TouristAttraction attractionToUpdate = touristService.findAttraction(name);
        model.addAttribute("attraction", attractionToUpdate);
        model.addAttribute("indexOfAttraction", touristService.getAttractionList().indexOf(attractionToUpdate));
        model.addAttribute("validCities", touristService.getValidCities());
        //model.addAttribute("tagsList", touristService.getTagsList());
        return "update";
    }
    @PostMapping("update")
    public String updateAttraction(@ModelAttribute("touristAttraction") TouristAttraction attractionToUpdate,
                                       RedirectAttributes redirectAttributes) {
            try {
                touristService.updateAttraction(attractionToUpdate);
                redirectAttributes.addFlashAttribute("successMessage", "Attraction updated successfully");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Failed to update attraction: " + e.getMessage());
                e.printStackTrace();
            }return "redirect:/attractions";
    }


    @GetMapping("{name}/delete")
    public String deleteAttraction(@PathVariable("name") String name) {
        TouristAttraction attractionToDelete = touristService.findAttraction(name);
        int attractionID = attractionToDelete.getAttractionID();
        touristService.deleteAttraction(attractionID);
        return "redirect:/attractions";
    }
}
