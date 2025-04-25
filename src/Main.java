import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader userChoice = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        int userID = 0;
        Store store = new Store();

        // ShoppingCart cart1 = new ShoppingCart( "Dan", 1);
        // ShoppingCart cart2 = new ShoppingCart( "Kim", 2);
        // Product shirt = new Clothes(0, 7.99, "Shirt", 30, "S", "White");
        // Product apple = new Food(1, 2.99, "Apple", 0, "Fruit");

        // store.addCart(cart1);
        // store.addCart(cart2);

        // cart1.addProduct(shirt);
        // cart1.addProduct(apple);

        while(choice != 9){
            System.out.println("---Option Menu---");
            System.out.println("1. Create a user");
            System.out.println("2. View all cart overview");
            System.out.println("3. View specific cart");
            System.out.println("4. View all products");
            System.out.println("5. Filter by type");
            System.out.println("6. Add a product");
            System.out.println("7. Remove a product");
            System.out.println("8. Checkout");
            System.out.println("9. Exit");
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
                        System.out.println(store.getAllCarts(i));
                    }

                    break;

                case 3:
                    System.out.print("Please enter the user ID of the cart you wish to view: ");
                    choice = Integer.parseInt(userChoice.readLine());

                    break;
            }
        }
    }
}
