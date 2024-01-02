import java.util.List;

public class LuxurySimple extends Room {
    private boolean hasJacuzzi;
    private int Bed;
    public LuxurySimple( int price , List<Order> orders, boolean availability, boolean hasJacuzzi){
        super(price , orders, availability);
        this.hasJacuzzi=hasJacuzzi;
        this.Bed=1;
    }
    //redéfinition de méthode pour affichage du nom de catégory
    @Override
    public String getCategoryName() {
        return "Luxury Simple";
    }
    @Override
    public void getRoomDetails() {
        System.out.println("Room Details: ID - " + getId() + ", Category - " + getCategoryName() + ", Price - " + getPrice() +" Jacuzzi :" +hasJacuzzi);
    }

    public boolean isHasJacuzzi() {
        return hasJacuzzi;
    }
}
