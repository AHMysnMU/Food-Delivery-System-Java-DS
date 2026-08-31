public class Restaurant {
    private final int restaurantId;
    private String name;
    private String location;
    private String foodType;

    private static int ids=0;

    public Restaurant(String name, String location, String foodType) {
        this.restaurantId = ++ids;
        this.name = name;
        this.location = location;
        this.foodType = foodType;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Restaurant restaurant = (Restaurant)obj;
        return restaurant.getRestaurantId() == this.getRestaurantId();
    }

    public String toString() {
        return "Restaurant ID: " + restaurantId +
                ", Name: " + name +
                ", Location: " + location +
                ", Food Type: " + foodType;
    }
}
