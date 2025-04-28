import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    static List<Product> products = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader userChoice = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        int userID = 0;
        Store store = new Store();

        readProducts();

        // ShoppingCart cart1 = new ShoppingCart( "Dan", 1);
        // ShoppingCart cart2 = new ShoppingCart( "Kim", 2);
        // Product shirt = new Clothes(0, 7.99, "Shirt", 30, "S", "White");
        // Product apple = new Food(1, 2.99, "Apple", 10, "Fruit");

        // store.addCart(cart1);
        // store.addCart(cart2);

        // cart1.addProduct(shirt);
        // cart1.addProduct(apple);

        // for(int i = 0; i < cart1.getNumItems(); i++){
        //     System.out.println(cart1.getProducts(i));
        // }

        while(choice != 10){
            System.out.println("---Option Menu---");
            System.out.println("1. Create a user");
            System.out.println("2. View all cart overview");
            System.out.println("3. View specific cart");
            System.out.println("4. View all products");
            System.out.println("5. Filter by type");
            System.out.println("6. Add a product");
            System.out.println("7. Remove a product");
            System.out.println("8. Checkout");
            System.out.println("9. View shop stats");
            System.out.println("10. Exit");
            System.out.print("Choose a menu option: ");
            choice = Integer.parseInt(userChoice.readLine());

            switch(choice){
                case 1:
                    System.out.print("What is your name?: ");
                    String user = userChoice.readLine();

                    ShoppingCart cart = new ShoppingCart(user, userID);
                    store.addCart(cart);
                    userID++;

                    break;

                case 2:
                    for(int i = 0; i < store.getNumCarts(); i++){
                        System.out.println(store.getACart(i));
                    }

                    break;

                case 3:
                    System.out.print("Please enter the user ID of the cart you wish to view: ");
                    choice = Integer.parseInt(userChoice.readLine());

                    System.out.println(store.getACart(choice));

                    for(int i = 0; i < store.getNumCarts(); i++){
                        if(i == choice){
                            for(int j = 0; j < store.getShoppingCart(j).getNumItems(); j++){
                                System.out.println(store.getShoppingCart(choice).getProducts(j));
                            }
                        }
                    }

                    break;
                
                case 4:
                    getAllProducts();
                    
                    break;

                case 9:
                    System.out.print("Please enter the user ID of the cart you wish to checkout: ");
                    choice = Integer.parseInt(userChoice.readLine());

                    store.makeSale(choice);

                    System.out.println("-----Thank you for checking out-----");
                    for(int i = 0; i < store.getShoppingCart(i).getNumItems(); i++){
                        System.out.println(store.getShoppingCart(i).getProducts(i) + ", $" + store.getShoppingCart(i).getAProduct(i).getPrice() * store.getShoppingCart(i).getAProduct(i).getNumInCart());
                    }

                    System.out.println("Subtotal: $" + store.getShoppingCart(choice).getSubtotal());
                    System.out.format("Total (Tax 13%): $%2f", store.getShoppingCart(choice).getTotal());
            }
        }
    }

     public static void readProducts(){
        try (BufferedReader productReader = new BufferedReader(new FileReader("src\\products.csv"))){
            String product;

            while ((product = productReader.readLine()) != null){
                String[] values = product.split(",");

                int id = Integer.parseInt(values[0]);
                String category = values[1];
                double price = Double.parseDouble(values[2]);
                String name = values[3];
                int stock = Integer.parseInt(values[4]);
                String extra = values[5];

                if(category.equals("Food")){
                    Product newProduct = new Food(id, category, price, name, stock, extra);
                       
                    products.add(newProduct);
                }

                else if(category.equals("Clothes")){
                    Product newProduct = new Clothes(id, category, price, name, stock, extra);
                       
                    products.add(newProduct);
                }
            }
        }
    
        catch (IOException e){
                
        }
    }

    public static void getAllProducts(){
        for(int i = 0; i < products.size(); i++){
            System.out.println(products.get(i));
        }
    }
}
