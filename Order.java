public class Order {
    public int id;
    public int price;
    public Room room;
    public String name;


    public Order(int id, int price, Room room, String name) {
        this.id = id;
        this.price = price;
        this.room = room;
        this.name = name;
    }

    //getters
    public int getId(){return id;}

    public int getPrice(){return price;}

    public Room getRoom(){return room;}

    public String getName(){return name;}

    //Setters

    public void setPrice(int p)
    {
        this.price = p;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}




