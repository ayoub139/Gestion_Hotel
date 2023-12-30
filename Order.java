public class Order {
    public int id;
    public int price;
    public ROOM room;
    public String name;


    public Order(int id, int price, ROOM room, String name) {
        this.id = id;
        this.price = price;
        this.room = room;
        this.name = name;
    }

    //getters
    public int getId(){return id;}

    public int getPrice(){return price;}

    public ROOM getRoom(){return room;}

    public String getName(){return name;}

    //Setters

    public void setPrice(int p)
    {
        this.price = p;
    }

    public void setRoom(ROOM room)
    {
        this.room = room;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}




