public class LuxuryDouble extends Room {
    private boolean hasJacuzzi;
    private int Bed;

    public LuxuryDouble(int price, boolean availability, boolean hasJacuzzi) {
        super(price, availability);
        this.hasJacuzzi = hasJacuzzi;
        this.Bed = 2;
    }

    // redéfinition de méthode pour affichage du nom de catégory
    @Override
    public String getCategoryName() {
        return "Luxury Double";
    }

    @Override
    public void getRoomDetails() {
        System.out.println("Room Details: ID - " + getId() + ", Category - " + getCategoryName() + ", Price - "
                + getPrice() + " Jacuzzi :" + hasJacuzzi);
    }

    public boolean isHasJacuzzi() {
        return hasJacuzzi;
    }

}
