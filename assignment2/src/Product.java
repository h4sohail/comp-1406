public abstract class Product {
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public int getSoldQuantity() { return soldQuantity; }

    public void setSoldQuantity(int soldQuantity){
        this.soldQuantity = soldQuantity;
    }

    public Product(double price, int quantity) {
        this.price = price;
        this.stockQuantity = quantity;
    }

    public double sellUnits(int amount) {
        if(stockQuantity >= amount){
            double revenue = amount * price;
            stockQuantity -= amount;
            return revenue;
        }
        return 0.0;
    }
}
