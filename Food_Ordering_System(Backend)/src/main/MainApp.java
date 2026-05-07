package main;

import model.*;
import service.*;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RestaurantService restaurantService = new RestaurantService();
        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        while (true) {
        	
        	System.out.println("-----------------------");
        	System.out.println("-----------------------");
            System.out.println("FOOD ORDERING SYSTEM");
            System.out.println("-----------------------");
            System.out.println("-----------------------");

            System.out.println("1. Add Restaurant");
            System.out.println("2. View Restaurants");
            System.out.println("3. Update Restaurant");
            System.out.println("4. Delete Restaurant");
            System.out.println("-----------------------");

            System.out.println("5. Add User");
            System.out.println("6. View Users");
            System.out.println("7. Update User");
            System.out.println("8. Delete User");
            System.out.println("-----------------------");

            System.out.println("9. Create Order");
            System.out.println("10. View Orders");
            System.out.println("11. Delete Order");
            System.out.println("-----------------------");

            System.out.println("12. Exit");
            System.out.println("-----------------------");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter Restaurant ID: ");
                        int rid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String rname = sc.nextLine();

                        System.out.print("Enter Location: ");
                        String loc = sc.nextLine();

                        // 🔥 Add default menu items
                        List<MenuItem> menu = new ArrayList<>();

                        menu.add(new MenuItem(1, "Burger", 100, false));
                        menu.add(new MenuItem(2, "Pizza", 200, true));
                        menu.add(new MenuItem(3, "Fries", 80, true));

                        restaurantService.addRestaurant(
                                new Restaurant(rid, rname, loc, menu)
                        );

                        System.out.println("Restaurant Added Successfully!");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        restaurantService.getAllRestaurants()
                                .forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Restaurant ID: ");
                        int urid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        restaurantService.updateRestaurant(urid, newName);
                        System.out.println("Updated!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter Restaurant ID: ");
                        int drid = sc.nextInt();

                        restaurantService.deleteRestaurant(drid);
                        System.out.println("Deleted!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Enter User ID: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String uname = sc.nextLine();

                        System.out.print("Enter Address: ");
                        String addr = sc.nextLine();

                        userService.addUser(new User(uid, uname, addr));
                        System.out.println("User Added!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        userService.getAllUsers()
                                .forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        System.out.print("Enter User ID: ");
                        int uuid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String unameNew = sc.nextLine();

                        userService.updateUser(uuid, unameNew);
                        System.out.println("Updated!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        System.out.print("Enter User ID: ");
                        int duid = sc.nextInt();

                        userService.deleteUser(duid);
                        System.out.println("Deleted!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        System.out.print("Enter Order ID: ");
                        int oid = sc.nextInt();

                        System.out.print("Enter User ID: ");
                        int userId = sc.nextInt();

                        System.out.print("Enter Restaurant ID: ");
                        int restId = sc.nextInt();

                        User user = userService.getUserById(userId);
                        Restaurant restaurant = restaurantService.getRestaurantById(restId);

                        List<MenuItem> menu = restaurant.getMenu();

                        if (menu.isEmpty()) {
                            System.out.println("No items available in this restaurant!");
                            break;
                        }

                        // Show menu clearly
                        System.out.println("\nMenu Items:");
                        for (MenuItem item : menu) {
                            System.out.println("ID: " + item.getId() +
                                    " | Name: " + item.getName() +
                                    " | Price: ₹" + item.getPrice());
                        }

                        // Take item input
                        List<MenuItem> selectedItems = new ArrayList<>();

                        System.out.println("\nEnter item IDs to order (enter -1 to stop):");

                        while (true) {
                            int itemId = sc.nextInt();

                            if (itemId == -1) break;

                            boolean found = false;

                            for (MenuItem item : menu) {
                                if (item.getId() == itemId) {
                                    selectedItems.add(item);
                                    found = true;
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("Invalid item ID!");
                            }
                        }

                        if (selectedItems.isEmpty()) {
                            System.out.println("No items selected!");
                            break;
                        }

                        Order order = orderService.createOrder(oid, user, restaurant, selectedItems);

                        System.out.println("\nOrder Created Successfully!");
                        System.out.println(order);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        orderService.getAllOrders()
                                .forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 11:
                    try {
                        System.out.print("Enter Order ID: ");
                        int doid = sc.nextInt();

                        orderService.deleteOrder(doid);
                        System.out.println("Order Deleted!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 12:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        
    }
    
}