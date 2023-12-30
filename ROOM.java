import java.util.ArrayList;
import java.util.List;
public class ROOM {
    public int id;
    public Category category;
    public int price;
    public List<Order> orders;
    public boolean availability;

    public ROOM(int id , Category category , int price , Order orders, boolean availability)
    {
        this.id = id;
        this.category = category;
        this.price = price;
        this.orders = new ArrayList<>();
        this.availability = availability;
    }
    //Getters
    public int getId(){return id ;}
    public Category getCategory(){return category;}
    public int getPrice(){return price;}
    public List<Order> getOrders(){return orders;}
    public boolean getavailability(){return availability;}

    //Setters

    public void setCategory(Category cat)
    {
        this.category = cat;
    }

    public void setPrice(int p)
    {
        this.price = p;
    }

    public void setAvailability(boolean avb)
    {
        this.availability = avb;
    }

    public void addOrder(Order order)
    {
      orders.add(order);
    }


}
