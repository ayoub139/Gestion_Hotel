import java.util.Date;
public class Booking {
    public int id;
    public Room room;
    public Date startDate;
    public Date endDate;
    public Client client;

    public Booking(int id, Room room, Date startDate, Date endDate, Client client){
        this.id = id;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
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
    public Date getEndDate(){
        return  endDate;
    }

    public Client getClient() {
        return client;
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
}
