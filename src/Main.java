import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FoodDeliverySystem system = new FoodDeliverySystem();

        int choice;

        do {
            System.out.println();
            System.out.println("===== Food Delivery System =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Restaurant");
            System.out.println("3. Add Delivery Person");
            System.out.println("4. Place Order");
            System.out.println("5. Assign Next Delivery");
            System.out.println("6. Track Order");
            System.out.println("7. Cancel Order");
            System.out.println("8. complete Order");
            System.out.println("9. Display Customers");
            System.out.println("10. Display Restaurants");
            System.out.println("11. Display Delivery People");
            System.out.println("12. Display Orders");
            System.out.println("13. Display Next Pending Order");
            System.out.println("14. Display Total Revenue");
            System.out.println("15. remove/set Restaurant");
            System.out.println("16. Remove all orders");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = input.nextLine();

                    System.out.print("Enter customer phone: ");
                    String customerPhone = input.nextLine();

                    System.out.print("Enter customer address: ");
                    String customerAddress = input.nextLine();

                    Customer customer = new Customer(customerName, customerPhone, customerAddress);
                    system.addCustomer(customer);
                    space();
                    break;

                case 2:
                    System.out.print("Enter restaurant name: ");
                    String restaurantName = input.nextLine();

                    System.out.print("Enter restaurant location: ");
                    String location = input.nextLine();

                    System.out.print("Enter food type: ");
                    String foodType = input.nextLine();

                    System.out.print("Is the restaurant featured?(yes or no): ");
                    String isFeatured = input.nextLine();

                    Restaurant restaurant = new Restaurant(restaurantName, location, foodType);

                    if(isFeatured.equals("yes"))
                        system.addFeaturedRestaurant(restaurant);
                    else
                        system.addRestaurant(restaurant);

                    space();
                    break;

                case 3:
                    System.out.print("Enter delivery person name: ");
                    String deliveryName = input.nextLine();

                    System.out.print("Enter delivery person phone: ");
                    String deliveryPhone = input.nextLine();

                    DeliveryPerson deliveryPerson = new DeliveryPerson(deliveryName, deliveryPhone);
                    system.addDeliveryPerson(deliveryPerson);
                    space();
                    break;

                case 4:
                    System.out.print("Enter customer ID: ");
                    int orderCustomerId = input.nextInt();

                    System.out.print("Enter restaurant ID: ");
                    int orderRestaurantId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter food name: ");
                    String foodName = input.nextLine();

                    System.out.print("Enter food price: ");
                    double foodPrice = input.nextDouble();
                    input.nextLine();

                    system.placeOrder(orderCustomerId, orderRestaurantId, foodName, foodPrice);
                    space();
                    break;

                case 5:
                    system.assignNextDelivery();
                    space();
                    break;

                case 6:
                    System.out.print("Enter order ID to track: ");
                    int trackId = input.nextInt();
                    input.nextLine();
                    system.trackOrder(trackId);
                    space();
                    break;

                case 7:
                    System.out.print("Enter order ID to cancel: ");
                    int cancelId = input.nextInt();
                    input.nextLine();
                    system.cancelOrder(cancelId);
                    space();
                    break;

                case 8:
                    System.out.print("Enter order ID to complete: ");
                    int completeId = input.nextInt();
                    input.nextLine();
                    system.completeOrder(completeId);
                    space();
                    break;

                case 9:
                    system.displayCustomers();
                    space();
                    break;

                case 10:
                    system.displayRestaurants();
                    space();
                    break;

                case 11:
                    system.displayDeliveryPeople();
                    space();
                    break;

                case 12:
                    system.displayOrders();
                    space();
                    break;

                case 13:
                    system.displayNextPendingOrder();
                    space();
                    break;

                case 14:
                    system.displayTotalRevenue();
                    space();
                    break;

                case 15:
                    System.out.print("Enter restaurant ID: ");
                    int manageId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter action (replace or remove): ");
                    String action = input.nextLine();

                    if (action.equalsIgnoreCase("replace")) {
                        System.out.print("Enter new restaurant name: ");
                        String newName = input.nextLine();

                        System.out.print("Enter new restaurant location: ");
                        String newLocation = input.nextLine();

                        System.out.print("Enter new food type: ");
                        String newFoodType = input.nextLine();

                        Restaurant newRestaurant = new Restaurant(newName, newLocation, newFoodType);

                        system.replaceOrRemoveRestaurant(manageId, newRestaurant, action);
                    }
                    else if (action.equalsIgnoreCase("remove")) {
                        system.replaceOrRemoveRestaurant(manageId, null, action);
                    }
                    else {
                        System.out.println("Invalid action. Use replace or remove.");
                    }

                    space();
                    break;

                case 16:
                    system.clearOrders();
                    space();
                    break;


                case 0:
                    System.out.println("Program ended.");
                    space();
                    break;

                default:
                    System.out.println("Invalid choice.");
                    space();
            }
        } while (choice != 0);

        input.close();
    }





    public static void space(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }// waits 3 seconds


        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
