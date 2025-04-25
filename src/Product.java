public abstract class Product {
    private int id;
    private double price;
    private String name;
    private int stock;

    public Product(int id, double price, String name, int stock){
        this.id = id;
        this.price = price;
        this.name = name;
        this.stock = stock;
    }

    public int getID(){
        return id;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(){
        stock--;
    }
}
