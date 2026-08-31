# Food Delivery System 🍔🚚

A console-based **Food Delivery Management System** built in **Java**.

This project was created to practice **Java Object-Oriented Programming** and **Data Structures**, especially `ArrayList`, `Queue`, searching, recursion, and basic algorithm analysis.

## About the Project

The system simulates the basic operations of a food delivery application.

It manages:

- Customers
- Restaurants
- Delivery people
- Orders
- Pending deliveries

Customers can place orders from restaurants, and pending orders are stored in a queue until an available delivery person is assigned.

## Features

- Add customers
- Add restaurants
- Add featured restaurants at the beginning of the restaurant list
- Add delivery people
- Place food orders
- Automatically generate unique IDs
- Automatically calculate delivery fees
- Store pending orders in a queue
- Assign the next pending order to an available delivery person
- Track orders by ID
- Cancel orders
- Complete orders
- Automatically make a delivery person available again after completing an order
- Search for customers, restaurants, and orders by ID
- Display all customers
- Display all restaurants
- Display all delivery people
- Display all orders
- Display the next pending order
- Replace or remove restaurants
- Remove all orders
- Calculate total revenue using recursion

## Delivery Fee System

The delivery fee is calculated depending on the food price:

- Food price below `$10` → `$2` delivery fee
- Food price from `$10` to `$30` → `$3` delivery fee
- Food price above `$30` → `$5` delivery fee

## Order Status

Orders can move through different states such as:

- `Pending`
- `Assigned`
- `Delivered`
- `Cancelled`

When an order is created, it is automatically added to the pending-order queue.

When a delivery person becomes available, the next pending order can be assigned to them.

## Data Structures Used

### ArrayList

`ArrayList` is used to store:

- Customers
- Restaurants
- Delivery people
- Orders

This allows the system to dynamically add and manage objects without using fixed-size arrays.

### Queue

A `Queue<Order>` implemented using `ArrayDeque` is used to manage pending orders.

The queue follows the **FIFO (First In, First Out)** principle, meaning the first order placed is the first pending order considered for delivery.

### Recursion

Recursion is used to calculate the total revenue from the stored orders.

## Main Classes

### `Customer`

Represents a customer and stores:

- Customer ID
- Name
- Phone number
- Address

Each customer receives an automatically generated unique ID.

### `Restaurant`

Represents a restaurant and stores:

- Restaurant ID
- Name
- Location
- Food type

Each restaurant also receives an automatically generated unique ID.

### `DeliveryPerson`

Represents a delivery worker and stores:

- Delivery person ID
- Name
- Phone number
- Availability status

A delivery person can be either:

- Available
- Busy

### `Order`

Represents a food order and stores:

- Order ID
- Customer
- Restaurant
- Food name
- Food price
- Delivery fee
- Assigned delivery person
- Order status
- Order date

Orders automatically receive a unique ID and the current date when they are created.

### `FoodDeliverySystem`

Contains the main logic of the application.

It manages all customers, restaurants, delivery people, orders, and pending orders.

It is responsible for operations such as:

- Placing orders
- Assigning deliveries
- Tracking orders
- Cancelling and completing orders
- Searching records
- Managing restaurants
- Displaying stored information
- Calculating total revenue

### `Main`

Contains the console menu and handles interaction between the user and the food delivery system.

## Menu Options

The program provides the following operations:

1. Add Customer
2. Add Restaurant
3. Add Delivery Person
4. Place Order
5. Assign Next Delivery
6. Track Order
7. Cancel Order
8. Complete Order
9. Display Customers
10. Display Restaurants
11. Display Delivery People
12. Display Orders
13. Display Next Pending Order
14. Display Total Revenue
15. Replace or Remove Restaurant
16. Remove All Orders
0. Exit

## Java Concepts Practiced

This project applies several important Java concepts:

- Classes and Objects
- Encapsulation
- Constructors
- Getters and Setters
- Static Variables
- Method Overriding
- `equals()`
- `toString()`
- ArrayList
- Queue
- ArrayDeque
- Searching
- Recursion
- Loops and Conditions
- Object References
- Input Handling with `Scanner`
- Basic Time Complexity Analysis

## Project Structure

Food-Delivery-System-Java-DS/
│
├── src/
│   ├── Main.java
│   ├── FoodDeliverySystem.java
│   ├── Customer.java
│   ├── Restaurant.java
│   ├── DeliveryPerson.java
│   └── Order.java
│
├── README.md
└── .gitignore

## Technologies Used

- Java
- Java Collections Framework
- Object-Oriented Programming
- Data Structures
- IntelliJ IDEA

## How to Run

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA or another Java IDE.
3. Open `Main.java`.
4. Run the `main()` method.
5. Use the console menu to interact with the system.

## Project Limitations

- The application runs only in the console.
- Data is stored in memory and is lost when the program closes.
- There is no database.
- There is no graphical user interface.
- The project focuses on practicing Java, OOP, and data structures rather than implementing a complete production food-delivery platform.

## Purpose

The main purpose of this project is to apply **Java Data Structures and Object-Oriented Programming** concepts to a practical system.

It demonstrates how collections such as `ArrayList` and `Queue` can be used to manage real-world objects and workflows such as customers, restaurants, delivery workers, and food orders.

## Author

**Ahmad Yassine**

Computer Science Student