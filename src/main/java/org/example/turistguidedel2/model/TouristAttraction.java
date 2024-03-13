package org.example.turistguidedel2.model;

import java.util.List;


public class TouristAttraction {
    private int attractionID;
    private String name;
    private String description;
    private int city;
    private int ticketPrice;

    public TouristAttraction(String name, String description, int city, int ticketPrice) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.ticketPrice = ticketPrice;
    }

    public TouristAttraction() {}

    public TouristAttraction(int attractionID, String name, String description, int city, int ticketPrice) {
        this.attractionID = attractionID;
        this.name = name;
        this.description = description;
        this.city = city;
        this.ticketPrice = ticketPrice;
    }

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

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
