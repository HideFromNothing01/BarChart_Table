package com.example.javafxbarchart;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Iphone {

    private final SimpleStringProperty id;
    private final SimpleStringProperty year;
    private final SimpleStringProperty region;
    private final SimpleStringProperty sales;

    // A number with two decimal places. Treat as a character string.

    public Iphone(String id, String year, String region, String sales) {
        this.id = new SimpleStringProperty(id);
        this.year = new SimpleStringProperty(year);
        this.region = new SimpleStringProperty(region);
        this.sales = new SimpleStringProperty(sales);
        }

    public String getId() {
        return id.get();
    }

    public String getYear() {
        return year.get();
    }

    public String getRegion() {
        return region.get();
    }

    public String getPrice() {
        return sales.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public SimpleStringProperty regionProperty() {
        return region;
    }
    public SimpleStringProperty salesProperty() {
        return sales;
    }

}
