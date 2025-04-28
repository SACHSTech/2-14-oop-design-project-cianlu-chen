public abstract class Product {
    private int id;
    private String category;
    private double price;
    private String name;
    private int stock;
    private int numInCart = 0;

    public Product(int id, String category, double price, String name, int stock){
        this.id = id;
        this.category = category;
        this.price = price;
        this.name = name;
        this.stock = stock;
    }

    public int getID(){
        return id;
    }

    public String getCategory(){
        return category;
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

    public int getNumInCart(){
        return numInCart;
    }

    public void setNumInCart(){
        numInCart++;
    }
}
