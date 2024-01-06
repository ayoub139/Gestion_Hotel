public class NormalDouble extends Room {
    private int Bed;

    public NormalDouble(int price, boolean availability) {
        super(price, availability);
        this.Bed = 2;
    }

    // redéfinition de méthode pour affichage du nom de catégory
    @Override
    public String getCategoryName() {
        return "Normal Double";
    }
}
