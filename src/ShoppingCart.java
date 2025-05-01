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
            product.removeStock();
            products.add(product);
        }

        else{
            System.out.println("Sorry, the item " + product.getName() + " is out stock");
        }
    }

    public void removeProduct(int num){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getID() == num){
                products.remove(i);
                products.get(i).addStock();
            }
        }
    }

    public String printProductName(int num){
        List<String> productNames = new ArrayList<>();
        for(int i = 0; i < products.size(); i++){
            productNames.add(products.get(i).getName());
        }

        return productNames.get(num);
    }

    public Product getAProduct(int num){
        return products.get(num);
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

    public void removeAll(){
        products.clear();
    }

    public boolean isEmpty(){
        if(products.size() == 0){
            return true;
        }

        else{
            return false;
        }
    }

    public boolean productInCart(int num){
        boolean inCart = false;
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getID() == num){
                inCart = true;

            } 

            else{
                inCart = false;
            }
        } 

        return inCart;
    }
}
