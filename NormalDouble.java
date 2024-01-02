import java.util.List;

public class NormalDouble extends Room{
    private int Bed;
    public NormalDouble(int price , List<Order> orders, boolean availability){
        super(price, orders, availability);
        this.Bed=2;
    }
    //redéfinition de méthode pour affichage du nom de catégory
    @Override
    public String getCategoryName() {
        return "Normal Double";
    }
}
