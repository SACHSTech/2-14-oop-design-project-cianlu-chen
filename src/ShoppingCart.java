import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String user;
    private int userID;
    private List<Product> products = new ArrayList<>();
    
    public ShoppingCart(String user, int userID){
        this.user = user;
        this.userID = userID;
    }

    public void addProduct(Product product){
        if(product.getStock() > 0){
            products.add(product);
            product.setStock();
        }

        else{
            System.out.println("Sorry, the item " + product.getName() + " is out stock");
        }
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public int getNumItems(){
        return products.size();
    }

    public String getUser(){
        return user;
    }

    public int getUserID(){
        return userID;
    }
}
