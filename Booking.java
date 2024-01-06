import java.util.Date;
import java.util.List;

public class Booking {
    public int id;
    public Room room;
    public Date startDate;
    public Date endDate;
    public Client client;
    public List<Order> orders;

    public Booking(int id, Room room, Date startDate, Date endDate, Client client, List<Order> orders) {
        this.id = id;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Client getClient() {
        return client;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
