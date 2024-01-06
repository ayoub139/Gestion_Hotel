import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Hotel implements Serializable {

    public List<Booking> bookings;
    public List<Room> rooms;
    public List<Bill> bills;

    public Hotel(List<Booking> booking, List<Room> rooms, List<Bill> bills) {
        this.bookings = booking;
        this.rooms = rooms;
        this.bills = bills;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public List<Bill> getBills() {
        return this.bills;
    }

    public void addBooking(Booking book) {
        bookings.add(book);
        serializeHotel();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        serializeHotel();
    }

    public void addBill(Bill bill) {
        bills.add(bill);
        serializeHotel();
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getAvailability()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Room getRoomById(int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    public Booking getBookingById(int id) {
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                return booking;
            }
        }
        return null;
    }

    public Bill getBillById(int id) {
        for (Bill bill : bills) {
            if (bill.getId() == id) {
                return bill;
            }
        }
        return null;
    }

    public void displayRoomAvailability() {
        for (Room room : rooms) {
            System.out.println("Room ID: " + room.getId() + ", Availability: " + room.getAvailability());
        }
    }

    public void removeBooking(Booking booking) {
        booking.getRoom().setAvailability(true);
        bookings.remove(booking);
        serializeHotel();
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
        serializeHotel();
    }

    public void serializeHotel() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("hotel.ser"))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
