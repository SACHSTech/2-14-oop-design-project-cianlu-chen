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

    public ShoppingCart getShoppingCart(int i){
        return shoppingCarts.get(i);
    }
    
    public int getNumCarts(){
        return shoppingCarts.size();
    }

    public String getACart(int num){
        List<String> carts = new ArrayList<>();

        for(int i = 0; i < shoppingCarts.size(); i++){
            carts.add(shoppingCarts.get(i).getUser() + ": " + shoppingCarts.get(i).getNumItems() + " items (User ID: " + shoppingCarts.get(i).getUserID() + ")");
        }

        return carts.get(num);
    }

    // public String getOneCart(int num){
    //     String theCart = "";

    //     for(int i = 0; i < shoppingCarts.size(); i++){
    //         if(shoppingCarts.get(i).getUserID() == num){
    //             theCart = (shoppingCarts.get(i).getUser() + "'s cart has " + shoppingCarts.get(i).getNumItems() + " items:");
    //         }
    //     }

    //     return theCart;
    // }

    public void makeSale(int num){
        sales++;
        revenue = revenue + shoppingCarts.get(num).getTotal();
    }
}
