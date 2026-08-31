import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

public class FoodDeliverySystem {
    private ArrayList<Customer> customers;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<DeliveryPerson> deliveryPeople;
    private ArrayList<Order> orders;
    private Queue<Order> pendingOrders;

    public FoodDeliverySystem() {
        customers = new ArrayList<>();
        restaurants = new ArrayList<>();
        deliveryPeople = new ArrayList<>();
        orders = new ArrayList<>();
        pendingOrders = new ArrayDeque<>();
    }




    //------------------------------------------------------------------------------------------------------------------------------
    // Core Methods

    // Big-O: O(1)
    public void addCustomer(Customer customer) {
        customers.add(customer); // ArrayList add()
        System.out.println("Customer added successfully.");
    }

    // Big-O: O(1)
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant); // ArrayList add()
        System.out.println("Restaurant added successfully.");
    }

    // Big-O: O(1)
    public void addFeaturedRestaurant(Restaurant restaurant) {
        restaurants.add(0, restaurant); // ArrayList add(index, element)
        System.out.println("Featured restaurant added at the beginning successfully.");
    }

    // Big-O: O(1)
    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
        deliveryPeople.add(deliveryPerson); // ArrayList add()
        System.out.println("Delivery person added successfully.");
    }


    // Big-O: O(n)
    public void placeOrder(int customerId, int restaurantId, String foodName, double foodPrice) {
        Customer customer = searchCustomerById(customerId);
        Restaurant restaurant = searchRestaurantById(restaurantId);

        if (customer == null) {
            System.out.println("Customer not found. Order was not placed.");
            return;
        }

        if (restaurant == null) {
            System.out.println("Restaurant not found. Order was not placed.");
            return;
        }

        double fee = calculateDeliveryFee(foodPrice);
        Order order = new Order(customer, restaurant, foodName, foodPrice, fee);

        orders.add(order);          // ArrayList add()
        pendingOrders.offer(order); // Queue offer()

        System.out.println("Order placed successfully and added to pending delivery queue.");
    }

    // Big-O: O(n)
    public void assignNextDelivery() {
        if (pendingOrders.peek() == null) { // Queue peek()
            System.out.println("There are no pending orders.");
            return;
        }

        DeliveryPerson availablePerson = getAvailableDeliveryPerson();

        if (availablePerson == null) {
            System.out.println("No delivery person is available now.");
            return;
        }

        Order order = pendingOrders.poll(); // Queue poll()
        order.setDeliveryPerson(availablePerson);
        order.setStatus("Assigned");
        availablePerson.setAvailable(false);

        System.out.println("Order assigned successfully.");
        System.out.println(order);
    }

    // Big-O: O(n)
    public void trackOrder(int orderId) {
        Order order = searchOrderById(orderId);

        if (order == null) {
            System.out.println("Order not found.");
        } else {
            System.out.println(order);
        }
    }

    // Big-O: O(n)
    public void cancelOrder(int orderId) {
        Order order = searchOrderById(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        order.setStatus("Cancelled");
        pendingOrders.remove(order); // Queue remove(Object)

        System.out.println("Order cancelled successfully.");
    }

    // Big-O: O(n)
    public void completeOrder(int id){
        Order orderToComplete = searchOrderById(id);
        if(orderToComplete == null) {
            System.out.println("Order not found!");
            return;
        }

        DeliveryPerson person = orderToComplete.getDeliveryPerson();
        if(person != null)
            person.setAvailable(true);

        orderToComplete.setStatus("Delivered");
        System.out.println("Order completed successfully.");
    }

    // Big-O: O(n)
    public void removeRestaurant(int id) {
        Restaurant restaurantToRemove = searchRestaurantById(id);

        if(restaurantToRemove != null)
        {
            restaurants.remove(restaurantToRemove);
            System.out.println("Restaurant removed successfully.");
        }
        else
        {
            System.out.println("Invalid restaurant id.");
        }

    }

    // Big-O: O(n)
    public void clearOrders() {
        orders.clear(); // ArrayList clear()
        pendingOrders.clear();
        System.out.println("All orders were removed.");
    }


    // Big-O: O(n)
    public void replaceOrRemoveRestaurant(int restaurantId, Restaurant newRestaurant, String action) {
        Restaurant restaurant = searchRestaurantById(restaurantId);

        if (restaurant == null || !restaurants.contains(restaurant)) { // ArrayList contains()
            System.out.println("Restaurant not found.");
            return;
        }

        int index = restaurants.indexOf(restaurant); // ArrayList indexOf()

        if (action.equalsIgnoreCase("replace")) {
            restaurants.set(index, newRestaurant); // ArrayList set()
            System.out.println("Restaurant replaced successfully.");
        }
        else if (action.equalsIgnoreCase("remove")) {
            restaurants.remove(index); // ArrayList remove(int)
            System.out.println("Restaurant removed successfully.");
        }
        else {
            System.out.println("Invalid action. Use replace or remove.");
        }
    }

























    //------------------------------------------------------------------------------------------------------------------------------
    // Helper Method
    public double calculateDeliveryFee(double foodPrice) {
        if (foodPrice < 10) {
            return 2.0;
        } else if (foodPrice <= 30) {
            return 3.0;
        } else {
            return 5.0;
        }
    }







    //------------------------------------------------------------------------------------------------------------------------------
    // Searching Methods

    public Customer searchCustomerById(int customerId) {
        for (int i = 0; i < customers.size(); i++) { // ArrayList size()
            Customer customer = customers.get(i);    // ArrayList get()
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public Restaurant searchRestaurantById(int restaurantId) {
        for (int i = 0; i < restaurants.size(); i++) { // ArrayList size()
            Restaurant restaurant = restaurants.get(i); // ArrayList get()
            if (restaurant.getRestaurantId() == restaurantId) {
                return restaurant;
            }
        }
        return null;
    }

    public Order searchOrderById(int orderId) {
        for (int i = 0; i < orders.size(); i++) { // ArrayList size()
            Order order = orders.get(i);          // ArrayList get()
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public DeliveryPerson getAvailableDeliveryPerson() {
        for (int i = 0; i < deliveryPeople.size(); i++) { // ArrayList size()
            DeliveryPerson person = deliveryPeople.get(i); // ArrayList get()
            if (person.isAvailable()) {
                return person;
            }
        }
        return null;
    }















    //-------------------------------------------------------------------------------------------------------------------------------
    // Display Methods

    public void displayCustomers() {
        if (customers.isEmpty()) { // ArrayList isEmpty()
            System.out.println("No customers found.");
            return;
        }

        for (int i = 0; i < customers.size(); i++) { // ArrayList size()
            System.out.println(customers.get(i));    // ArrayList get()
        }
    }

    public void displayRestaurants() {
        if (restaurants.isEmpty()) { // ArrayList isEmpty()
            System.out.println("No restaurants found.");
            return;
        }

        for (int i = 0; i < restaurants.size(); i++) { // ArrayList size()
            System.out.println(restaurants.get(i));    // ArrayList get()
        }
    }

    public void displayDeliveryPeople() {
        if (deliveryPeople.isEmpty()) { // ArrayList isEmpty()
            System.out.println("No delivery people found.");
            return;
        }

        for (int i = 0; i < deliveryPeople.size(); i++) { // ArrayList size()
            System.out.println(deliveryPeople.get(i));    // ArrayList get()
        }
    }

    public void displayOrders() {
        if (orders.isEmpty()) { // ArrayList isEmpty()
            System.out.println("No orders found.");
            return;
        }

        for (int i = 0; i < orders.size(); i++) { // ArrayList size()
            System.out.println(orders.get(i));    // ArrayList get()
        }
    }

    public void displayNextPendingOrder() {
        Order nextOrder = pendingOrders.peek(); // Queue peek()

        if (nextOrder == null) {
            System.out.println("There are no pending orders.");
        } else {
            System.out.println("Next pending order:");
            System.out.println(nextOrder);
        }
    }

    public void displayTotalRevenue() {
        System.out.println("Total Revenue is: $" + calculateTotalRevenueRecursive(0));
    }









    //-------------------------------------------------------------------------------------------------------------------------------
    // Recursive Method

    // Big-O: O(n)
    public double calculateTotalRevenueRecursive(int index) {
        if (index >= orders.size()) {
            return 0;
        }
        return orders.get(index).getFoodPrice() + calculateTotalRevenueRecursive(index + 1);
    }


}













