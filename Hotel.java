import java.util.ArrayList;
import java.util.List;
public class Hotel {
    public List<Booking> booking;
    public List<ROOM> rooms;
    public List<Bill> bills;

    public Hotel()
    {
        this.booking = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    public List<ROOM> getRooms(){return this.rooms;}

    public List<Booking> getBooking(){return  this.booking;}

    public List<Bill> getBills(){return this.bills;}

    public void addRoom(ROOM room)
    {
        rooms.add(room);
    }

    public void addBooking(Booking book)
    {
        booking.add(book);
    }

    public void addRoom(Bill bill)
    {
        bills.add(bill);
    }
}
