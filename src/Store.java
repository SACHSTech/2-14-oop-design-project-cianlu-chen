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
    
    public int getNumCarts(){
        return shoppingCarts.size();
    }

    public String getAllCarts(int num){
        List<String> carts = new ArrayList<>();

        for(int i = 0; i < shoppingCarts.size(); i++){
            carts.add(shoppingCarts.get(i).getUser() + ": " + shoppingCarts.get(i).getNumItems() + " items (User ID: " + shoppingCarts.get(i).getUserID() + ")");
        }

        return carts.get(num);
    }

    // public void getOneCart(int num){
    //     for(int i = 0; i < shoppingCarts.size(); i++){
    //         if(shoppingCarts.get(i).getUserID() == num){
    //             System.out.println(shoppingCarts.get(i).getUser() + "'s cart has " + shoppingCarts.get(i).getNumItems() + " items:");
    //         }
    //     }
    // }
}
