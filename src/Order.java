import java.sql.SQLOutput;
import java.time.LocalDate;

public class Order {
    private final int orderId;
    private LocalDate day;
    private Customer customer;
    private Restaurant restaurant;
    private DeliveryPerson deliveryPerson;
    private String foodName;
    private double foodPrice;
    private double deliveryFee;
    private String status;

    private static int ids=0;

    public Order(Customer customer, Restaurant restaurant, String foodName, double foodPrice, double deliveryFee) {
        this.orderId = ++ids;
        this.customer = customer;
        this.restaurant = restaurant;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.deliveryFee = deliveryFee;
        this.status = "Pending";
        this.deliveryPerson = null;

        this.day = LocalDate.now();;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public String getStatus() {
        return status;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        if(deliveryPerson == null)
            System.out.println("Delivery Persson not found!");
        this.deliveryPerson = deliveryPerson;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Order order = (Order)obj;
        return order.getOrderId() == this.getOrderId();
    }

    public String toString() {
        String deliveryName = "Not assigned yet";
        if (deliveryPerson != null) {
            deliveryName = deliveryPerson.getName();
        }

        return "Order ID: " + orderId +
                ", Customer: " + customer.getName() +
                ", Restaurant: " + restaurant.getName() +
                ", Food: " + foodName +
                ", Food Price: $" + foodPrice +
                ", Delivery Fee: $" + deliveryFee +
                ", Delivery Person: " + deliveryName +
                ", Status: " + status +
                ", Day: " + day;
    }
}
