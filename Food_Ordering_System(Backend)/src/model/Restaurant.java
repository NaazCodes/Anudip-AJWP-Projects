package model;

import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String location;
    private List<MenuItem> menu;

    public Restaurant(int id, String name, String location, List<MenuItem> menu) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.menu = menu;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public List<MenuItem> getMenu() { return menu; }

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setMenu(List<MenuItem> menu) { this.menu = menu; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + location + ")";
    }
}