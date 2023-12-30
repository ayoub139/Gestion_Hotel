public class Bill {
    public int id;
    public Booking booking;
    public  int total;

    public Bill(int id, Booking booking,int total ){
        this.id = id;
        this.booking = booking;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    public int getTotal() {
        return total;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    public void setTotal(int total){
        this.total= total;
    }
}
