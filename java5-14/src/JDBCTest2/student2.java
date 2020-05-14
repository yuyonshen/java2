package JDBCTest2;

public class student2 {
    private int id;
    private String Vegetable;
    private double Price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVegetable() {
        return Vegetable;
    }

    public void setVegetable(String vegetable) {
        Vegetable = vegetable;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "student2{" +
                "id=" + id +
                ", Vegetable='" + Vegetable + '\'' +
                ", Price=" + Price +
                '}';
    }
}
