public class Order {
    public int id;
    public int price;
    //public Booking booking;
    public String name;


    public Order(int id, int price, /*Booking booking,*/ String name) {

        this.id = id;
        this.price = price;
        //this.booking = booking;
        this.name = name;
    }

    //getters
    public int getId(){return id;}

    public int getPrice(){return price;}


    //public Booking getBooking(){return booking;}


    public String getName(){return name;}

    //Setters

    public void setPrice(int p)
    {
        this.price = p;
    }


    /*public void setRoom(Booking booking)

    {
        this.booking = booking;
    }*/

    public void setName(String name)
    {
        this.name = name;
    }
}




