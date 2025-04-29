import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String user;
    private int userID;
    private int numItems = 0;
    private List<Product> products = new ArrayList<>();
    
    public ShoppingCart(String user, int userID){
        this.user = user;
        this.userID = userID;
    }

    public void addProduct(Product product){
        boolean noDupe = true;
        if(product.getStock() > 0){
            product.setStock();
            numItems++;

            for(int i = 0; i < products.size(); i++){
                if(product.getID() != products.get(i).getID()){
                    noDupe = true;
                }

                else{
                    noDupe = false;
                    products.get(products.size() - 1).setNumInCart();
                    break;
                }
            }

            if(noDupe){
                products.add(product);
                products.get(products.size() - 1).setNumInCart();
            }
        }

        else{
            System.out.println("Sorry, the item " + product.getName() + " is out stock");
        }
    }

    public void removeProduct(int num){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getID() == num){
                products.remove(i);
            }
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

    public int getNumProducts(){
        return products.size();
    }

    public int getNumItems(){
        return numItems;
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
            subtotal += products.get(i).getPrice() * products.get(i).getNumInCart();
        }

        return subtotal;
    }

    public double getTotal(){
        double subtotal = 0.0;
        for(int i = 0; i < products.size(); i++){
            subtotal += products.get(i).getPrice() * products.get(i).getNumInCart();;
        }

        double total = subtotal * 1.13;

        return total;
    }

    public void removeAll(){
        products.clear();
        numItems = 0;
    }
}
