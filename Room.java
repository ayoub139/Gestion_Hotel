import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Room {
    public int id;
    public int price;

    public boolean availability;

    public Room(int price ,  boolean availability)
    {
        this.id = generateRandom();
        this.price = price;
        this.availability = availability;
    }
    //Get a random id
    protected static int generateRandom(){
        Random random = new Random();
        return random.nextInt(9999);
    }
    //Getters
    public int getId(){return id ;}
    public String getCategoryName() {
        return "Base Room";
    }
    public void getRoomDetails() {
        System.out.println("Room Details: ID - " + getId() + ", Category - " + getCategoryName() + ", Price - " + getPrice());
    }


    public int getPrice(){return price;}

    public boolean getAvailability(){return availability;}

    //Setters


    public void setPrice(int p)
    {
        this.price = p;
    }

    public void setAvailability(boolean avb)
    {
        this.availability = avb;
    }




}
