package kadai.model;

public class Sushi {
    final String name;
    final int price;
    private int stock;

    public Sushi(String name, int price, int stock) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean outOfStock() {
        if (stock <= 0) {
            return true;
        }
        return false;
    }

    
    public void reduceStock(int quantity) {
        stock -= quantity;
    }

    @Override
    public String toString() {
        return "Sushi{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
