public class Customer {
    private final int customerId;
    private String name;
    private String phone;
    private String address;

    private static int ids=0;

    public Customer(String name, String phone, String address) {
        this.customerId = ++ids;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Customer customer = (Customer)obj;
        return customer.getCustomerId() == this.getCustomerId();
    }

    public String toString() {
        return "Customer ID: " + customerId +
                ", Name: " + name +
                ", Phone: " + phone +
                ", Address: " + address;
    }
}
