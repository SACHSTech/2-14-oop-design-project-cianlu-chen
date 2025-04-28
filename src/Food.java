public class Food extends Product {
    private String group;

    public Food(int id, String category, double price, String name, int stock, String group){
        super(id, category, price, name, stock);
        this.group = group;
    }

    public String toString(){
        return "ID: " + getID() + ", " + getName() + "(" + group + "), $" + getPrice() + ", " + getStock() + " in stock"; 
    }
}
