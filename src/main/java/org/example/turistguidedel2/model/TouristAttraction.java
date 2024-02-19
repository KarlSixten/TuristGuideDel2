package org.example.turistguidedel2.model;

import java.util.List;


public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private int ticketPrice; //Kan ikke få thymeleaf/html til at tage double som input, derfor er dette en int lige pt.
    private List<String> tags;

    public TouristAttraction(String name, String description, String city, int ticketPrice, List<String> tags) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
        this.ticketPrice = ticketPrice;
    }

    public TouristAttraction() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
