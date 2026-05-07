package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.MenuItem;
import model.Restaurant;

import util.RestaurantNotFoundException;

public class RestaurantService {

    private Map<Integer, Restaurant> restaurantMap = new HashMap<>();

    // CREATE
    public void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getId(), restaurant);
    }

    // READ ALL
    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurantMap.values());
    }

    // READ BY ID
    public Restaurant getRestaurantById(int id) {
        if (!restaurantMap.containsKey(id)) {
            throw new RestaurantNotFoundException("Restaurant not found!");
        }
        return restaurantMap.get(id);
    }

    // UPDATE
    public void updateRestaurant(int id, String newName) {
        if (!restaurantMap.containsKey(id)) {
            throw new RestaurantNotFoundException("Restaurant not found!");
        }

        restaurantMap.get(id).setName(newName);
    }

    // DELETE
    public void deleteRestaurant(int id) {
        if (!restaurantMap.containsKey(id)) {
            throw new RestaurantNotFoundException("Restaurant not found!");
        }

        restaurantMap.remove(id);
    }

    // 🔥 GET VEG ITEMS
    public List<MenuItem> getVegItems(int restaurantId) {
        Restaurant r = restaurantMap.get(restaurantId);

        if (r == null) return new ArrayList<>();

        return r.getMenu()
                .stream()
                .filter(item -> item.isVeg())
                .toList();
    }

    // 🔥 GET NON-VEG ITEMS
    public List<MenuItem> getNonVegItems(int restaurantId) {
        Restaurant r = restaurantMap.get(restaurantId);

        if (r == null) return new ArrayList<>();

        return r.getMenu()
                .stream()
                .filter(item -> !item.isVeg())
                .toList();
    }

    // 🔥 SORT MENU BY PRICE
    public List<MenuItem> sortMenuByPrice(int restaurantId) {
        Restaurant r = restaurantMap.get(restaurantId);

        if (r == null) return new ArrayList<>();

        return r.getMenu()
                .stream()
                .sorted((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                .toList();
    }
}