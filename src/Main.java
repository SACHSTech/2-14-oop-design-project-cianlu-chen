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
        int itemChoice = 0;
        Store store = new Store();

        readProducts();

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
                        if(store.getShoppingCart(i).getUserID() == choice){
                            for(int j = 0; j < store.getShoppingCart(choice).getNumProducts(); j++){
                                System.out.println(store.getShoppingCart(choice).getProducts(j));
                            }
                        }
                    }

                    break;
                
                case 4:
                    getAllProducts();
                    
                    break;

                case 5:
                    System.out.println("---Option Menu---");
                    System.out.println("1. Food");
                    System.out.println("2. Clothes");
                    System.out.print("Choose a menu option: ");
                    choice = Integer.parseInt(userChoice.readLine());
                    switch(choice){
                        case 1:
                            System.out.println("---Displaying all food items---");
                            for(int i = 0; i < products.size(); i++){
                                if(products.get(i).getClass().equals(Food.class)){
                                    System.out.println(products.get(i));
                                }
                            }

                            break;
                        
                        case 2:
                            System.out.println("---Displaying all clothing items---");
                            for(int i = 0; i < products.size(); i++){
                                if(products.get(i).getClass().equals(Clothes.class)){
                                    System.out.println(products.get(i));
                                }
                            }

                            break;
                    }

                    break;

                case 6:
                    System.out.print("Please enter the user ID of the cart you wish to add an item to: ");
                    choice = Integer.parseInt(userChoice.readLine());

                    System.out.print("Please enter the ID of the item you wish to add: ");
                    itemChoice = Integer.parseInt(userChoice.readLine());
                    
                    store.getShoppingCart(choice).addProduct(products.get(itemChoice - 1));
                    System.out.println(products.get(itemChoice - 1).getName() + " added to " + store.getShoppingCart(choice).getUser() + "'s cart");

                    break;

                case 7:
                    System.out.print("Please enter the user ID of the cart you wish to remove an item from: ");
                    choice = Integer.parseInt(userChoice.readLine());

                    System.out.println(store.getACart(choice));

                    for(int i = 0; i < store.getNumCarts(); i++){
                        if(store.getShoppingCart(i).getUserID() == choice){
                            for(int j = 0; j < store.getShoppingCart(choice).getNumProducts(); j++){
                                System.out.println(store.getShoppingCart(choice).getProducts(j) + " ID: " + store.getShoppingCart(choice).getAProduct(j).getID());
                            }
                        }
                    }

                    System.out.print("Please enter the ID of the item you wish to remove: ");
                    itemChoice = Integer.parseInt(userChoice.readLine());
                    
                    store.getShoppingCart(choice).removeProduct(itemChoice);
                    System.out.println(products.get(itemChoice - 1).getName() + " removed from " + store.getShoppingCart(choice).getUser() + "'s cart");

                    break;

                case 8:
                    System.out.print("Please enter the user ID of the cart you wish to checkout: ");
                    choice = Integer.parseInt(userChoice.readLine());

                    store.makeSale(choice);

                    System.out.println("-----Thank you for checking out-----");
                    for(int i = 0; i < store.getShoppingCart(choice).getNumProducts(); i++){
                        System.out.println(store.getShoppingCart(choice).getProducts(i) + ", $" + store.getShoppingCart(choice).getAProduct(i).getPrice());
                    }

                    System.out.printf("Subtotal: $%.2f%n", store.getShoppingCart(choice).getSubtotal());
                    System.out.printf("Total (Tax 13%%): $%.2f%n", store.getShoppingCart(choice).getTotal());

                    store.getShoppingCart(choice).removeAll();

                    break;

                case 9:
                    System.out.println("Total sales: " + store.getSales());
                    System.out.printf("Total revenue: $%.2f%n", store.getRevenue());
                
                    break;

                case 10:
                    System.out.println("Thank you for shopping!");

                    break;

                default:
                    System.out.println("That's not a valid choice.");

                    break;
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
