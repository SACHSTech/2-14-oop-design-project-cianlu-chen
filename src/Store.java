import java.util.ArrayList;
import java.util.List;

public class Store {
    private int sales;
    private double revenue;
    private List<ShoppingCart> shoppingCarts;

    public Store(){
        shoppingCarts = new ArrayList<ShoppingCart>();
    }

    public void addCart(ShoppingCart shoppingCart){
        shoppingCarts.add(shoppingCart);
    }
    
    public int numCarts(){
        return shoppingCarts.size();
    }

    public String getCarts(int num){
        List<String> carts = new ArrayList<>();

        for(int i = 0; i < shoppingCarts.size(); i++){
            carts.add(shoppingCarts.get(i).getUser() + ": " + shoppingCarts.get(i).getItems() + " items");
        }

        return carts.get(num);
    }
}
