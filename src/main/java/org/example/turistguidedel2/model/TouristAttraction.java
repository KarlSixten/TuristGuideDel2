package org.example.turistguidedel2.model;

import java.util.List;


public class TouristAttraction {
    private int attractionID;
    private String name;
    private String description;
    private String city;
    private int ticketPrice;

    public TouristAttraction(String name, String description, String city, int ticketPrice) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.ticketPrice = ticketPrice;
    }

    public TouristAttraction() {}

    public TouristAttraction(int attractionID, String name, String description, String city, int ticketPrice) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAttractionID() {
        return attractionID;
    }
}
