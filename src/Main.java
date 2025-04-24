import java.util.List;

public class Main{
    public static void main(String[] args) {
        Store store = new Store();

        ShoppingCart cart1 = new ShoppingCart(0, 0, "Dan");
        ShoppingCart cart2 = new ShoppingCart(0, 0, "Kim");

        store.addCart(cart1);
        store.addCart(cart2);

        for(int i = 0; i < store.numCarts(); i++){
            System.out.println(store.getCarts(i));
        }
    }
}
