package model;

import java.util.List;

public class Order {
    private int orderId;
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private double totalAmount;

    public Order(int orderId, User user, Restaurant restaurant, List<MenuItem> items, double totalAmount) {
        this.orderId = orderId;
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() { return orderId; }
    public User getUser() { return user; }
    public Restaurant getRestaurant() { return restaurant; }
    public List<MenuItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }

    public void setItems(List<MenuItem> items) { this.items = items; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", User: " + user.getName() + ", Total: ₹" + totalAmount;
    }
}