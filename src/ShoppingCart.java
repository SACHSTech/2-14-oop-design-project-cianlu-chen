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
            product.setNumInCart();
        }

        else{
            System.out.println("Sorry, the item " + product.getName() + " is out stock");
        }
    }

    public String getProducts(int i){
        List<String> productNames = new ArrayList<>();
        for(int j = 0; j < products.size(); j++){
            productNames.add(products.get(j).getName() + " x" + products.get(j).getNumInCart());
        }

        return productNames.get(i);
    }

    public Product getAProduct(int i){
        return products.get(i);
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

    public double getSubtotal(){
        double subtotal = 0.0;
        for(int i = 0; i < products.size(); i++){
            subtotal += products.get(i).getPrice();
        }

        return subtotal;
    }

    public double getTotal(){
        double subtotal = 0.0;
        for(int i = 0; i < products.size(); i++){
            subtotal += products.get(i).getPrice();
        }

        double total = subtotal * 1.13;

        return total;
    }
}
