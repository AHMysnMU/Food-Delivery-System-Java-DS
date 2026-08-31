public class DeliveryPerson {
    private final int deliveryPersonId;
    private String name;
    private String phone;
    private boolean available;

    private static int ids=0;

    public DeliveryPerson(String name, String phone) {
        this.deliveryPersonId = ++ids;
        this.name = name;
        this.phone = phone;
        this.available = true;
    }

    public int getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        DeliveryPerson deliveryPerson = (DeliveryPerson)obj;
        return deliveryPerson.getDeliveryPersonId() == this.getDeliveryPersonId();
    }

    public String toString() {
        String status;
        if (available) {
            status = "Available";
        } else {
            status = "Busy";
        }

        return "Delivery Person ID: " + deliveryPersonId +
                ", Name: " + name +
                ", Phone: " + phone +
                ", Status: " + status;
    }
}
