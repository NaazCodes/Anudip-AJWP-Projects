package model;

public class MenuItem {
    private int id;
    private String name;
    private double price;
    private boolean isVeg;

    public MenuItem(int id, String name, double price, boolean isVeg) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isVeg = isVeg;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isVeg() { return isVeg; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setVeg(boolean veg) { isVeg = veg; }

    @Override
    public String toString() {
        return id + " - " + name + " - ₹" + price + " - " + (isVeg ? "Veg" : "Non-Veg");
    }
}