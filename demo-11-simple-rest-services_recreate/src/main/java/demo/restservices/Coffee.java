package demo.restservices;

import java.util.Objects;

public class Coffee {

    private long id;
    private String description;
    private double price;

    public Coffee(){

    }

    public Coffee(long id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return id == coffee.id && Double.compare(coffee.price, price) == 0 && Objects.equals(description, coffee.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, price);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
