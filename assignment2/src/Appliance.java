public abstract class Appliance extends Product {
    int wattage;
    String color;
    String brand;

    public Appliance(double price, int quantity , int wattage, String color, String brand) {
        super(price, quantity);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
    }

    public int getWattage() { return wattage; }
    public String getColor() { return color; }
    public String getBrand() { return brand; }

    public String stringTemplate() {
        return String.format(", %d watts and the color is %s (%.2f dollars each with %d in stock and %d sold)" +
                "", getWattage(), getColor(), getPrice(), getStockQuantity(), getSoldQuantity());
    }
}
