import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int items;
    private double subtotal;
    private String user;
    private List<Product> products = new ArrayList<>();
    
    public ShoppingCart(int items, double subtotal, String user){
        this.items = items;
        this.subtotal = subtotal;
        this.user = user;
    }

    public int getItems(){
        return items;
    }

    public double getSubtotal(){
        return subtotal;
    }

    public String getUser(){
        return user;
    }
}
