public class NormalSimple extends Room {
    private int Bed;

    public NormalSimple(int price, boolean availability) {
        super(price, availability);
        this.Bed = 1;
    }

    // redéfinition de méthode pour affichage du nom de catégory
    @Override
    public String getCategoryName() {
        return "Normal Simple";
    }
}
