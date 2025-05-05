import java.util.ArrayList;
import java.util.List;

public class Store {
    private int sales = 0;
    private double revenue = 0.0;
    private List<ShoppingCart> shoppingCarts;

    public Store(){
        shoppingCarts = new ArrayList<ShoppingCart>();
    }

    public void addCart(ShoppingCart shoppingCart){
        shoppingCarts.add(shoppingCart);
    }

    public ShoppingCart getShoppingCart(int num){
        return shoppingCarts.get(num);
    }
    
    public int getNumCarts(){
        return shoppingCarts.size();
    }

    public String printACart(int num){
        List<String> carts = new ArrayList<>();

        for(int i = 0; i < shoppingCarts.size(); i++){
            carts.add(shoppingCarts.get(i).getUser() + ": " + shoppingCarts.get(i).getNumItems() + " items (User ID: " + shoppingCarts.get(i).getUserID() + ")");
        }

        return carts.get(num);
    }

    public void makeSale(int num){
        sales++;
        revenue = revenue + shoppingCarts.get(num).getTotal();
    }

    public int getSales(){
        return sales;
    }

    public double getRevenue(){
        return revenue;
    }
}
