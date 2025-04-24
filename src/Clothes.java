public class Clothes extends Product {
    private String size;
    private String colour;

    public Clothes(int id, double price, String name, int stock, String size, String colour){
        super(id, price, name, stock);
        this.size = size;
        this.colour = colour;
    }

    public String toString(){
        return "ID: " + getID() + ", " + getName() + "(" + size + ", " + colour + "), $" + getPrice() + ", " + getStock() + " in stock"; 
    }
}
