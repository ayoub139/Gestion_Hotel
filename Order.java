public class Order {
    public int id;
    public int price;
    public String name;

    public Order(int id, int price, String name) {

        this.id = id;
        this.price = price;
        this.name = name;
    }

    // getters
    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    // Setters

    public void setPrice(int p) {
        this.price = p;
    }

    public void setName(String name) {
        this.name = name;
    }
}
