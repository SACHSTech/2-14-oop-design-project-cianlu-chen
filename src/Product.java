public abstract class Product {
    private int id;
    private String category;
    private double price;
    private String name;
    private int stock;

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

    public void removeStock(){
        stock--;
    }

    public void addStock(){
        stock++;
    }

    public boolean inStock(){
        if(getStock() > 0){
            return true;
        }

        else{
            return false;
        }
    }
}
