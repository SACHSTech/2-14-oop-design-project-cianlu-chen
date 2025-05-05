public class Clothes extends Product {
    private String size;

    public Clothes(int id, String category, double price, String name, int stock, String size){
        super(id, category, price, name, stock);
        this.size = size;
    }

    public String toString(){
        return "ID: " + getID() + ", " + getName() + "(" + size + "), $" + getPrice() + ", " + getStock() + " in stock"; 
    }
}
