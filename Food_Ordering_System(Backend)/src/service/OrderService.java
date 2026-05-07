package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.MenuItem;
import model.Order;
import model.Restaurant;
import model.User;

import util.OrderNotFoundException;

public class OrderService {

    private Map<Integer, Order> orderMap = new HashMap<>();

    // CREATE ORDER
    public Order createOrder(int orderId, User user, Restaurant restaurant, List<MenuItem> items) {

        // 🔥 calculate total using stream
        double total = items.stream()
                .mapToDouble(item -> item.getPrice())
                .sum();

        Order order = new Order(orderId, user, restaurant, items, total);

        orderMap.put(orderId, order);

        return order;
    }

    // READ ALL ORDERS
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }

    // READ BY ID
    public Order getOrderById(int id) {
        if (!orderMap.containsKey(id)) {
            throw new OrderNotFoundException("Order not found!");
        }
        return orderMap.get(id);
    }

    // DELETE ORDER
    public void deleteOrder(int id) {
        if (!orderMap.containsKey(id)) {
            throw new OrderNotFoundException("Order not found!");
        }

        orderMap.remove(id);
    }
}